package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import java.util.function.Consumer;

public class ItemRune extends Item {

    public ItemRune(Properties properties) {
        super(properties
                .stacksTo(16)
        );
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
        if(Config.getActivateVisibleRuneType()) {
            list.accept(Component.literal(ChatFormatting.YELLOW + RuneHelper.getRuneName(BuiltInRegistries.ITEM.getKey(this).toString().substring(15))));
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext event) {
        Player player = event.getPlayer();
        Level level = player.level();
        ItemStack stack = event.getItemInHand();
        Item item = stack.getItem();
        BlockPos pos = event.getClickedPos().above();

        if(!level.isClientSide && event.getClickedFace() == Direction.UP && level.getBlockState(event.getClickedPos()).isCollisionShapeFullBlock(level, pos)) {
            level.playSound((Player) null, pos, SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
            level.setBlock(pos, RuneHelper.getRuneBlockFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, player.getDirection()), 11);
        }
        stack.shrink(1);

        return InteractionResult.SUCCESS;
    }
}
