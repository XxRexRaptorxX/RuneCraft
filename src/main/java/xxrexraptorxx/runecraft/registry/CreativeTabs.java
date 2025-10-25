package xxrexraptorxx.runecraft.registry;

import guideme.Guides;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.main.References;

public class CreativeTabs {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, References.MODID);

    public static void init(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register(References.MODID,
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + References.MODID + ".main_tab")).icon(() -> ModItems.RUNE_V.get().getDefaultInstance())
                    .withTabsBefore(net.minecraft.world.item.CreativeModeTabs.SPAWN_EGGS).displayItems((params, output) -> {
                        output.accept(ModItems.BASIC_WAND.get());
                        output.accept(ModItems.AETHER_WAND.get());
                        output.accept(ModItems.NETHER_WAND.get());
                        output.accept(ModItems.CURSE_WAND.get());
                        output.accept(ModItems.HOLY_WAND.get());
                        output.accept(ModItems.STORM_WAND.get());
                        output.accept(ModItems.MAELSTROM_WAND.get());
                        output.accept(ModItems.ESCAPE_WAND.get());
                        output.accept(ModItems.DEFENSIVE_WAND.get());
                        output.accept(ModItems.THUNDER_WAND.get());
                        output.accept(ModItems.CREATURE_WAND.get());
                        output.accept(ModItems.CHANGING_WAND.get());
                        output.accept(ModItems.DESTRUCTION_WAND.get());
                        output.accept(ModItems.MAGICAL_CAP.get());
                        output.accept(ModItems.MAGICAL_ROBE.get());
                        output.accept(ModItems.MAGICAL_PANTS.get());
                        output.accept(ModItems.MAGICAL_BOOTS.get());
                        output.accept(ModItems.RITUAL_DAGGER.get());
                        output.accept(ModItems.MAGICAL_BOOK.get());
                        output.accept(ModItems.MAGICAL_PAGE.get());
                        output.accept(ModItems.SPELL_PAGE.get());
                        output.accept(ModItems.ENCHANTING_PAGE.get());
                        output.accept(ModItems.WAND_PAGE.get());
                        output.accept(ModItems.ORB_PAGE.get());
                        output.accept(ModItems.ALCHEMY_PAGE.get());
                        output.accept(ModItems.CURSE_PAGE.get());
                        output.accept(ModItems.LOST_PAGE.get());
                        output.accept(ModItems.BANNED_PAGE.get());
                        output.accept(ModItems.ORB.get());
                        output.accept(ModItems.SOUL_ORB.get());
                        output.accept(ModItems.SPIRIT_CRYSTAL.get());
                        output.accept(ModItems.SPIRIT_STAR.get());
                        output.accept(ModItems.SOUL.get());
                        output.accept(ModItems.CLOTH.get());
                        output.accept(ModItems.ASH.get());
                        output.accept(ModItems.RUNE_DUST.get());
                        output.accept(ModItems.RUNE_A.get());
                        output.accept(ModItems.RUNE_B.get());
                        output.accept(ModItems.RUNE_C.get());
                        output.accept(ModItems.RUNE_D.get());
                        output.accept(ModItems.RUNE_E.get());
                        output.accept(ModItems.RUNE_F.get());
                        output.accept(ModItems.RUNE_G.get());
                        output.accept(ModItems.RUNE_H.get());
                        output.accept(ModItems.RUNE_I.get());
                        output.accept(ModItems.RUNE_J.get());
                        output.accept(ModItems.RUNE_K.get());
                        output.accept(ModItems.RUNE_L.get());
                        output.accept(ModItems.RUNE_M.get());
                        output.accept(ModItems.RUNE_N.get());
                        output.accept(ModItems.RUNE_O.get());
                        output.accept(ModItems.RUNE_P.get());
                        output.accept(ModItems.RUNE_Q.get());
                        output.accept(ModItems.RUNE_R.get());
                        output.accept(ModItems.RUNE_S.get());
                        output.accept(ModItems.RUNE_T.get());
                        output.accept(ModItems.RUNE_U.get());
                        output.accept(ModItems.RUNE_V.get());
                        output.accept(ModItems.RUNE_W.get());
                        output.accept(ModItems.RUNE_X.get());
                        output.accept(ModItems.RUNE_Y.get());
                        output.accept(ModItems.RUNE_Z.get());
                        output.accept(ModItems.RUNE_DMG.get());
                        output.accept(ModItems.RUNE_FRE.get());
                        output.accept(ModItems.RUNE_HRD.get());
                        output.accept(ModItems.RUNE_PTL.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_A.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_B.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_C.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_D.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_E.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_F.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_G.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_H.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_I.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_J.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_K.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_L.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_M.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_N.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_O.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_P.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_Q.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_R.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_S.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_T.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_U.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_V.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_W.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_X.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_Y.get());
                        output.accept(ModItems.PORTABLE_RUNE_STONE_Z.get());
                        output.accept(ModBlocks.ASH_BLOCK.get());
                        output.accept(ModBlocks.RUNE_DUST_BLOCK.get());
                        output.accept(ModBlocks.ALTAR_BLOCK.get());
                        output.accept(ModBlocks.RUNE_SCRIBER_BLOCK.get());
                        output.accept(ModBlocks.RUIN_BLOCK.get());
                        output.accept(ModBlocks.RUNE_STONE.get());
                        output.accept(ModBlocks.RUNE_STONE_A.get());
                        output.accept(ModBlocks.RUNE_STONE_B.get());
                        output.accept(ModBlocks.RUNE_STONE_C.get());
                        output.accept(ModBlocks.RUNE_STONE_D.get());
                        output.accept(ModBlocks.RUNE_STONE_E.get());
                        output.accept(ModBlocks.RUNE_STONE_F.get());
                        output.accept(ModBlocks.RUNE_STONE_G.get());
                        output.accept(ModBlocks.RUNE_STONE_H.get());
                        output.accept(ModBlocks.RUNE_STONE_I.get());
                        output.accept(ModBlocks.RUNE_STONE_J.get());
                        output.accept(ModBlocks.RUNE_STONE_K.get());
                        output.accept(ModBlocks.RUNE_STONE_L.get());
                        output.accept(ModBlocks.RUNE_STONE_M.get());
                        output.accept(ModBlocks.RUNE_STONE_N.get());
                        output.accept(ModBlocks.RUNE_STONE_O.get());
                        output.accept(ModBlocks.RUNE_STONE_P.get());
                        output.accept(ModBlocks.RUNE_STONE_Q.get());
                        output.accept(ModBlocks.RUNE_STONE_R.get());
                        output.accept(ModBlocks.RUNE_STONE_S.get());
                        output.accept(ModBlocks.RUNE_STONE_T.get());
                        output.accept(ModBlocks.RUNE_STONE_U.get());
                        output.accept(ModBlocks.RUNE_STONE_V.get());
                        output.accept(ModBlocks.RUNE_STONE_W.get());
                        output.accept(ModBlocks.RUNE_STONE_X.get());
                        output.accept(ModBlocks.RUNE_STONE_Y.get());
                        output.accept(ModBlocks.RUNE_STONE_Z.get());
                        output.accept(ModBlocks.RUNE_STONE_DMG.get());
                        output.accept(ModBlocks.RUNE_STONE_FRE.get());
                        output.accept(ModBlocks.RUNE_STONE_HRD.get());
                        output.accept(ModBlocks.RUNE_STONE_PTL.get());

                        if (ModList.get().isLoaded("guideme")) {
                            output.accept(Guides.createGuideItem(ResourceLocation.fromNamespaceAndPath(References.MODID, "book_of_rune_magic")));
                        }
                    }).build());
}
