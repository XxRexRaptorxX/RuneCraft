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
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

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
        spawnSpellEffect(shape, particleType, duration, radius, (ArrayList<MobEffectInstance>) null, level, pos);
    }


    public static void spawnParticleEffects(ParticleShapeTypes type, ParticleOptions particleTypes, Level level, BlockPos pos) {
        if (type == ParticleShapeTypes.ITEM_USED) {
            for (int i = 0; i < 2; i++) {
                level.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                level.addParticle(particleTypes, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                level.addParticle(particleTypes, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                level.addParticle(particleTypes, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                level.addParticle(particleTypes, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
            }

        } else if (type == ParticleShapeTypes.BLOCK_AMBIENT) {
            double d0 = (double) pos.getX() + 0.5F + (level.random.nextFloat() * 3.0F - 1.5F);
            double d1 = (double) pos.getY() + 1.0F + (level.random.nextFloat() * 1.5F);
            double d2 = (double) pos.getZ() + 0.5F + (level.random.nextFloat() * 3.0F - 1.5F);

            level.addParticle(particleTypes, d0, d1, d2, 0.0D, 0.0D, 0.0D);

        } else if (type == ParticleShapeTypes.BLOCK_AMBIENT_TOP) {
            double d0 = (double) ((float) pos.getX() + level.random.nextFloat());
            double d1 = (double) ((float) pos.getY() + 1.1F);
            double d2 = (double) ((float) pos.getZ() + level.random.nextFloat());

            level.addParticle(particleTypes, d0, d1, d2, 0.0D, 0.0D, 0.0D);

        } else if (type == ParticleShapeTypes.BLOCK_EVENT) {
            double d0 = (double) ((float) pos.getX() + level.random.nextFloat());
            double d1 = (double) ((float) pos.getY() + 0.8F);
            double d2 = (double) ((float) pos.getZ() + level.random.nextFloat());

            level.addParticle(particleTypes, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            level.addParticle(particleTypes, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
            level.addParticle(particleTypes, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);

        } else if (type == ParticleShapeTypes.PENTERGRAM) {
            // Calculate the center position above the block
            double centerX = pos.getX() + 0.5;
            double centerY = pos.getY() + 0.5;
            double centerZ = pos.getZ() + 0.5;

            // Define radii for the circles
            double innerRadius = 2.5; // Circle that touches the star tips (for a 5x5 block area)
            double outerRadius = innerRadius + 0.5; // Outer circle is 0.5 blocks larger

            int points = 5;
            int resolution = 80; // Resolution for drawing the pentagram lines

            // Calculate angles for each star tip (rotated -90 degrees to have one tip pointing up)
            double[] angles = new double[points];
            for (int i = 0; i < points; i++) {
                angles[i] = Math.toRadians(72 * i - 90);
            }

            // Spawn pentagram lines by connecting every second point
            for (int i = 0; i < points; i++) {
                int nextIndex = (i + 2) % points; // Connect current point to the one two steps ahead
                double x1 = centerX + Math.cos(angles[i]) * innerRadius;
                double z1 = centerZ + Math.sin(angles[i]) * innerRadius;
                double x2 = centerX + Math.cos(angles[nextIndex]) * innerRadius;
                double z2 = centerZ + Math.sin(angles[nextIndex]) * innerRadius;

                // Interpolate along the line for a high-resolution effect
                for (int j = 0; j < resolution; j++) {
                    double t = (double) j / resolution;
                    double px = x1 + (x2 - x1) * t;
                    double pz = z1 + (z2 - z1) * t;
                    level.addParticle(particleTypes, px, centerY, pz, 0.0D, 0.0D, 0.0D);
                }
            }

            // Spawn particles along the inner circle (touching the star tips)
            int circleResolution = 100;
            for (int i = 0; i < circleResolution; i++) {
                double theta = 2 * Math.PI * i / circleResolution;
                double px = centerX + Math.cos(theta) * innerRadius;
                double pz = centerZ + Math.sin(theta) * innerRadius;
                level.addParticle(particleTypes, px, centerY, pz, 0.0D, 0.0D, 0.0D);
            }

            // Spawn particles along the outer circle (0.5 blocks larger)
            for (int i = 0; i < circleResolution; i++) {
                double theta = 2 * Math.PI * i / circleResolution;
                double px = centerX + Math.cos(theta) * outerRadius;
                double pz = centerZ + Math.sin(theta) * outerRadius;
                level.addParticle(particleTypes, px, centerY, pz, 0.0D, 0.0D, 0.0D);
            }

            // Spawn a fire particle at each star tip between the two circles
            // The particle is positioned halfway between the inner and outer circles
            double fireRadius = innerRadius + 0.25;
            for (int i = 0; i < points; i++) {
                double px = centerX + Math.cos(angles[i]) * fireRadius;
                double pz = centerZ + Math.sin(angles[i]) * fireRadius;
                level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, px, centerY + 0.5F, pz, 0.0D, 0.0D, 0.0D);
            }
        }
    }

}
