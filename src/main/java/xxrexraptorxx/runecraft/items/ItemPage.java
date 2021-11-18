package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import xxrexraptorxx.runecraft.utils.CreativeTab;

public class ItemPage extends Item {

    public ItemPage() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.RARE)
                .stacksTo(16)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
