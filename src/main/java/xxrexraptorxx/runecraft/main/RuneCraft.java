package xxrexraptorxx.runecraft.main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.registry.*;
import xxrexraptorxx.runecraft.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/rune-craft">...</a>
 **/
@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();


    public RuneCraft(IEventBus eventBus, ModContainer container) {

        ModBlocks.init(eventBus);
        ModItems.init(eventBus);
        ModArmorMaterials.init(eventBus);
        CreativeModeTabs.init(eventBus);
        ModLootModifiers.init(eventBus);
        Config.init(container);
    }

}