package xxrexraptorxx.runecraft.items;

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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;

import java.util.Random;

public class ItemWand extends Item {

    public ItemWand() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
                .rarity(Rarity.EPIC)
                .durability(200)
                //.stacksTo(1) TODO
        );

    }


    @Override
    public InteractionResult useOn(UseOnContext player) {
        Level level = player.getLevel();
        Item item = player.getItemInHand().getItem();
        ItemStack stack = new ItemStack(item);
        Position pos = player.getPlayer().position();
        Random random = new Random();

        /** BASIC **/
        if(item == ModItems.BASIC_WAND.get()) {
            level.playSound((Player)null, pos.x(), pos.y(), pos.z(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

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

        /** AETHER **/
        } else if(item == ModItems.AETHER_WAND.get()) {
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ELYTRA_FLYING, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.getPlayer().setJumping(true);
            player.getPlayer().fallDistance = 0.0F;
            player.getPlayer().sweepAttack(); //TODO TEST

       /** CURSE **/
        } else if(item == ModItems.CURSE_WAND.get()) {
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

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


        }






        player.getItemInHand().hurtAndBreak(1, player.getPlayer(), (p_43122_) -> { p_43122_.broadcastBreakEvent(player.getHand());});
        //stack.setDamageValue(stack.getDamageValue() - 1); //TODO + oder -

        return InteractionResult.sidedSuccess(level.isClientSide);
            //return InteractionResult.SUCCESS;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        Item item = stack.getItem();

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
                entityIn.hurt(DamageSource.MAGIC, 4.0F);
                player.hurt(DamageSource.MAGIC, 1.0F);
            }
            if (entity instanceof LivingEntity) {
                LivingEntity entityIn = (LivingEntity) entity ;
                entityIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                entityIn.hurt(DamageSource.MAGIC, 4.0F);
                player.hurt(DamageSource.MAGIC, 1.0F);

            }

        /** HOLY **/
        } else if (item == ModItems.HOLY_WAND.get()) {
            //DO STUFF
        }


        stack.setDamageValue(stack.getDamageValue() - 1); //TODO + oder -
        return true;
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return stack.getItem() == ModItems.SPIRIT_CRYSTAL.get();
    }
}
