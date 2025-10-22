package xxrexraptorxx.runecraft.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import xxrexraptorxx.runecraft.registry.ModItems;

public class ItemArmorMagical extends Item {

    public ItemArmorMagical(Item.Properties properties) {
        super(properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof Player player) {

            Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();
            Item chestplate = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item leggings = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item boots = player.getItemBySlot(EquipmentSlot.FEET).getItem();

            if (helmet == ModItems.MAGICAL_CAP.get() && chestplate == ModItems.MAGICAL_ROBE.get() && leggings == ModItems.MAGICAL_PANTS.get()
                    && boots == ModItems.MAGICAL_BOOTS.get()) {
                if (!level.isClientSide) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, false, false, true));
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 40, 1, false, false, true));
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
