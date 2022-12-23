package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ItemRelict extends Item {

    public ItemRelict() {
        super(new Properties()
            .rarity(Rarity.RARE)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
