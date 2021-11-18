package xxrexraptorxx.runecraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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
        ArrayList<ItemStack> gems = new ArrayList<ItemStack>();
        gems.add(new ItemStack(ModItems.CHARGED_AMETHYST.get()));

        IIngredientManager ingredientManager = registry.getIngredientManager();

        registry.addIngredientInfo(gems, VanillaTypes.ITEM, new TranslatableComponent("message.extragems.charged_gem_jei_desc"));

    }
}

