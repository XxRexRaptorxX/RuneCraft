package xxrexraptorxx.runecraft.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import xxrexraptorxx.magmacore.utils.FormattingHelper;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

import java.util.Random;
import java.util.function.Consumer;

public class ItemPortableRuneStone extends Item {

    public ItemPortableRuneStone(Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(1).durability(200) // (Config.PORTABLE_RUNE_STONE_DURABILITY.get())
        );

    }


    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
        if (this != ModItems.PORTABLE_RUNE_STONE.get()) {
            list.accept(Component.literal(ChatFormatting.YELLOW + RuneHelper.getRuneName(BuiltInRegistries.ITEM.getKey(this).toString().substring(30))));
        }
        if (Config.getActivateRunestoneDescription() && this != ModItems.PORTABLE_RUNE_STONE.get()) {
            list.accept(FormattingHelper
                    .setModLangComponent("message", References.MODID, "contains").append(Component.literal(" " + BuiltInRegistries.MOB_EFFECT
                            .getKey(RuneHelper.getEffect(BuiltInRegistries.ITEM.getKey(this).toString().substring(30)).value()).toString().substring(10).replace("_", " ")))
                    .withStyle(ChatFormatting.GRAY));
        }
        if (this == ModItems.PORTABLE_RUNE_STONE.get()) {
            list.accept(FormattingHelper.setModLangComponent("message", References.MODID, "empty").withStyle(ChatFormatting.GRAY));
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        Random random = new Random();

        // test if the item is no empty rune stone
        if (this != ModItems.PORTABLE_RUNE_STONE.get()) {

            // test if used on a alter (to enable xp repair without using the wand effect)
            if (!level.getBlockState(context.getClickedPos()).getBlock().equals(ModBlocks.ALTAR_BLOCK.get())) {
                level.playSound((Player) null, player.position().x(), player.position().y(), player.position().z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F,
                        0.4F / (random.nextFloat() * 0.4F + 0.8F));

                // effect
                if (!level.isClientSide) {
                    if (Config.isActivatePortableRuneStonePublicEffect()) {

                        SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, 10, Config.getPortableSpellRadius(),
                                new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.ITEM.getKey(this).toString().substring(30)), Config.getPortableSpellDuration(),
                                        Config.getPortableSpellAmplifier()),
                                level, player.position());

                    } else {
                        player.addEffect(new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.ITEM.getKey(this).toString().substring(30)),
                                Config.getPortableSpellDuration(), Config.getPortableSpellAmplifier()));
                    }
                }

                // item stuff
                player.getCooldowns().addCooldown(stack, Config.getPortableSpellCooldown());
                stack.setDamageValue(stack.getDamageValue() + 1);

                if (level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));

                if (stack.getDamageValue() == stack.getMaxDamage()) {
                    level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F,
                            0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    stack.shrink(1);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

}
