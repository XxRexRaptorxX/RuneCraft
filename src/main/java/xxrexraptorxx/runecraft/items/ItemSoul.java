package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ItemSoul extends Item {

    public ItemSoul(Properties properties) {
        super(properties
                .stacksTo(16)
                .rarity(Rarity.UNCOMMON)
        );
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

}
