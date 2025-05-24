package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

import javax.annotation.Nullable;


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
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_AMBIENT_LARGE, ParticleTypes.ENCHANT, level, pos);
	}


	//Interactions

	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
		//base blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && BuiltInRegistries.BLOCK.getKey(this).toString().length() == 22) {
			SpellHelper.addPlayerEffects(entity, new MobEffectInstance(RuneHelper.getEffect(String.valueOf(BuiltInRegistries.BLOCK.getKey(this).toString().charAt(21))), Config.getSpellDuration(), Config.getSpellAmplifier()), 0);
		}

		//special blocks
		if(!level.isClientSide && this != ModBlocks.RUNE_STONE.get() && BuiltInRegistries.BLOCK.getKey(this).toString().length() == 24) {
			if (this == ModBlocks.RUNE_STONE_DMG.get()) {
				entity.hurt(level.damageSources().magic(), 4.0F);

			} else if (this == ModBlocks.RUNE_STONE_FRE.get()) {
				entity.setRemainingFireTicks(20);

			} else if (this == ModBlocks.RUNE_STONE_HRD.get()) {
				entity.hurt(level.damageSources().magic(), 2.0F);

			} else if (this == ModBlocks.RUNE_STONE_PTL.get()) {
				if (entity.isPassenger()) {
					entity.stopRiding();
				}
				level.playSound((Player)null, pos, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.15F + 0.F);

				if(entity.isCrouching()) {
					entity.teleportTo(pos.getX(), pos.getY() - 10, pos.getZ());
				} else {
					entity.teleportTo(pos.getX(), pos.getY() + 10, pos.getZ());
				}
			}
		}
	}


	@Override
	public void onBlockExploded(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_EVENT, ParticleTypes.ENCHANT, level, pos);

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
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_EVENT, ParticleTypes.ENCHANT, level, pos);

		if(!level.isClientSide) {
			ItemEntity drop = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.RUNE_STONE.get()));
			level.addFreshEntity(drop);

			if (this != ModBlocks.RUNE_STONE.get()) {
				ItemEntity extraDrop = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21))));
				level.addFreshEntity(extraDrop);
			}
		}
	}


	//Redstone stuff

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction direction) {
		return true;
	}


	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
		if (!level.isClientSide && Config.isActivateRedstoneEffect()) {
			boolean flag = state.getValue(POWERED);

			if (flag != level.hasNeighborSignal(pos)) {
				if (flag) {
					level.scheduleTick(pos, this, 4);

				} else {
					level.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);

					if(this != ModBlocks.RUNE_STONE.get() && this != ModBlocks.RUNE_STONE_DMG.get() && this != ModBlocks.RUNE_STONE_FRE.get() &&
							this != ModBlocks.RUNE_STONE_HRD.get() && this != ModBlocks.RUNE_STONE_PTL.get() && BuiltInRegistries.BLOCK.getKey(this).toString().contains("rune_stone_")) {

						level.setBlock(pos, state.cycle(POWERED), 2);
						SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, Config.getAreaSpellDuration(), Config.getAreaSpellAmplifier(),
								new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21)), Config.getSpellDuration(), Config.getSpellAmplifier()), level, pos.getCenter());
					}
				}
			}
		}
	}


	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
	}


	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
	}


	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(POWERED) && !level.hasNeighborSignal(pos)) {
			level.setBlock(pos, state.cycle(POWERED), 2);
		}
	}

}