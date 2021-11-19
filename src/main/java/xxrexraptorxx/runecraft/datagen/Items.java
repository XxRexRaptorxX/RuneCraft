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

        itemBlock(ModBlocks.ASHE_BLOCK);
        itemBlock(ModBlocks.ALTAR_BLOCK);
        itemBlock(ModBlocks.RUIN_BLOCK);
        itemBlock(ModBlocks.RUNE_DUST_BLOCK);
        itemBlock(ModBlocks.RUNE_SCRIBER_BLOCK);
        itemBlock(ModBlocks.RUNE_STONE);
        itemBlock(ModBlocks.RUNE_STONE_A);
        itemBlock(ModBlocks.RUNE_STONE_B);
        itemBlock(ModBlocks.RUNE_STONE_C);
        itemBlock(ModBlocks.RUNE_STONE_D);
        itemBlock(ModBlocks.RUNE_STONE_E);
        itemBlock(ModBlocks.RUNE_STONE_F);
        itemBlock(ModBlocks.RUNE_STONE_G);
        itemBlock(ModBlocks.RUNE_STONE_H);
        itemBlock(ModBlocks.RUNE_STONE_I);
        itemBlock(ModBlocks.RUNE_STONE_J);
        itemBlock(ModBlocks.RUNE_STONE_K);
        itemBlock(ModBlocks.RUNE_STONE_L);
        itemBlock(ModBlocks.RUNE_STONE_M);
        itemBlock(ModBlocks.RUNE_STONE_N);
        itemBlock(ModBlocks.RUNE_STONE_O);
        itemBlock(ModBlocks.RUNE_STONE_P);
        itemBlock(ModBlocks.RUNE_STONE_Q);
        itemBlock(ModBlocks.RUNE_STONE_R);
        itemBlock(ModBlocks.RUNE_STONE_S);
        itemBlock(ModBlocks.RUNE_STONE_T);
        itemBlock(ModBlocks.RUNE_STONE_U);
        itemBlock(ModBlocks.RUNE_STONE_V);
        itemBlock(ModBlocks.RUNE_STONE_W);
        itemBlock(ModBlocks.RUNE_STONE_X);
        itemBlock(ModBlocks.RUNE_STONE_Y);
        itemBlock(ModBlocks.RUNE_STONE_Z);
        itemBlock(ModBlocks.RUNE_STONE_DMG);
        itemBlock(ModBlocks.RUNE_STONE_FRE);
        itemBlock(ModBlocks.RUNE_STONE_GHS);
        itemBlock(ModBlocks.RUNE_STONE_HRD);
        itemBlock(ModBlocks.RUNE_STONE_PTL);


    }



    private void itemGenerated(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }


    private void itemHandheld(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }


    private void itemBlock(RegistryObject item) {
        withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation(References.MODID, "block/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }

}