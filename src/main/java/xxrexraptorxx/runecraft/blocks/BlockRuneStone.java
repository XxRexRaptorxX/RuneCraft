package xxrexraptorxx.runecraft.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;


public class BlockRuneStone extends Block {

	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0625D, 0.0625D, 0.0625D, 15.9375D, 15.9375D, 15.9375D);


	public BlockRuneStone(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(POWERED, Boolean.valueOf(false)));
	}

	//Properties


	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return CUSTOM_COLLISION_AABB;
	}


	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		list.add(Component.translatable("message.runecraft.rune_stone_desc").withStyle(ChatFormatting.GRAY));
	}


	@Override
	public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
		Random rand = new Random();

		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 2.0F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;

		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}


	//Interactions

	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entityIn) {
		//base blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && BuiltInRegistries.BLOCK.getKey(this).toString().length() == 22) {
			if(entityIn instanceof Player) {
				Player player = (Player) entityIn;
				player.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(BuiltInRegistries.BLOCK.getKey(this).toString().charAt(21))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}

			if(entityIn instanceof LivingEntity) {
				LivingEntity entity = (LivingEntity) entityIn;
				entity.addEffect(new MobEffectInstance(RuneHelper.getEffect(String.valueOf(BuiltInRegistries.BLOCK.getKey(this).toString().charAt(21))), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
			}
		}

		//special blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && BuiltInRegistries.BLOCK.getKey(this).toString().length() == 24) {
			if (this == ModBlocks.RUNE_STONE_DMG.get()) {
				entityIn.hurt(level.damageSources().magic(), 4.0F);

			} else if (this == ModBlocks.RUNE_STONE_FRE.get()) {
				entityIn.setRemainingFireTicks(20);

			} else if (this == ModBlocks.RUNE_STONE_HRD.get()) {
				entityIn.hurt(level.damageSources().magic(), 2.0F);

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
	public void onBlockExploded(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion) {
		Random rand = new Random();

		double d0 = (double) ((float) pos.getX() + rand.nextFloat());
		double d1 = (double) ((float) pos.getY() + 0.8F);
		double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		level.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		level.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		level.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);

		if (!level.isClientSide) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

			ItemEntity drop = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.RUNE_STONE.get()));
			level.addFreshEntity(drop);

			if (this != ModBlocks.RUNE_STONE.get()) {
				ItemEntity extraDrop = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21))));
				level.addFreshEntity(extraDrop);
			}
		}
	}


	@Override
	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
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
				ItemEntity extraDrop = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21))));
				world.addFreshEntity(extraDrop);
			}
		}
	}


	//Redstone stuff

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
		return true;
	}


	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
		if (!level.isClientSide && Config.ACTIVATE_REDSTONE_EFFECT.get()) {
			boolean flag = state.getValue(POWERED);

			if (flag != level.hasNeighborSignal(pos)) {
				if (flag) {
					level.scheduleTick(pos, this, 4);

				} else {
					level.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);

					if(this != ModBlocks.RUNE_STONE.get() && this != ModBlocks.RUNE_STONE_DMG.get() && this != ModBlocks.RUNE_STONE_FRE.get() &&
							this != ModBlocks.RUNE_STONE_HRD.get() && this != ModBlocks.RUNE_STONE_PTL.get() && BuiltInRegistries.BLOCK.getKey(this).toString().contains("rune_stone_")) {

						level.setBlock(pos, state.cycle(POWERED), 2);
						AreaEffectCloud cloud = new AreaEffectCloud(level, pos.getX(), pos.getY() + 0.5F, pos.getZ());
						cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21)), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
						cloud.setDuration(Config.AREA_SPELL_DURATION.get());
						cloud.setRadius(Config.AREA_SPELL_RADIUS.get());
						//cloud.setFixedColor(0x616161);
						cloud.setWaitTime(10);
						cloud.setParticle(ParticleTypes.ENCHANT);
						level.addFreshEntity(cloud);
					}
				}
			}

		}
	}


	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(POWERED);
	}


	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(pContext.getLevel().hasNeighborSignal(pContext.getClickedPos())));
	}


	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(POWERED) && !level.hasNeighborSignal(pos)) {
			level.setBlock(pos, state.cycle(POWERED), 2);
		}
	}

}