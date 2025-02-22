package xxrexraptorxx.runecraft.datagen;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.function.BiConsumer;

public class ItemModelGen extends ItemModelGenerators {

    public ItemModelGen(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }


    @Override
    public void run() {
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



    private void itemGenerated(DeferredItem item) {
        singleTexture(item.getId().getPath(), ResourceLocation.withDefaultNamespace("item/generated"),"layer0", ResourceLocation.fromNamespaceAndPath(References.MODID, "item/" + item.getId().getPath()));
    }

    private void itemGenerated(DeferredBlock item) {
        singleTexture(item.getId().getPath(), ResourceLocation.withDefaultNamespace("item/generated"),"layer0", ResourceLocation.fromNamespaceAndPath(References.MODID, "item/" + item.getId().getPath()));
    }

    private void itemHandheld(DeferredItem item) {
        singleTexture(item.getId().getPath(), ResourceLocation.withDefaultNamespace("item/handheld"),"layer0", ResourceLocation.fromNamespaceAndPath(References.MODID, "item/" + item.getId().getPath()));
    }

    private void itemBlock(DeferredBlock item) {
        withExistingParent(item.getId().getPath(), modLoc( "block/" + item.getId().getPath()));
    }

}