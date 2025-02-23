package xxrexraptorxx.runecraft.blocks;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
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