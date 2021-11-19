package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemPortableRuneStone extends Item {

    public ItemPortableRuneStone() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.EPIC)
                .stacksTo(1)
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        list.add(new TextComponent(ChatFormatting.BLUE + RuneHelper.getRuneName(RuneHelper.getRegistryNameFromTag(stack))));

        if (Config.ACTIVATE_RUNESTONE_DESCRIPTION.get()) {
            list.add(new TextComponent((ChatFormatting.GRAY + "Contains: " + RuneHelper.getEffect(RuneHelper.getRegistryNameFromTag(stack)).getRegistryName().toString().substring(10))));
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext player) {
        Level level = player.getLevel();
        ItemStack stack = player.getItemInHand();
        Random random = new Random();

        level.playSound(player.getPlayer(), player.getPlayer().position().x, player.getPlayer().position().y, player.getPlayer().position().z, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        player.getPlayer().getCooldowns().addCooldown(this, Config.PORTABLE_SPELL_COOLDOWN.get());
        stack.setDamageValue(stack.getDamageValue() + 1); //TODO TEST + oder -

        if (!level.isClientSide) {
            AreaEffectCloud cloud = new AreaEffectCloud(level, player.getPlayer().position().x, player.getPlayer().position().y + 0.5F, player.getPlayer().position().z);
            cloud.setDuration(10);
            cloud.setRadius(Config.PORTABLE_SPELL_RADIUS.get());
            cloud.setWaitTime(2);
            cloud.setFixedColor(0x616161);
            cloud.setParticle(ParticleTypes.ENCHANT);

            if (Config.ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT.get()) {
                cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(RuneHelper.getRegistryNameFromTag(stack)), Config.PORTABLE_SPELL_DURATION.get(), Config.PORTABLE_SPELL_AMPLIFIER.get()));
                level.addFreshEntity(cloud);
            } else {
                player.getPlayer().addEffect(new MobEffectInstance(RuneHelper.getEffect(RuneHelper.getRegistryNameFromTag(stack)), Config.PORTABLE_SPELL_DURATION.get(), Config.PORTABLE_SPELL_AMPLIFIER.get()));
            }
        }
        return InteractionResult.SUCCESS;
    }

}
