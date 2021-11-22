package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

public class TagsBlock extends BlockTagsProvider {

    public TagsBlock(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, References.MODID, helper);
    }


    @Override
    protected void addTags() {
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
                        ModBlocks.RUNE_STONE_PTL.get()
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
                        ModBlocks.RUNE_STONE_PTL.get()
                        );


        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(   ModBlocks.ASHE_BLOCK.get(),
                        ModBlocks.RUNE_DUST_BLOCK.get()
                );

    }
}
