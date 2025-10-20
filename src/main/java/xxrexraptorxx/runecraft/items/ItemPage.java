package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import xxrexraptorxx.magmacore.utils.FormattingHelper;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.Config;

import java.util.function.Consumer;

public class ItemPage extends Item {

    public ItemPage(Properties properties) {
        super(properties.rarity(Rarity.RARE).stacksTo(16));
    }


    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
        if (this != ModItems.MAGICAL_PAGE.get())
            list.accept(FormattingHelper.setMessageComponent(References.MODID, "required_xp", ChatFormatting.GRAY).append(Component.literal(" " + getPageXpRequirement(this))));
    }


    public static int getPageXpRequirement(Item item) {
        if (item == ModItems.WAND_PAGE.get()) return Config.getWandPageCost();
        if (item == ModItems.SPELL_PAGE.get()) return Config.getSpellPageCost();
        if (item == ModItems.CURSE_PAGE.get()) return Config.getCursePageCost();
        if (item == ModItems.LOST_PAGE.get()) return Config.getLostPageCost();
        if (item == ModItems.BANNED_PAGE.get()) return Config.getBannedPageCost();
        if (item == ModItems.ORB_PAGE.get()) return Config.getOrbPageCost();
        if (item == ModItems.ENCHANTING_PAGE.get()) return Config.getEnchantingPageCost();
        if (item == ModItems.ALCHEMY_PAGE.get()) return Config.getAlchemyPageCost();
        else return 0;
    }
}
