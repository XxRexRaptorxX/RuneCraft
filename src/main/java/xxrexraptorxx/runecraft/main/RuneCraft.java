package xxrexraptorxx.runecraft.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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


    public RuneCraft() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);

        Config.init();
        ModBlocks.init();
        ModItems.init();
        CreativeModeTabs.init();
    }


    private void setup(final @NotNull FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(LootTableInjection::onChestLootLoad);
        MinecraftForge.EVENT_BUS.addListener(LootTableInjection::onEntityLootLoad);
    }

}