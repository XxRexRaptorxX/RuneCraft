package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import xxrexraptorxx.runecraft.utils.CreativeTab;

public class ItemRelict extends Item {

    public ItemRelict() {
        super(new Properties()
            .tab(CreativeTab.MOD_TAB)
            .rarity(Rarity.EPIC)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
