package xxrexraptorxx.runecraft.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.api.distmarker.Dist;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BlockRuneStone extends Block {

	protected static final AABB CUSTOM_COLLISION_AABB = new AABB(0.0625D, 0.0625D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
	protected static final AABB NULL_AABB = new AABB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);


	public BlockRuneStone() {
		super(Properties.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(5.0F, 10.0F)
				.sound(SoundType.STONE)
				.color(MaterialColor.DEEPSLATE)
				.noOcclusion()
		);
	}

	//TODO Test
	public AABB getCustomCollisionAabb() {
		if(this == ModBlocks.RUNE_STONE_GHS.get()) {
			return NULL_AABB;
		} else {
			return CUSTOM_COLLISION_AABB;
		}
	}


	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
		return true;
	}

	//TODO test
	@Override
	public void animateTick(BlockState pState, Level world, BlockPos pos, Random pRandom) {
		Random rand = new Random();
		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 2.0F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}

/**		TODO
	@Override
	public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(ModBlocks.runeStone));

		if(this != ModBlocks.runeStone) {
			drops.add(new ItemStack(Item.++(References.MODID + ":rune_" + this.getName().toString().charAt(16))));
		}

		return drops;
	}**/

	/**
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			TileEntity te = world.getTileEntity(pos);

			if(te != null && te instanceof TileEntityRuneStone) {
				TileEntityRuneStone runestone = (TileEntityRuneStone) te;
				world.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.15F + 0.F);

				ItemStack itemstack = playerIn.getHeldItem(hand);
				String activeItem = playerIn.getHeldItem(hand).getItem().getUnlocalizedName();
				String activeBlock = world.getBlockState(pos).getBlock().getUnlocalizedName();

				//Empty runestone
				if(world.getBlockState(pos).getBlock() == ModBlocks.runeStone && !activeItem.contains("item.rune")) {
					playerIn.sendStatusMessage(new TextComponentTranslation("message.empty_runestone", new Object[] { 10}), true );
				}

				//Effects
				if(ConfigRuneStones.activateAreaEffectWhenRightClicked && this != ModBlocks.runeStone && activeBlock.length() == 17 && !activeItem.contains("item.rune")) {
					EntityAreaEffectCloud cloud = new EntityAreaEffectCloud(world, pos.getX(), pos.getY() + 0.5F, pos.getZ());
					cloud.addEffect(new PotionEffect(RuneUtil.getEffect(String.valueOf(this.getUnlocalizedName().charAt(16))), ConfigRuneStones.areaSpellTime, ConfigRuneStones.areaSpellAmplifier));
					cloud.setDuration(ConfigRuneStones.areaSpellDuration);
					cloud.setRadius(ConfigRuneStones.areaSpellRadius);
					cloud.setColor(0x616161);
					cloud.setWaitTime(10);
					cloud.setParticle(EnumParticleTypes.ENCHANTMENT_TABLE);
					world.spawnEntity(cloud);
				}

				//Set the rune
				if(activeItem.contains("item.rune_") && activeItem.length() == 11 || activeItem.length() == 13 && activeItem.contains("item.rune_")) {	//test if item is a rune type
					if(activeBlock.length() == 15) {																//test if the rune stone is already active (& prevents an error)
						itemstack.shrink(1);																		// > rune stone is empty
						runestone.setType(String.valueOf(activeItem.substring(10))); //outdated!
						world.setBlockState(pos, Block.getBlockFromName(Reference.MODID + ":rune_stone_" + String.valueOf(activeItem.substring(10))).getDefaultState(), 2);
					} else {																						// > rune stone is active
						if(activeItem.substring(10) != activeBlock.substring(16)) {									//test that the item and blockstate is NOT the same type
							EntityItem drop = new EntityItem(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.5D, new ItemStack(Item.getByNameOrId(Reference.MODID + ":rune_" + activeBlock.substring(16))));
							world.spawnEntity(drop);
							itemstack.shrink(1);
							runestone.setType(String.valueOf(activeItem.substring(10))); //outdated!
							world.setBlockState(pos, Block.getBlockFromName(Reference.MODID + ":rune_stone_" + String.valueOf(activeItem.substring(10))).getDefaultState(), 2);
						}
					}
				}
			}
		}
		return true;
	}
	**/

	//TODO Test!!!!
	@Override
	public boolean collisionExtendsVertically(BlockState state, BlockGetter world, BlockPos pos, Entity entityIn) {
		//base blocks
		if(!entityIn.level.isClientSide && this != ModBlocks.RUNE_STONE.get() && this.getName().toString().length() == 17) { //!(runestone.getType() == "0" && runestone.getType().length() == 1)
			if(entityIn instanceof Player) {
				Player player = (Player) entityIn;
				player.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(this.getName().getString().charAt(16))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}

			if(entityIn instanceof LivingEntity) {
				LivingEntity entity = (LivingEntity) entityIn;
				entity.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(this.getName().toString().charAt(16))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}
		}

		//special blocks
		if(!entityIn.level.isClientSide && this != ModBlocks.RUNE_STONE.get() && this.getName().toString().length() == 19) {
			if (this == ModBlocks.RUNE_STONE_DMG.get()) {
				entityIn.hurt(DamageSource.MAGIC, 4.0F);

			} else if (this == ModBlocks.RUNE_STONE_FRE.get()) {
				entityIn.setSecondsOnFire(20);

			} else if (this == ModBlocks.RUNE_STONE_HRD.get()) {
				entityIn.hurt(DamageSource.MAGIC, 2.0F);

			} else if (this == ModBlocks.RUNE_STONE_PTL.get()) {
				entityIn.handleInsidePortal(pos); //TODO TEST
			}
		}
		return false;
	}



	@Override
	public void onBlockExploded(BlockState state, Level world, BlockPos pos, Explosion explosion) {
		Random rand = new Random();
		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 0.8F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);
	}


	//TODO test
	@Override
	public void playerDestroy(Level world, Player pPlayer, BlockPos pos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
		Random rand = new Random();
		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 0.8F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);
	}


	//TODO Test
/**	@Override
	public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
		Level world = Minecraft.getInstance().level;

		if(!world.isClientSide() && Config.ACTIVATE_REDSTONE_EFFECT.get()) {
			BlockEntity te = world.getBlockEntity(pos);
			if(te != null && te instanceof TileEntityRuneStone) {
				TileEntityRuneStone runestone = (TileEntityRuneStone) te;

				if(world.isBlockPowered(pos)) {
					world.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.rand.nextFloat() * 0.15F + 0.F);
					world.scheduleUpdate(pos, this, 4);

					if(this != ModBlocks.runeStone && this.getName().toString().length() == 17) {
						AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX(), pos.getY() + 0.5F, pos.getZ());
						cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(this.getName().toString().charAt(16))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
						cloud.setDuration(Config.AREA_SPELL_DURATION.get());
						cloud.setRadius(Config.AREA_SPELL_RADIUS.get());
						cloud.setFixedColor(0x616161);
						cloud.setWaitTime(10);
						cloud.setParticle(ParticleTypes.ENCHANT);
						world.addFreshEntity(cloud);
					}
				}
				if(!world.isBlockPowered(pos)) {
					world.scheduleUpdate(pos, this, 4);
				}
			}
		}
	}**/
}