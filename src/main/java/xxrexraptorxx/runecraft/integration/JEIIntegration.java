package xxrexraptorxx.runecraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        treasures.add(new ItemStack(Items.BUNDLE));
        treasures.add(new ItemStack(Items.ENDER_EYE));
        treasures.add(new ItemStack(Items.EMERALD));
        treasures.add(new ItemStack(Items.AMETHYST_CLUSTER));
        treasures.add(new ItemStack(Items.HEART_OF_THE_SEA));
        treasures.add(new ItemStack(Items.ENDER_PEARL));
        treasures.add(new ItemStack(Items.PRISMARINE_CRYSTALS));

        treasures.add(new ItemStack(ModItems.SPIRIT_STAR.get()));
        treasures.add(new ItemStack(ModItems.SPIRIT_CRYSTAL.get()));

        registry.addIngredientInfo(treasures, VanillaTypes.ITEM, new TranslatableComponent("message.runecraft.treasure_ritual_drops_jei_desc"));

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

