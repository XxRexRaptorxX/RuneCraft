package xxrexraptorxx.runecraft.utils;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.world.OreGenerator;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(OreGenerator::onBiomeLoadingEvent);
    }

    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGenerator.registerConfiguredFeatures();
        });
    }

}