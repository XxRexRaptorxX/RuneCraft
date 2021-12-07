package xxrexraptorxx.runecraft.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.main.ModItems;

public class ItemArmorMagical extends ArmorItem {
    public ItemArmorMagical(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return stack.getItem() == ModItems.CLOTH.get();

    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide && player.getInventory().getArmor(3) != ItemStack.EMPTY && player.getInventory().getArmor(3).getItem() == ModItems.MAGICAL_CAP.get()
                && player.getInventory().getArmor(2) != ItemStack.EMPTY && player.getInventory().getArmor(2).getItem() == ModItems.MAGICAL_ROBE.get()
                && player.getInventory().getArmor(1) != ItemStack.EMPTY && player.getInventory().getArmor(1).getItem() == ModItems.MAGICAL_PANTS.get()
                && player.getInventory().getArmor(0) != ItemStack.EMPTY && player.getInventory().getArmor(0).getItem() == ModItems.MAGICAL_BOOTS.get()) {
            this.effectPlayer(player, MobEffects.FIRE_RESISTANCE, 0);
            this.effectPlayer(player, MobEffects.JUMP, 1);
        }
    }


    private void effectPlayer(Player player, MobEffect effect, int amplifier) {
        if (player.getEffect(effect) == null || player.getEffect(effect).getDuration() <= 70)
            player.addEffect(new MobEffectInstance(effect, 70, amplifier, true, true));
    }
}
