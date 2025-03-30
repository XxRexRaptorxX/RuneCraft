package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber(Properties properties) {
		super(properties);
	}


	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_AMBIENT, ParticleTypes.ENCHANT, level, pos);
	}


	/**
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!world.isClientSide) {
			world.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1f, 1f);

			RuneScriberBlockEntity runeScriberBlockEntity = (RuneScriberBlockEntity) world.getBlockEntity(pos);
			NetworkHooks.openGui((ServerPlayer) player, runeScriberBlockEntity, (FriendlyByteBuf packerBuffer) -> {
				packerBuffer.writeBlockPos(runeScriberBlockEntity.getBlockPos());
			});
		}
		return InteractionResult.sidedSuccess(world.isClientSide);
	}
**/

}