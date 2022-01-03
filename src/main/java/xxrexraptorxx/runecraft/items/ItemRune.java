package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRune extends Item {

    public ItemRune() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .stacksTo(16)
        );
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        if(Config.ACTIVATE_VISIBLE_RUNE_TYPE.get()) {
            list.add(new TextComponent(ChatFormatting.YELLOW + RuneHelper.getRuneName(this.getRegistryName().toString().substring(15))));
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext event) {
        Player player = event.getPlayer();
        Level level = player.getLevel();
        Item item = event.getItemInHand().getItem();
        ItemStack stack = new ItemStack(item);
        BlockPos pos = event.getClickedPos().above();

        if(!level.isClientSide) {
            level.setBlock(pos, RuneHelper.getRuneBlockFromType(item.getRegistryName().toString().substring(15)).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, player.getDirection()), 11);
        }
        stack.shrink(1);

        return InteractionResult.SUCCESS;
    }
}
