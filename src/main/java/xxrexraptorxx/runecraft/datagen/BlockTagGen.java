package xxrexraptorxx.runecraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends BlockTagsProvider {

    public BlockTagGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, References.MODID, helper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(   ModBlocks.ALTAR_BLOCK.get(),
                        ModBlocks.RUIN_BLOCK.get(),
                        ModBlocks.RUNE_STONE.get(),
                        ModBlocks.RUNE_STONE_A.get(),
                        ModBlocks.RUNE_STONE_B.get(),
                        ModBlocks.RUNE_STONE_C.get(),
                        ModBlocks.RUNE_STONE_D.get(),
                        ModBlocks.RUNE_STONE_E.get(),
                        ModBlocks.RUNE_STONE_F.get(),
                        ModBlocks.RUNE_STONE_G.get(),
                        ModBlocks.RUNE_STONE_H.get(),
                        ModBlocks.RUNE_STONE_I.get(),
                        ModBlocks.RUNE_STONE_J.get(),
                        ModBlocks.RUNE_STONE_K.get(),
                        ModBlocks.RUNE_STONE_L.get(),
                        ModBlocks.RUNE_STONE_M.get(),
                        ModBlocks.RUNE_STONE_N.get(),
                        ModBlocks.RUNE_STONE_O.get(),
                        ModBlocks.RUNE_STONE_P.get(),
                        ModBlocks.RUNE_STONE_Q.get(),
                        ModBlocks.RUNE_STONE_R.get(),
                        ModBlocks.RUNE_STONE_S.get(),
                        ModBlocks.RUNE_STONE_T.get(),
                        ModBlocks.RUNE_STONE_U.get(),
                        ModBlocks.RUNE_STONE_V.get(),
                        ModBlocks.RUNE_STONE_W.get(),
                        ModBlocks.RUNE_STONE_X.get(),
                        ModBlocks.RUNE_STONE_Y.get(),
                        ModBlocks.RUNE_STONE_Z.get(),
                        ModBlocks.RUNE_STONE_DMG.get(),
                        ModBlocks.RUNE_STONE_FRE.get(),
                        ModBlocks.RUNE_STONE_HRD.get(),
                        //ModBlocks.RUNE_STONE_GHS.get(),
                        ModBlocks.RUNE_STONE_PTL.get(),
                        ModBlocks.RUIN_BLOCK.get(),
                        ModBlocks.RUNE_SCRIBER_BLOCK.get()
                        );


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(   ModBlocks.RUIN_BLOCK.get(),
                        ModBlocks.RUNE_STONE.get(),
                        ModBlocks.RUNE_STONE_A.get(),
                        ModBlocks.RUNE_STONE_B.get(),
                        ModBlocks.RUNE_STONE_C.get(),
                        ModBlocks.RUNE_STONE_D.get(),
                        ModBlocks.RUNE_STONE_E.get(),
                        ModBlocks.RUNE_STONE_F.get(),
                        ModBlocks.RUNE_STONE_G.get(),
                        ModBlocks.RUNE_STONE_H.get(),
                        ModBlocks.RUNE_STONE_I.get(),
                        ModBlocks.RUNE_STONE_J.get(),
                        ModBlocks.RUNE_STONE_K.get(),
                        ModBlocks.RUNE_STONE_L.get(),
                        ModBlocks.RUNE_STONE_M.get(),
                        ModBlocks.RUNE_STONE_N.get(),
                        ModBlocks.RUNE_STONE_O.get(),
                        ModBlocks.RUNE_STONE_P.get(),
                        ModBlocks.RUNE_STONE_Q.get(),
                        ModBlocks.RUNE_STONE_R.get(),
                        ModBlocks.RUNE_STONE_S.get(),
                        ModBlocks.RUNE_STONE_T.get(),
                        ModBlocks.RUNE_STONE_U.get(),
                        ModBlocks.RUNE_STONE_V.get(),
                        ModBlocks.RUNE_STONE_W.get(),
                        ModBlocks.RUNE_STONE_X.get(),
                        ModBlocks.RUNE_STONE_Y.get(),
                        ModBlocks.RUNE_STONE_Z.get(),
                        ModBlocks.RUNE_STONE_DMG.get(),
                        ModBlocks.RUNE_STONE_FRE.get(),
                        ModBlocks.RUNE_STONE_HRD.get(),
                        //ModBlocks.RUNE_STONE_GHS.get(),
                        ModBlocks.RUNE_STONE_PTL.get(),
                        ModBlocks.RUIN_BLOCK.get()
                );


        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(   ModBlocks.ASH_BLOCK.get(),
                        ModBlocks.RUNE_DUST_BLOCK.get()
                );


        tag(BlockTags.PIGLIN_REPELLENTS)
                .add(   ModBlocks.ALTAR_BLOCK.get()
                );

    }
}
