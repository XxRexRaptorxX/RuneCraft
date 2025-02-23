package xxrexraptorxx.runecraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;

@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(References.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();

        registry.addIngredientInfo(AltarHelper.getAltarTreasureItems(), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".treasure_ritual_drops_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.MAGICAL_BOOK.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".magical_book_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUIN_BLOCK.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".ruin_block_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUNE_STONE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".rune_stone_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".basic_wand_crafting_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".orb_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.SOUL.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".soul_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.SPELL_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".spell_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CURSE_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".curse_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.LOST_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".lost_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.WAND_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".wand_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".orb_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ENCHANTING_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".enchanting_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BANNED_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".banned_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ALCHEMY_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".alchemy_page_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.AETHER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".aether_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.NETHER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".nether_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.STORM_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".storm_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.HOLY_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".holy_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CURSE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".curse_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.MAELSTROM_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".maelstrom_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CREATURE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".creature_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.DEFENSIVE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".defensive_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.DESTRUCTION_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".destruction_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CHANGING_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".changing_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.THUNDER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".thunder_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ESCAPE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".escape_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message." + References.MODID + ".basic_wand_jei_desc"));
    }
}