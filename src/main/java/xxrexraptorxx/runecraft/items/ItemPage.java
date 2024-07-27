package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;

import java.util.List;

public class ItemPage extends Item {

    public ItemPage() {
        super(new Properties()
                .rarity(Rarity.RARE)
                .stacksTo(16)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        if (this != ModItems.MAGICAL_PAGE.get())
            list.add(Component.literal("Required Xp levels: " + AltarHelper.getPageXpRequirement(this)).withStyle(ChatFormatting.GRAY));
    }
}
