package xxrexraptorxx.runecraft.utils;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.world.OreGenerator;

@Mod.EventBusSubscriber(modid = References.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        bus.addListener(OreGenerator::onBiomeLoadingEvent);
    }


    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGenerator.registerConfiguredFeatures();
        });

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_A.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_B.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_C.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_D.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_E.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_F.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_G.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_H.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_I.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_J.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_K.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_L.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_M.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_N.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_O.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_P.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_Q.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_R.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_S.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_T.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_U.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_V.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_W.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_X.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_Y.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_Z.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_PTL.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_HRD.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_FRE.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUNE_BLOCK_DMG.get(), RenderType.cutoutMipped());
    }

}
