package xxrexraptorxx.runecraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber() {
		super(Properties.of(Material.STONE)
				.strength(3.5F)
				.sound(SoundType.STONE)
				.color(MaterialColor.COLOR_BLACK)
		);
	}

	//Note: I'm too stupid to port runescriber functions

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