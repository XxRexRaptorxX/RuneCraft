package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.main.References;

public class ItemModelGen extends ItemModelProvider {

    public ItemModelGen(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, References.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        itemBlock(ModBlocks.ASH_BLOCK);
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
        //itemBlock(ModBlocks.RUNE_STONE_GHS);
        itemBlock(ModBlocks.RUNE_STONE_HRD);
        itemBlock(ModBlocks.RUNE_STONE_PTL);

        itemBlock(ModBlocks.RUNE_BLOCK_A);
        itemBlock(ModBlocks.RUNE_BLOCK_B);
        itemBlock(ModBlocks.RUNE_BLOCK_C);
        itemBlock(ModBlocks.RUNE_BLOCK_D);
        itemBlock(ModBlocks.RUNE_BLOCK_E);
        itemBlock(ModBlocks.RUNE_BLOCK_F);
        itemBlock(ModBlocks.RUNE_BLOCK_G);
        itemBlock(ModBlocks.RUNE_BLOCK_H);
        itemBlock(ModBlocks.RUNE_BLOCK_I);
        itemBlock(ModBlocks.RUNE_BLOCK_J);
        itemBlock(ModBlocks.RUNE_BLOCK_K);
        itemBlock(ModBlocks.RUNE_BLOCK_L);
        itemBlock(ModBlocks.RUNE_BLOCK_M);
        itemBlock(ModBlocks.RUNE_BLOCK_N);
        itemBlock(ModBlocks.RUNE_BLOCK_O);
        itemBlock(ModBlocks.RUNE_BLOCK_P);
        itemBlock(ModBlocks.RUNE_BLOCK_Q);
        itemBlock(ModBlocks.RUNE_BLOCK_R);
        itemBlock(ModBlocks.RUNE_BLOCK_S);
        itemBlock(ModBlocks.RUNE_BLOCK_T);
        itemBlock(ModBlocks.RUNE_BLOCK_U);
        itemBlock(ModBlocks.RUNE_BLOCK_V);
        itemBlock(ModBlocks.RUNE_BLOCK_W);
        itemBlock(ModBlocks.RUNE_BLOCK_X);
        itemBlock(ModBlocks.RUNE_BLOCK_Y);
        itemBlock(ModBlocks.RUNE_BLOCK_Z);
        itemBlock(ModBlocks.RUNE_BLOCK_DMG);
        itemBlock(ModBlocks.RUNE_BLOCK_FRE);
        itemBlock(ModBlocks.RUNE_BLOCK_HRD);
        itemBlock(ModBlocks.RUNE_BLOCK_PTL);

        itemHandheld(ModItems.RITUAL_DAGGER);
    }



    private void itemGenerated(RegistryObject item) {                                                                                                           //path different from the convention
        singleTexture(item.getId().getPath(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation(References.MODID, "items/" + item.getId().toString().substring(References.MODID.length() + 1)));
    }


    private void itemHandheld(RegistryObject item) {                                                                                                            //path different from the convention
        singleTexture(item.getId().getPath(), new ResourceLocation("item/handheld"),"layer0", new ResourceLocation(References.MODID, "items/" + item.getId().toString().substring(References.MODID.length() + 1)));
    }


    private void itemBlock(RegistryObject item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation(References.MODID, "block/" + item.getId().toString().substring(References.MODID.length() + 1)));
    }

}