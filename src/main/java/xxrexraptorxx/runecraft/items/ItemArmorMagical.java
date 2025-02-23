package xxrexraptorxx.runecraft.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.registry.ModItems;

public class ItemArmorMagical extends ArmorItem {

    public ItemArmorMagical(net.minecraft.world.item.equipment.ArmorMaterial material, ArmorType armorType, Item.Properties properties) {
        super(material, armorType, properties);
    }


    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player) {

            Item helmet = player.getInventory().getArmor(3).getItem();
            Item chestplate = player.getInventory().getArmor(2).getItem();
            Item leggings = player.getInventory().getArmor(1).getItem();
            Item boots = player.getInventory().getArmor(0).getItem();

            if (helmet == ModItems.MAGICAL_CAP.get() && chestplate == ModItems.MAGICAL_ROBE.get() && leggings == ModItems.MAGICAL_PANTS.get() && boots == ModItems.MAGICAL_BOOTS.get()) {
                if (!level.isClientSide) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, 1, false, false, true));
                }

                double d0 = (double) entity.position().x + (level.random.nextFloat() * 3.0F - 1.5F);
                double d1 = (double) entity.position().y + (level.random.nextFloat() * 3.0F - 1.0F);
                double d2 = (double) entity.position().z + (level.random.nextFloat() * 3.0F - 1.5F);

                if (level.getGameTime() % 50 == 0) {
                    level.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }


    }

}
