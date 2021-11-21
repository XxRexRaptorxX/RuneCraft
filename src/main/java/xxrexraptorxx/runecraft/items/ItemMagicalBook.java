package xxrexraptorxx.runecraft.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;
import xxrexraptorxx.runecraft.utils.RuneHelper;

public class ItemMagicalBook extends Item {

    public ItemMagicalBook() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.RARE)
                .stacksTo(1)
                .durability(20)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return stack.getItem() == Items.ENCHANTED_BOOK;
    }


    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }


    @Override
    public ItemStack getContainerItem(ItemStack stack) {    //TODO Test break
        if (stack.getMaxDamage() == stack.getDamageValue()) {
            return (ItemStack) null;
        } else {
            ItemStack newItemStack = stack.copy();
            newItemStack.setDamageValue(stack.getDamageValue() + 1);
            return newItemStack;
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext player) {
        Level level = player.getLevel();

        if (!level.isClientSide) {
            AreaEffectCloud cloud = new AreaEffectCloud(level, player.getPlayer().position().x, player.getPlayer().position().y + 0.5F, player.getPlayer().position().z);
            cloud.setDuration(10);
            cloud.setRadius(1);
            cloud.setWaitTime(1);
            cloud.setFixedColor(0x616161);
            cloud.setParticle(ParticleTypes.ENCHANT);

            level.addFreshEntity(cloud);
        }
        return InteractionResult.SUCCESS;
    }

}
