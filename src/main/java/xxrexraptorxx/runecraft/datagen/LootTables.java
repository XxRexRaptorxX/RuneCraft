package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import xxrexraptorxx.runecraft.main.ModBlocks;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTables() {
        register(ModBlocks.AMETHYST_BLOCK.get());

    }




}