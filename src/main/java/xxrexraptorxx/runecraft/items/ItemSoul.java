package xxrexraptorxx.runecraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import xxrexraptorxx.runecraft.utils.CreativeTab;

public class ItemSoul extends Item {

    public ItemSoul() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .stacksTo(16)
                .rarity(Rarity.UNCOMMON)
        );
    }

}
