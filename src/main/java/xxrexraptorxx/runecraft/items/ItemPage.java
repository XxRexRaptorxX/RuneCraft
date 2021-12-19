package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPage extends Item {

    public ItemPage() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.RARE)
                .stacksTo(16)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        if(Config.ACTIVATE_VISIBLE_RUNE_TYPE.get()) {
            list.add(new TextComponent("Required Xp levels: " + AltarHelper.getPageXpRequirement(this)).withStyle(ChatFormatting.GRAY));
        }
    }
}
