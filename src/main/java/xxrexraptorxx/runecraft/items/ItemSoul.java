package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemSoul extends Item {

    public ItemSoul() {
        super(new Properties()
                .stacksTo(16)
                .rarity(Rarity.UNCOMMON)
        );
    }

}
