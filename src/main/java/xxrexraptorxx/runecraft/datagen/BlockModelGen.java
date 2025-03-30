package xxrexraptorxx.runecraft.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.runecraft.registry.ModBlocks;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BlockModelGen extends BlockModelGenerators {

    public BlockModelGen(Consumer<BlockModelDefinitionGenerator> blockstateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockstateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public void run() {
        createTrivialCube(ModBlocks.RUNE_DUST_BLOCK.get());
        createTrivialCube(ModBlocks.ASH_BLOCK.get());
    }
}