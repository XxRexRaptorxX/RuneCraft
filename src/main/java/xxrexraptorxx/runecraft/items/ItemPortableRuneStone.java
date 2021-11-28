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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.main.ModItems;
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
                .defaultDurability(Config.PORTABLE_RUNE_STONE_DURABILITY.get())
        );

    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        if(this != ModItems.PORTABLE_RUNE_STONE.get()) {
            list.add(new TextComponent(ChatFormatting.YELLOW + RuneHelper.getRuneName(this.asItem().getRegistryName().toString().substring(30))));
        }
        if(Config.ACTIVATE_RUNESTONE_DESCRIPTION.get() && this != ModItems.PORTABLE_RUNE_STONE.get()) {
            list.add(new TextComponent((ChatFormatting.GRAY + "Contains: " + RuneHelper.getEffect(this.getRegistryName().toString().substring(30)).getRegistryName().toString().substring(10).replace("_", " "))));
        }
        if(this == ModItems.PORTABLE_RUNE_STONE.get()) {
            list.add(new TextComponent((ChatFormatting.GRAY + "Empty")));
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext player) {
        if(this != ModItems.PORTABLE_RUNE_STONE.get()) {
            Level level = player.getLevel();
            ItemStack stack = player.getItemInHand();
            Random random = new Random();

            level.playSound((Player) null, player.getPlayer().position().x(), player.getPlayer().position().y(), player.getPlayer().position().z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.getPlayer().getCooldowns().addCooldown(this, Config.PORTABLE_SPELL_COOLDOWN.get());
            stack.setDamageValue(stack.getDamageValue() + 1);

            if (!level.isClientSide) {
                AreaEffectCloud cloud = new AreaEffectCloud(level, player.getPlayer().position().x, player.getPlayer().position().y + 0.5F, player.getPlayer().position().z);
                cloud.setDuration(10);
                cloud.setRadius(Config.PORTABLE_SPELL_RADIUS.get());
                cloud.setWaitTime(2);
                cloud.setFixedColor(0x616161);
                cloud.setParticle(ParticleTypes.ENCHANT);

                if (Config.ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT.get()) {
                    cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(this.getRegistryName().toString().substring(30)), Config.PORTABLE_SPELL_DURATION.get(), Config.PORTABLE_SPELL_AMPLIFIER.get()));
                } else {
                    player.getPlayer().addEffect(new MobEffectInstance(RuneHelper.getEffect(this.getRegistryName().toString().substring(30)), Config.PORTABLE_SPELL_DURATION.get(), Config.PORTABLE_SPELL_AMPLIFIER.get()));
                }
                level.addFreshEntity(cloud);
            }

            if (stack.getDamageValue() == stack.getMaxDamage()) {
                level.playSound((Player) null, player.getPlayer().getX(), player.getPlayer().getY(), player.getPlayer().getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                stack.shrink(1);
            }
        }
        return InteractionResult.SUCCESS;
    }

}
