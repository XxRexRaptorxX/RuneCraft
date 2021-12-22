package xxrexraptorxx.runecraft.main;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.world.OreGenerator;

@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public RuneCraft() {
        Config.init();
        ModBlocks.init();
        ModItems.init();

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGenerator::oreGeneration);
        MinecraftForge.EVENT_BUS.register(this);
    }
}