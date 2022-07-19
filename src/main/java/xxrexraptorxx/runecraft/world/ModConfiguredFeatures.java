package xxrexraptorxx.runecraft.world;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;

import java.util.List;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, References.MODID);


    public static final Supplier<List<OreConfiguration.TargetBlockState>> ASH_GEN = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.ASH_BLOCK.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ASH = CONFIGURED_FEATURES.register("ash",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ASH_GEN.get(),20)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}