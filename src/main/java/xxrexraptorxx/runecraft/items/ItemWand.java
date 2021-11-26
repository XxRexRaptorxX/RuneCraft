package xxrexraptorxx.runecraft.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;

import java.math.MathContext;
import java.util.Random;

public class ItemWand extends Item {

    public ItemWand() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.EPIC)
                .stacksTo(1)
                .defaultDurability(200)
        );

    }


    @Override
    public InteractionResult useOn(UseOnContext player) {
        Level level = player.getLevel();
        Item item = player.getItemInHand().getItem();
        ItemStack stack = new ItemStack(item);
        Position pos = player.getPlayer().position();
        Random random = new Random();

        /** BASIC **/       //TODO: missing effect cloud
        if(item == ModItems.BASIC_WAND.get()) {
            level.playSound((Player)null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            if(!level.isClientSide) {
                AreaEffectCloud cloud1 = new AreaEffectCloud(level, pos.x() + 7.0F, pos.y() + 0.5F, pos.z());
                cloud1.setDuration(20);
                cloud1.setRadius(3F);
                cloud1.setParticle(ParticleTypes.FIREWORK);
                cloud1.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud1);

                AreaEffectCloud cloud2 = new AreaEffectCloud(level, pos.x() - 7.0F, pos.y() + 0.5F, pos.z());
                cloud2.setDuration(20);
                cloud2.setRadius(3F);
                cloud2.setParticle(ParticleTypes.FIREWORK);
                cloud2.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud2);

                AreaEffectCloud cloud3 = new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() + 7.0F);
                cloud3.setDuration(20);
                cloud3.setRadius(3F);
                cloud3.setParticle(ParticleTypes.FIREWORK);
                cloud3.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud3);

                AreaEffectCloud cloud4 = new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() - 7.0F);
                cloud4.setDuration(20);
                cloud4.setRadius(3F);
                cloud4.setParticle(ParticleTypes.FIREWORK);
                cloud4.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud4);

                AreaEffectCloud cloud5 = new AreaEffectCloud(level, pos.x() + 4.0F, pos.y() + 0.5F, pos.z() + 5.0F);
                cloud5.setDuration(20);
                cloud5.setRadius(3F);
                cloud5.setParticle(ParticleTypes.FIREWORK);
                cloud5.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud5);

                AreaEffectCloud cloud6 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() - 5.0F);
                cloud6.setDuration(20);
                cloud6.setRadius(3F);
                cloud6.setParticle(ParticleTypes.FIREWORK);
                cloud6.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud6);

                AreaEffectCloud cloud7 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() - 4.0F);
                cloud7.setDuration(20);
                cloud7.setRadius(3F);
                cloud7.setParticle(ParticleTypes.FIREWORK);
                cloud7.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud7);

                AreaEffectCloud cloud8 = new AreaEffectCloud(level, pos.x() + 5.0F, pos.y() + 0.5F, pos.z() - 5.0F);
                cloud8.setDuration(20);
                cloud8.setRadius(3F);
                cloud8.setParticle(ParticleTypes.FIREWORK);
                cloud8.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                level.addFreshEntity(cloud8);
            }

            /** CURSE **/
        } else if(item == ModItems.CURSE_WAND.get()) {
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            if (!level.isClientSide) {
                AreaEffectCloud cloud1 = new AreaEffectCloud(level, pos.x() + 7.0F, pos.y() + 0.5F, pos.z());
                cloud1.setDuration(20);
                cloud1.setRadius(3F);
                cloud1.setParticle(ParticleTypes.SMOKE);
                cloud1.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud1.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud1);

                AreaEffectCloud cloud2 = new AreaEffectCloud(level, pos.x() - 7.0F, pos.y() + 0.5F, pos.z());
                cloud2.setDuration(20);
                cloud2.setRadius(3F);
                cloud2.setParticle(ParticleTypes.SMOKE);
                cloud2.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud2.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud2);

                AreaEffectCloud cloud3 = new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() + 7.0F);
                cloud3.setDuration(20);
                cloud3.setRadius(3F);
                cloud3.setParticle(ParticleTypes.SMOKE);
                cloud3.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud3.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud3);

                AreaEffectCloud cloud4 = new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() - 7.0F);
                cloud4.setDuration(20);
                cloud4.setRadius(3F);
                cloud4.setParticle(ParticleTypes.SMOKE);
                cloud4.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud4.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud4);

                AreaEffectCloud cloud5 = new AreaEffectCloud(level, pos.x() + 4.0F, pos.y() + 0.5F, pos.z() + 5.0F);
                cloud5.setDuration(20);
                cloud5.setRadius(3F);
                cloud5.setParticle(ParticleTypes.SMOKE);
                cloud5.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud5.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud5);

                AreaEffectCloud cloud6 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() - 5.0F);
                cloud6.setDuration(20);
                cloud6.setRadius(3F);
                cloud6.setParticle(ParticleTypes.SMOKE);
                cloud6.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud6.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud6);

                AreaEffectCloud cloud7 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() - 4.0F);
                cloud7.setDuration(20);
                cloud7.setRadius(3F);
                cloud7.setParticle(ParticleTypes.SMOKE);
                cloud7.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud7.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud7);

                AreaEffectCloud cloud8 = new AreaEffectCloud(level, pos.x() + 5.0F, pos.y() + 0.5F, pos.z() - 5.0F);
                cloud8.setDuration(20);
                cloud8.setRadius(3F);
                cloud8.setParticle(ParticleTypes.SMOKE);
                cloud8.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                cloud8.addEffect(new MobEffectInstance(MobEffects.HARM, 10, 0));
                level.addFreshEntity(cloud8);
                //special cloud
                AreaEffectCloud cloud9 = new AreaEffectCloud(level, pos.x() + 5.0F, pos.y() + 0.5F, pos.z() - 5.0F);
                cloud9.setDuration(20);
                cloud9.setRadius(3F);
                cloud9.setParticle(ParticleTypes.LARGE_SMOKE);
                cloud9.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                player.getPlayer().hurt(DamageSource.MAGIC, 2.0F);
                level.addFreshEntity(cloud9);
            }

        /** HOLY **/
        } else if(item == ModItems.HOLY_WAND.get()) {
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            if(!level.isClientSide) {
                AreaEffectCloud cloud = new AreaEffectCloud(level, player.getPlayer().position().x, player.getPlayer().position().y + 0.5F, player.getPlayer().position().z);
                cloud.setDuration(10);
                cloud.setRadius(2.0F);
                cloud.setParticle(ParticleTypes.HEART);
                cloud.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
                level.addFreshEntity(cloud);
            }

        /** NETHER **/
        } else if(item == ModItems.NETHER_WAND.get()) {
            BlockPos blockPos = player.getClickedPos();
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

                if (level.getBlockState(blockPos.above()).isAir()) { //TODO: check every blockpos for air
                    level.setBlock(blockPos, Blocks.FIRE.defaultBlockState(), 11);
                    level.setBlock(blockPos.offset(1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                    level.setBlock(blockPos.offset(0, 1, 1), Blocks.FIRE.defaultBlockState(), 11);
                    level.setBlock(blockPos.offset(-1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                    level.setBlock(blockPos.offset(0, 1, -1), Blocks.FIRE.defaultBlockState(), 11);
                }
            if (!level.isClientSide) {
                AreaEffectCloud cloud = new AreaEffectCloud(level, blockPos.getX() + 0.5F, blockPos.getY(), blockPos.getZ() + 0.5F);
                cloud.setDuration(100);
                cloud.setRadius(1.0F);
                cloud.setParticle(ParticleTypes.LAVA);
                level.addFreshEntity(cloud);
            }

        /** MAELSTROM **/
        } else if (item == ModItems.MAELSTROM_WAND.get()) {
            if(!level.isClientSide) {
                AreaEffectCloud cloud1 = new AreaEffectCloud(level, player.getPlayer().getX() + 7.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ());
                cloud1.setDuration(20);
                cloud1.setRadius(3F);
                cloud1.setParticle(ParticleTypes.SMOKE);
                cloud1.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud1);

                AreaEffectCloud cloud2 = new AreaEffectCloud(level, player.getPlayer().getX() - 7.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ());
                cloud2.setDuration(20);
                cloud2.setRadius(3F);
                cloud2.setParticle(ParticleTypes.SMOKE);
                cloud2.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud2);

                AreaEffectCloud cloud3 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() + 7.0F);
                cloud3.setDuration(20);
                cloud3.setRadius(3F);
                cloud3.setParticle(ParticleTypes.SMOKE);
                cloud3.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud3);

                AreaEffectCloud cloud4 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() - 7.0F);
                cloud4.setDuration(20);
                cloud4.setRadius(3F);
                cloud4.setParticle(ParticleTypes.SMOKE);
                cloud4.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud4);

                AreaEffectCloud cloud5 = new AreaEffectCloud(level, player.getPlayer().getX() + 4.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() + 5.0);
                cloud5.setDuration(20);
                cloud5.setRadius(3F);
                cloud5.setParticle(ParticleTypes.SMOKE);
                cloud5.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud5);

                AreaEffectCloud cloud6 = new AreaEffectCloud(level, player.getPlayer().getX() - 4.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() - 5.0);
                cloud6.setDuration(20);
                cloud6.setRadius(3F);
                cloud6.setParticle(ParticleTypes.SMOKE);
                cloud6.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud6);

                AreaEffectCloud cloud7 = new AreaEffectCloud(level, player.getPlayer().getX() - 4.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() + 4.0);
                cloud7.setDuration(20);
                cloud7.setRadius(3F);
                cloud7.setParticle(ParticleTypes.SMOKE);
                cloud7.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud7);

                AreaEffectCloud cloud8 = new AreaEffectCloud(level, player.getPlayer().getX() + 5.0F, player.getPlayer().getY() + 0.5F, player.getPlayer().getZ() - 5.0);
                cloud8.setDuration(20);
                cloud8.setRadius(3F);
                cloud8.setParticle(ParticleTypes.SMOKE);
                cloud8.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                level.addFreshEntity(cloud8);

                AreaEffectCloud cloud9 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY(), player.getPlayer().getZ());
                cloud9.setDuration(10);
                cloud9.setRadius(4.0F);
                cloud9.setParticle(ParticleTypes.LAVA);
                level.addFreshEntity(cloud9);
            }
        }


        player.getPlayer().getCooldowns().addCooldown(this, 100);
        stack.setDamageValue(stack.getDamageValue() + 1);

        if(stack.getDamageValue() == stack.getMaxDamage()) {
            level.playSound((Player) null, player.getPlayer().getX(), player.getPlayer().getY(), player.getPlayer().getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            stack.shrink(1);
        }

        //return InteractionResult.sidedSuccess(level.isClientSide);
        return InteractionResult.SUCCESS;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        Item item = stack.getItem();
        Level level = player.level;
        Random random = new Random();

        level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        /** AETHER **/
        if(item == ModItems.AETHER_WAND.get()) {
            if (entity instanceof Player) {
                Player entityIn = (Player) entity ;

                entityIn.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));
                entityIn.hurt(DamageSource.GENERIC, 1.0F);
            }
            if (entity instanceof LivingEntity) {
                LivingEntity entityIn = (LivingEntity) entity;
                entityIn.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));
                entityIn.hurt(DamageSource.GENERIC, 1.0F);
            }

        /** CURSE **/
        } else if (item == ModItems.CURSE_WAND.get()) {
            if (entity instanceof Player) {
                Player entityIn = (Player) entity ;

                entityIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                entityIn.hurt(DamageSource.MAGIC, 4.0F);
                player.hurt(DamageSource.MAGIC, 1.0F);
            }
            if (entity instanceof LivingEntity) {
                LivingEntity entityIn = (LivingEntity) entity ;
                entityIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                entityIn.hurt(DamageSource.MAGIC, 4.0F);
                player.hurt(DamageSource.MAGIC, 1.0F);
            }

        /** HOLY **/
        } else if (item == ModItems.HOLY_WAND.get()) {
            if (entity instanceof Player) {
                Player entityIn = (Player) entity ;

                entityIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
            }
            if (entity instanceof LivingEntity) {
                LivingEntity entityIn = (LivingEntity) entity ;
                entityIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
            }

        /** STORM **/
        } else if (item == ModItems.STORM_WAND.get()) {
            if (!level.isClientSide) {
                AreaEffectCloud cloud1 = new AreaEffectCloud(level, player.position().x, player.position().y + 0.5F, player.position().z);
                cloud1.setRadius(2.0F);
                cloud1.setDuration(3);
                cloud1.setWaitTime(0);
                cloud1.setParticle(ParticleTypes.SMOKE);
                level.addFreshEntity(cloud1);

                AreaEffectCloud cloud2 = new AreaEffectCloud(level, player.position().x, player.position().y + 0.5F, player.position().z);
                cloud2.setRadius(2.0F);
                cloud2.setDuration(3);
                cloud2.setWaitTime(0);
                cloud2.setParticle(ParticleTypes.SMOKE);
                level.addFreshEntity(cloud2);

                //player.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(20);
            }


        /** NETHER **/
        } else if (item == ModItems.NETHER_WAND.get()) {
            entity.setSecondsOnFire(10);

        /** MAELSTROM **/
        } else if (item == ModItems.MAELSTROM_WAND.get()) {
            if (entity instanceof Player) {
                Player entityIn = (Player) entity ;

                entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                entityIn.hurt(DamageSource.MAGIC, 1.0F);
            }
            if (entity instanceof LivingEntity) {
                LivingEntity entityIn = (LivingEntity) entity ;
                entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                entityIn.hurt(DamageSource.MAGIC, 1.0F);
            }
        }


        player.getCooldowns().addCooldown(this, 150);
        stack.setDamageValue(stack.getDamageValue() + 1);

        if(stack.getDamageValue() == stack.getMaxDamage()) {
            player.level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            stack.shrink(1);
        }
        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        /** STORM **/  //TODO
        if(stack.getItem() == ModItems.STORM_WAND.get() && stack.isEnchanted() == false) {
            stack.enchant(Enchantments.KNOCKBACK, 5);
        }
    }


    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity player) {
        Random random = new Random();

        /** AETHER **/          //TODO: x/z push
        if(stack.getItem() == ModItems.AETHER_WAND.get()) {
            player.level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.PHANTOM_FLAP, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.setDeltaMovement(0, 0.5D, 0);
            player.fallDistance = 0.0F;
            stack.setDamageValue(stack.getDamageValue() + 1);

            player.level.addParticle(ParticleTypes.SWEEP_ATTACK, player.position().x, player.position().y + 1, player.position().z, 0.0D, 0.0D, 0.0D);
        }

        if(stack.getDamageValue() == stack.getMaxDamage()) {
            player.level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            stack.shrink(1);
        }

        return true;
    }

}

