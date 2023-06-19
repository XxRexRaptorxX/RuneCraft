package xxrexraptorxx.runecraft.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber() {
		super(Properties.of()
				.strength(3.5F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.COLOR_BLACK)
				.instrument(NoteBlockInstrument.BASS)
		);
	}

	//Note: I'm too stupid to port runescriber functions
	@Override
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> list, TooltipFlag flag) {
		list.add(Component.literal(ChatFormatting.RED + "Work in progress..."));
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