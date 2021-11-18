package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, References.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Generic
        singleTexture(ModItems.AMETHYST.get().getRegistryName().getPath(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation(References.MODID, "item/amethyst"));


        //BlockItems
        withExistingParent(ModBlocks.RUBY_ORE_BLOCKITEM.get().getRegistryName().getPath(), new ResourceLocation(References.MODID, "block/ruby_ore"));
    }

}