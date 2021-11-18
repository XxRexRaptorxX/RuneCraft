package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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
            list.add(new TextComponent(ChatFormatting.YELLOW + RuneHelper.getRuneName(RuneHelper.getRegistryNameFromTag(stack))));
        }
    }
}
