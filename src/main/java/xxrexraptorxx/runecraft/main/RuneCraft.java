package xxrexraptorxx.runecraft.main;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import xxrexraptorxx.runecraft.registry.CreativeModeTabs;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.world.LootTableInjection;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/rune-craft
 **/
@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();


    public RuneCraft(IEventBus eventBus) {

        eventBus.addListener(this::setup);

        Config.init();
        ModBlocks.init(eventBus);
        ModItems.init(eventBus);
        CreativeModeTabs.init(eventBus);
    }


    private void setup(final @NotNull FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.addListener(LootTableInjection::onChestLootLoad);
        NeoForge.EVENT_BUS.addListener(LootTableInjection::onEntityLootLoad);
    }

}