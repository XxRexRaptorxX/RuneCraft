package xxrexraptorxx.runecraft.main;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.magmacore.config.ConfigHelper;
import xxrexraptorxx.magmacore.main.ModRegistry;
import xxrexraptorxx.runecraft.registry.CreativeModeTabs;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.registry.ModLootModifiers;
import xxrexraptorxx.runecraft.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/rune-craft">...</a>
 **/
@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public RuneCraft(IEventBus bus, ModContainer container) {
        ModBlocks.init(bus);
        ModItems.init(bus);
        CreativeModeTabs.init(bus);
        ModLootModifiers.init(bus);

        ConfigHelper.registerConfigs(container, References.MODID, true, Config.SERVER_CONFIG, Config.CLIENT_CONFIG);
        ModRegistry.register(References.MODID, References.NAME, References.URL);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class RuneCraftClient {

        public RuneCraftClient(ModContainer container) {
            ConfigHelper.registerIngameConfig(container);
        }
    }

}