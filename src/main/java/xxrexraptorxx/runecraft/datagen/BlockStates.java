package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

public class BlockStates extends BlockStateProvider {


    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, References.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ASHE_BLOCK.get());
        simpleBlock(ModBlocks.RUNE_STONE.get());
        simpleBlock(ModBlocks.RUIN_BLOCK.get());
        simpleBlock(ModBlocks.ALTAR_BLOCK.get());
        simpleBlock(ModBlocks.RUNE_STONE_A.get());
        simpleBlock(ModBlocks.RUNE_STONE_B.get());
        simpleBlock(ModBlocks.RUNE_STONE_C.get());
        simpleBlock(ModBlocks.RUNE_STONE_D.get());
        simpleBlock(ModBlocks.RUNE_STONE_E.get());
        simpleBlock(ModBlocks.RUNE_STONE_F.get());
        simpleBlock(ModBlocks.RUNE_STONE_G.get());
        simpleBlock(ModBlocks.RUNE_STONE_H.get());
        simpleBlock(ModBlocks.RUNE_STONE_I.get());
        simpleBlock(ModBlocks.RUNE_STONE_J.get());
        simpleBlock(ModBlocks.RUNE_STONE_K.get());
        simpleBlock(ModBlocks.RUNE_STONE_L.get());
        simpleBlock(ModBlocks.RUNE_STONE_M.get());
        simpleBlock(ModBlocks.RUNE_STONE_N.get());
        simpleBlock(ModBlocks.RUNE_STONE_O.get());
        simpleBlock(ModBlocks.RUNE_STONE_P.get());
        simpleBlock(ModBlocks.RUNE_STONE_Q.get());
        simpleBlock(ModBlocks.RUNE_STONE_R.get());
        simpleBlock(ModBlocks.RUNE_STONE_S.get());
        simpleBlock(ModBlocks.RUNE_STONE_T.get());
        simpleBlock(ModBlocks.RUNE_STONE_U.get());
        simpleBlock(ModBlocks.RUNE_STONE_V.get());
        simpleBlock(ModBlocks.RUNE_STONE_W.get());
        simpleBlock(ModBlocks.RUNE_STONE_X.get());
        simpleBlock(ModBlocks.RUNE_STONE_Y.get());
        simpleBlock(ModBlocks.RUNE_STONE_Z.get());
        simpleBlock(ModBlocks.RUNE_STONE_GHS.get());
        simpleBlock(ModBlocks.RUNE_STONE_DMG.get());
        simpleBlock(ModBlocks.RUNE_STONE_FRE.get());
        simpleBlock(ModBlocks.RUNE_STONE_HRD.get());
        simpleBlock(ModBlocks.RUNE_STONE_PTL.get());
    }





}