package xxrexraptorxx.runecraft.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

public class CreativeTab {

    public static CreativeModeTab MOD_TAB = new CreativeModeTab(References.MODID + "Tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RUNE_V.get());
        }
    };
}
