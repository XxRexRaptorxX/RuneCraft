package xxrexraptorxx.runecraft.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.utils.Config;

public class OreGenerator {

    public static Holder<PlacedFeature> ASH_GEN;


    public static void registerConfiguredFeatures() {
        OreConfiguration oreConfig = new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.ASH_BLOCK.get().defaultBlockState(), 15);
        ASH_GEN = registerPlacedFeature("ash_block", new ConfiguredFeature<>(Feature.ORE, oreConfig),
                CountPlacement.of(20),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(64)));
    }


    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }


    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (Config.ACTIVATE_ASH_GEN.get()) {
            if (event.getName().toString().equals("minecraft:basalt_deltas")) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ASH_GEN);
            }
        }
    }
}