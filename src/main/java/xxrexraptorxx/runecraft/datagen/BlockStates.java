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
        //simpleBlock(Registration.AMETHYST_ORE.get());

    }





}