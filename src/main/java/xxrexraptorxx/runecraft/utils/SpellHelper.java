package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SpellHelper {

    public static void spawnSpellEffect(SpellShapes shape, ParticleOptions particleType, int duration, float radius, @Nullable ArrayList<MobEffectInstance> effects, Level level, Position pos) {
        List<AreaEffectCloud> areaEffectClouds = new ArrayList<>();
        if (!level.isClientSide) {
            if (shape == SpellShapes.RING) {
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() + 7.0F, pos.y() + 0.5F, pos.z()));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() - 7.0F, pos.y() + 0.5F, pos.z()));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() + 7.0F));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z() - 7.0F));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() + 4.0F, pos.y() + 0.5F, pos.z() + 5.0F));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() - 5.0F));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() + 5.0F));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x() + 5.0F, pos.y() + 0.5F, pos.z() - 4.0F));

            } else if (shape == SpellShapes.SINGLE) {
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z()));

            } else if (shape == SpellShapes.STACKED) {
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 0.5F, pos.z()));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 1.0F, pos.z()));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 1.5F, pos.z()));
                areaEffectClouds.add(new AreaEffectCloud(level, pos.x(), pos.y() + 2.0F, pos.z()));
            }

            for (AreaEffectCloud cloud : areaEffectClouds) {
                cloud.setDuration(duration);
                cloud.setRadius(radius);
                cloud.setParticle(particleType);

                if (effects != null) {
                    for (MobEffectInstance effectInstance : effects) {
                        cloud.addEffect(effectInstance);
                    }
                }

                level.addFreshEntity(cloud);
            }
        }
    }


    public static void spawnSpellEffect(SpellShapes shape, ParticleOptions particleType, int duration, float radius, MobEffectInstance effect, Level level, Position pos) {
        ArrayList<MobEffectInstance> effectInstances = new ArrayList<>();
        effectInstances.add(effect);

        spawnSpellEffect(shape, particleType, duration, radius, effectInstances, level, pos);
    }

        public static void addPlayerEffects(Entity entity, @Nullable MobEffectInstance effectInstance, float damageAmount) {
        Level level = entity.level();

        if (!level.isClientSide) {
            if (entity instanceof Player entityIn) {
                if (effectInstance != null) entityIn.addEffect(effectInstance);
                if (damageAmount < 0) entityIn.hurt(level.damageSources().magic(), damageAmount);

            } else if (entity instanceof LivingEntity entityIn) {
                if (effectInstance != null) entityIn.addEffect(effectInstance);
                if (damageAmount < 0) entityIn.hurt(level.damageSources().magic(), damageAmount);
            }
        }
    }


    public static void spawnSpellEffect(SpellShapes shape, ParticleOptions particleType, int duration, float radius, Level level, Position pos) {
        spawnSpellEffect(shape, particleType, duration, radius, (MobEffectInstance) null, level, pos);
    }


    public static void spawnParticleEffects(Level level, BlockPos pos) {
        for (int i = 0; i < 2; i++) {
            level.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
        }
    }

}
