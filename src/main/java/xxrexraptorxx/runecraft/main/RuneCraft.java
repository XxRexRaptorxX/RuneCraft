package xxrexraptorxx.runecraft.main;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.runecraft.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/rune-craft
 **/
@Mod(References.MODID)
public class RuneCraft {

    public static final Logger LOGGER = LogManager.getLogger();
    private static final ResourceLocation CREATIVE_TAB = new ResourceLocation(References.MODID, "tab");


    public RuneCraft() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        Mod.EventBusSubscriber.Bus.MOD.bus().get().register(RuneCraft.class);

        Config.init();
        ModBlocks.init();
        ModItems.init();

        //ModConfiguredFeatures.register(modbus);   TODO!
        //ModPlacedFeatures.register(modbus);
    }


    //Creative Tab
    @SubscribeEvent
    public static void registerTabs(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(CREATIVE_TAB, (cf) -> cf.icon(() -> new ItemStack(ModItems.RUNE_V.get()))
                .title(Component.translatable("itemGroup." + References.MODID + "_tab")).displayItems((flagSet, output, ifSth) -> {
                    output.accept(ModItems..get());

                })
        );

}