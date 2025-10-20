package xxrexraptorxx.runecraft.main;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.magmacore.config.ConfigHelper;
import xxrexraptorxx.magmacore.main.ModRegistry;
import xxrexraptorxx.runecraft.registry.CreativeTabs;
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
        CreativeTabs.init(bus);
        ModLootModifiers.init(bus);

        bus.addListener(this::addCreative);

        ConfigHelper.registerConfigs(container, References.MODID, true, Config.SERVER_CONFIG, Config.CLIENT_CONFIG);
        ModRegistry.register(References.MODID, References.NAME, References.URL);
    }


    @Mod(value = References.MODID, dist = Dist.CLIENT)
    public static class RuneCraftClient {

        public RuneCraftClient(ModContainer container) {
            ConfigHelper.registerIngameConfig(container);
        }
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ASH.get());
            event.accept(ModItems.RUNE_DUST.get());
            event.accept(ModItems.CLOTH.get());
            event.accept(ModItems.SOUL.get());

            event.accept(ModItems.ORB.get());
            event.accept(ModItems.SOUL_ORB.get());

            event.accept(ModItems.SPIRIT_CRYSTAL.get());
            event.accept(ModItems.SPIRIT_STAR.get());

            event.accept(ModItems.MAGICAL_PAGE.get());
            event.accept(ModItems.SPELL_PAGE.get());
            event.accept(ModItems.ENCHANTING_PAGE.get());
            event.accept(ModItems.WAND_PAGE.get());
            event.accept(ModItems.ORB_PAGE.get());
            event.accept(ModItems.ALCHEMY_PAGE.get());
            event.accept(ModItems.CURSE_PAGE.get());
            event.accept(ModItems.LOST_PAGE.get());
            event.accept(ModItems.BANNED_PAGE.get());

        } else if (key == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MAGICAL_BOOK.get());
            event.accept(ModItems.BASIC_WAND.get());
            event.accept(ModItems.AETHER_WAND.get());
            event.accept(ModItems.NETHER_WAND.get());
            event.accept(ModItems.CURSE_WAND.get());
            event.accept(ModItems.HOLY_WAND.get());
            event.accept(ModItems.STORM_WAND.get());
            event.accept(ModItems.MAELSTROM_WAND.get());
            event.accept(ModItems.ESCAPE_WAND.get());
            event.accept(ModItems.DEFENSIVE_WAND.get());
            event.accept(ModItems.THUNDER_WAND.get());
            event.accept(ModItems.CREATURE_WAND.get());
            event.accept(ModItems.CHANGING_WAND.get());
            event.accept(ModItems.DESTRUCTION_WAND.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_A.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_B.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_C.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_D.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_E.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_F.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_G.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_H.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_I.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_J.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_K.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_L.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_M.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_N.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_O.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_P.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_Q.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_R.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_S.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_T.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_U.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_V.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_W.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_X.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_Y.get());
            event.accept(ModItems.PORTABLE_RUNE_STONE_Z.get());

        } else if (key == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.RITUAL_DAGGER.get());
            event.accept(ModItems.MAGICAL_CAP.get());
            event.accept(ModItems.MAGICAL_ROBE.get());
            event.accept(ModItems.MAGICAL_PANTS.get());
            event.accept(ModItems.MAGICAL_BOOTS.get());

        } else if (key == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.ALTAR_BLOCK.get());
            event.accept(ModBlocks.RUNE_SCRIBER_BLOCK.get());
            event.accept(ModBlocks.RUNE_STONE.get());
            event.accept(ModBlocks.RUNE_STONE_A.get());
            event.accept(ModBlocks.RUNE_STONE_B.get());
            event.accept(ModBlocks.RUNE_STONE_C.get());
            event.accept(ModBlocks.RUNE_STONE_D.get());
            event.accept(ModBlocks.RUNE_STONE_E.get());
            event.accept(ModBlocks.RUNE_STONE_F.get());
            event.accept(ModBlocks.RUNE_STONE_G.get());
            event.accept(ModBlocks.RUNE_STONE_H.get());
            event.accept(ModBlocks.RUNE_STONE_I.get());
            event.accept(ModBlocks.RUNE_STONE_J.get());
            event.accept(ModBlocks.RUNE_STONE_K.get());
            event.accept(ModBlocks.RUNE_STONE_L.get());
            event.accept(ModBlocks.RUNE_STONE_M.get());
            event.accept(ModBlocks.RUNE_STONE_N.get());
            event.accept(ModBlocks.RUNE_STONE_O.get());
            event.accept(ModBlocks.RUNE_STONE_P.get());
            event.accept(ModBlocks.RUNE_STONE_Q.get());
            event.accept(ModBlocks.RUNE_STONE_R.get());
            event.accept(ModBlocks.RUNE_STONE_S.get());
            event.accept(ModBlocks.RUNE_STONE_T.get());
            event.accept(ModBlocks.RUNE_STONE_U.get());
            event.accept(ModBlocks.RUNE_STONE_V.get());
            event.accept(ModBlocks.RUNE_STONE_W.get());
            event.accept(ModBlocks.RUNE_STONE_X.get());
            event.accept(ModBlocks.RUNE_STONE_Y.get());
            event.accept(ModBlocks.RUNE_STONE_Z.get());
            event.accept(ModBlocks.RUNE_STONE_PTL.get());
            event.accept(ModBlocks.RUNE_STONE_FRE.get());
            event.accept(ModBlocks.RUNE_STONE_DMG.get());
            event.accept(ModBlocks.RUNE_STONE_HRD.get());

        } else if (key == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ASH_BLOCK.get());

        } else if (key == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.RUIN_BLOCK.get());
            event.accept(ModBlocks.RUNE_DUST_BLOCK.get());
        }
    }
}
