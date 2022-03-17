package xxrexraptorxx.runecraft.world;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

import java.util.List;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreGenerator {
/**
    @SubscribeEvent
    public static void oreGeneration(final BiomeLoadingEvent event) {
        if (event.getName().toString().equals("minecraft:basalt_deltas")) {
            genOre(event.getGeneration(), OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.ASH_BLOCK.get().defaultBlockState(), 15, 10, 64, 10);
        }
    }

    private static void genOre(BiomeGenerationSettingsBuilder settings, RuleTest fillertype, BlockState state, int veinSize, int minHeight, int maxHeight, int maxperchunk) {
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.(new OreConfiguration(fillertype, state, veinSize))
                        .placed(List.of((CountPlacement.of(UniformInt.of(0, maxperchunk)))
                                , InSquarePlacement.spread()
                                , HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), BiomeFilter.biome())));
    }
 **/
}