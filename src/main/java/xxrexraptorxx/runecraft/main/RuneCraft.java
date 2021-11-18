package xxrexraptorxx.runecraft.main;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.utils.Config;

@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();

    public RuneCraft() {
        ModBlocks.init();
        ModItems.init();
        Config.init();
    }
}