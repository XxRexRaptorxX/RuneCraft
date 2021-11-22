package xxrexraptorxx.runecraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

import java.util.ArrayList;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

        private static final ResourceLocation ID = new ResourceLocation(References.MODID, "jei_plugin");

        @Override
        public ResourceLocation getPluginUid() {
            return ID;
        }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();

        registry.addIngredientInfo(new ItemStack(ModItems.MAGICAL_BOOK.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.magical_book_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUIN_BLOCK.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.ruin_block_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUNE_STONE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.rune_stone_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.basic_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.orb_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.SPELL_PAGE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.spell_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CURSE_PAGE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.curse_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.LOST_PAGE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.lost_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.WAND_PAGE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.wand_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB_PAGE.get()), VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.orb_page_jei_desc"));
    }
}

