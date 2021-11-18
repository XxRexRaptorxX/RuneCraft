package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, References.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGenerated(ModItems.RUNE_A);
    }


    private void itemGenerated(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName()));
    }


    private void itemHandheld(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName()));
    }


    private void itemBlock(RegistryObject item) {
        withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation(References.MODID, "block/" + item.get().getRegistryName()));
    }

}