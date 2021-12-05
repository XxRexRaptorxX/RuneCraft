package xxrexraptorxx.runecraft.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class BlockRuneStone extends Block {

	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0625D, 0.0625D, 0.0625D, 15.9375D, 15.9375D, 15.9375D);


	public BlockRuneStone() {
		super(Properties.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(5.0F, 7.0F)
				.sound(SoundType.STONE)
				.color(MaterialColor.DEEPSLATE)
				.noOcclusion()
		);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return CUSTOM_COLLISION_AABB;
	}


	@Override
	public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> list, TooltipFlag pFlag) {
		list.add(new TranslatableComponent("message.runecraft.rune_stone_desc").withStyle(ChatFormatting.GRAY));
	}


	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
		return true;
	}


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


	@Override
	public void stepOn(Level level, BlockPos pos, BlockState pState, Entity entityIn) {
		//base blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && this.getRegistryName().toString().length() == 22) {
			if(entityIn instanceof Player) {
				Player player = (Player) entityIn;
				player.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(this.getRegistryName().toString().charAt(21))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}

			if(entityIn instanceof LivingEntity) {
				LivingEntity entity = (LivingEntity) entityIn;
				entity.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(this.getRegistryName().toString().charAt(21))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}
		}

		//special blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && this.getRegistryName().toString().length() == 24) {
			if (this == ModBlocks.RUNE_STONE_DMG.get()) {
				entityIn.hurt(DamageSource.MAGIC, 4.0F);

			} else if (this == ModBlocks.RUNE_STONE_FRE.get()) {
				entityIn.setSecondsOnFire(20);

			} else if (this == ModBlocks.RUNE_STONE_HRD.get()) {
				entityIn.hurt(DamageSource.MAGIC, 2.0F);

			} else if (this == ModBlocks.RUNE_STONE_PTL.get()) {
				if (entityIn.isPassenger()) {
					entityIn.stopRiding();
				}
				level.playSound((Player)null, pos, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.15F + 0.F);
				if(entityIn.isCrouching()) {
					entityIn.teleportTo(pos.getX(), pos.getY() - 10, pos.getZ());
				} else {
					entityIn.teleportTo(pos.getX(), pos.getY() + 10, pos.getZ());
				}
			}
		}
	}


	@Override
	public void onBlockExploded(BlockState state, Level world, BlockPos pos, Explosion explosion) {
		Random rand = new Random();

		double d0 = (double) ((float) pos.getX() + rand.nextFloat());
		double d1 = (double) ((float) pos.getY() + 0.8F);
		double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);

		if (!world.isClientSide) {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

			ItemEntity drop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.RUNE_STONE.get()));
			world.addFreshEntity(drop);

			if (this != ModBlocks.RUNE_STONE.get()) {
				ItemEntity extraDrop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(this.getRegistryName().toString().substring(21))));
				world.addFreshEntity(extraDrop);
			}
		}
	}


	@Override
	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
		Random rand = new Random();
		double d0 = (double) ((float) pos.getX() + rand.nextFloat());
		double d1 = (double) ((float) pos.getY() + 0.8F);
		double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);

		if(!world.isClientSide) {
			ItemEntity drop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.RUNE_STONE.get()));
			world.addFreshEntity(drop);

			if (this != ModBlocks.RUNE_STONE.get()) {
				ItemEntity extraDrop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(this.getRegistryName().toString().substring(21))));
				world.addFreshEntity(extraDrop);
			}
		}
	}

	//TODO: bug- triggers when activated AND deaktivated
	@Override
	public void neighborChanged(BlockState pState, Level world, BlockPos pos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
		Random random = new Random();

		if(!world.isClientSide() && Config.ACTIVATE_REDSTONE_EFFECT.get()) {

			if(world.hasNeighborSignal(pos)) {
				world.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.F);
				world.scheduleTick(pos, this, 4);

				if(this != ModBlocks.RUNE_STONE.get() && this != ModBlocks.RUNE_STONE_DMG.get() && this != ModBlocks.RUNE_STONE_FRE.get() &&
						this != ModBlocks.RUNE_STONE_HRD.get() && this != ModBlocks.RUNE_STONE_PTL.get() && this.getRegistryName().toString().contains("rune_stone_")) {

					AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX(), pos.getY() + 0.5F, pos.getZ());
					cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(this.getRegistryName().toString().substring(21)), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
					cloud.setDuration(Config.AREA_SPELL_DURATION.get());
					cloud.setRadius(Config.AREA_SPELL_RADIUS.get());
					cloud.setFixedColor(0x616161);
					cloud.setWaitTime(10);
					cloud.setParticle(ParticleTypes.ENCHANT);
					world.addFreshEntity(cloud);
				}
			}
		}
	}

}