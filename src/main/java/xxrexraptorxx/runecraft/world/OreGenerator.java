package xxrexraptorxx.runecraft.world;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class OreGenerator {

    public static final List<ConfiguredFeature<?, ?>> NETHER_ORES = new ArrayList<>();


    public static void registerOres() {

            ConfiguredFeature<?, ?> ashe = Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration.target(
                            OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, ModBlocks.ASHE_BLOCK.get().defaultBlockState())), 15))
                    .rangeUniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(64)).squared().count(10);

            NETHER_ORES.add(register("ashe", ashe));
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name, ConfiguredFeature<Config, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(References.MODID, name),
                configuredFeature);
    }


    @Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            if(event.getName().toString().equals("minecraft:basalt_deltas")) {
                 OreGenerator.NETHER_ORES.forEach(ore -> features.add(() -> ore));
            }

        }
    }
 }
