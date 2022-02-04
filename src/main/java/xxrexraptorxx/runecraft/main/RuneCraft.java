package xxrexraptorxx.runecraft.main;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.world.OreGenerator;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/rune-craft
 **/
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