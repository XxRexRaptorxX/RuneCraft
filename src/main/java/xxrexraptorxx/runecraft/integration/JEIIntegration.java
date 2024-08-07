package xxrexraptorxx.runecraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.ArrayList;

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

        ArrayList<ItemStack> treasures = new ArrayList<ItemStack>();
        treasures.add(new ItemStack(Items.DIAMOND));
        treasures.add(new ItemStack(Items.ELYTRA));
        treasures.add(new ItemStack(Items.NETHER_STAR));
        treasures.add(new ItemStack(Items.TOTEM_OF_UNDYING));
        treasures.add(new ItemStack(Items.EXPERIENCE_BOTTLE));
        treasures.add(new ItemStack(Items.END_CRYSTAL));
        treasures.add(new ItemStack(Items.GHAST_TEAR));
        treasures.add(new ItemStack(Items.BLAZE_ROD));
        treasures.add(new ItemStack(Items.DIAMOND_SWORD));
        treasures.add(new ItemStack(Items.DRAGON_BREATH));
        treasures.add(new ItemStack(Items.NETHERITE_SCRAP));
        treasures.add(new ItemStack(Items.ENCHANTED_BOOK));
        treasures.add(new ItemStack(Items.GOLDEN_APPLE));
        treasures.add(new ItemStack(Items.ENDER_EYE));
        treasures.add(new ItemStack(Items.EMERALD));
        treasures.add(new ItemStack(Items.AMETHYST_CLUSTER));
        treasures.add(new ItemStack(Items.HEART_OF_THE_SEA));
        treasures.add(new ItemStack(Items.ENDER_PEARL));
        treasures.add(new ItemStack(Items.PRISMARINE_CRYSTALS));
        treasures.add(new ItemStack(ModItems.SPIRIT_STAR.get()));
        treasures.add(new ItemStack(ModItems.SPIRIT_CRYSTAL.get()));
        treasures.add(new ItemStack(Items.ECHO_SHARD));
        treasures.add(new ItemStack(Items.OMINOUS_TRIAL_KEY));
        treasures.add(new ItemStack(Items.HEAVY_CORE));

        registry.addIngredientInfo(treasures, VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.treasure_ritual_drops_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.MAGICAL_BOOK.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.magical_book_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUIN_BLOCK.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.ruin_block_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModBlocks.RUNE_STONE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.rune_stone_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.basic_wand_crafting_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.orb_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.SOUL.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.soul_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.SPELL_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.spell_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CURSE_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.curse_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.LOST_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.lost_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.WAND_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.wand_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ORB_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.orb_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ENCHANTING_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.enchanting_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BANNED_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.banned_page_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ALCHEMY_PAGE.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.alchemy_page_jei_desc"));

        registry.addIngredientInfo(new ItemStack(ModItems.AETHER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.aether_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.NETHER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.nether_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.STORM_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.storm_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.HOLY_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.holy_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CURSE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.curse_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.MAELSTROM_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.maelstrom_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CREATURE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.creature_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.DEFENSIVE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.defensive_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.DESTRUCTION_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.destruction_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.CHANGING_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.changing_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.THUNDER_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.thunder_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.ESCAPE_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.escape_wand_jei_desc"));
        registry.addIngredientInfo(new ItemStack(ModItems.BASIC_WAND.get()), VanillaTypes.ITEM_STACK, Component.translatable("message.runecraft.basic_wand_jei_desc"));
    }
}