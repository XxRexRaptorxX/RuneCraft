package xxrexraptorxx.runecraft.items;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.registry.ModItems;

public class ItemArmorMagical extends ArmorItem {

    public ItemArmorMagical(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return stack.getItem() == ModItems.CLOTH.get();

    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(!level.isClientSide() && entity instanceof Player player) {

            Item helmet = player.getInventory().getArmor(3).getItem();
            Item chestplate = player.getInventory().getArmor(2).getItem();
            Item leggings = player.getInventory().getArmor(1).getItem();
            Item boots = player.getInventory().getArmor(0).getItem();

            if (helmet == ModItems.MAGICAL_CAP.get() && chestplate == ModItems.MAGICAL_ROBE.get() && leggings == ModItems.MAGICAL_PANTS.get() && boots == ModItems.MAGICAL_BOOTS.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 30, 1, false, false, true));
            }
        }
    }
}
