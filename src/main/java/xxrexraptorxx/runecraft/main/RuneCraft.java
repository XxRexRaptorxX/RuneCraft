package xxrexraptorxx.runecraft.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.ModSetup;
import xxrexraptorxx.runecraft.world.OreGenerator;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/rune-craft
 **/
@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public RuneCraft() {

        ModSetup.setup();
        Config.init();
        ModBlocks.init();
        ModItems.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
    }
}