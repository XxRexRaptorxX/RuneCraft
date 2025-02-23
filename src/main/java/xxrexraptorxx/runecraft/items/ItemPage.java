package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.Config;

import java.util.List;

public class ItemPage extends Item {

    public ItemPage(Properties properties) {
        super(properties
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
            list.add(Component.literal("Required Xp levels: " + getPageXpRequirement(this)).withStyle(ChatFormatting.GRAY));
    }


    public static int getPageXpRequirement(Item item) {
        if (item == ModItems.WAND_PAGE.get()) return Config.WAND_PAGE_COST.get();
        if (item == ModItems.SPELL_PAGE.get()) return Config.SPELL_PAGE_COST.get();
        if (item == ModItems.CURSE_PAGE.get()) return Config.CURSE_PAGE_COST.get();
        if (item == ModItems.LOST_PAGE.get()) return Config.LOST_PAGE_COST.get();
        if (item == ModItems.BANNED_PAGE.get()) return Config.BANNED_PAGE_COST.get();
        if (item == ModItems.ORB_PAGE.get()) return Config.ORB_PAGE_COST.get();
        if (item == ModItems.ENCHANTING_PAGE.get()) return Config.ENCHANTING_PAGE_COST.get();
        if (item == ModItems.ALCHEMY_PAGE.get()) return Config.ALCHEMY_PAGE_COST.get();
        else return 0;
    }
}
