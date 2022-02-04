package xxrexraptorxx.runecraft.items;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.CreativeTab;

import javax.annotation.Nullable;
import java.util.Collection;
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
        ItemStack stack = player.getItemInHand();
        Position pos = player.getPlayer().position();
        Random random = new Random();

        //test if used on a alter (to enable xp repair without using the wand effect)
        if (!level.getBlockState(player.getClickedPos()).getBlock().equals(ModBlocks.ALTAR_BLOCK.get())) {

            //test if the item is a wand
            if (item == ModItems.CURSE_WAND.get() || item == ModItems.HOLY_WAND.get() || item == ModItems.BASIC_WAND.get() ||
                    item == ModItems.MAELSTROM_WAND.get() || item == ModItems.NETHER_WAND.get() || item == ModItems.ESCAPE_WAND.get() || item == ModItems.DESTRUCTION_WAND.get() ||
                    item == ModItems.THUNDER_WAND.get() || item == ModItems.DEFENSIVE_WAND.get() || item == ModItems.CHANGING_WAND.get() || item == ModItems.CREATURE_WAND.get()) {

                /** BASIC **/
                if (item == ModItems.BASIC_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
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

                        AreaEffectCloud cloud7 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() + 4.0F);
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
                } else if (item == ModItems.CURSE_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
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

                        AreaEffectCloud cloud7 = new AreaEffectCloud(level, pos.x() - 4.0F, pos.y() + 0.5F, pos.z() + 4.0F);
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
                } else if (item == ModItems.HOLY_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
                        AreaEffectCloud cloud = new AreaEffectCloud(level, player.getPlayer().position().x, player.getPlayer().position().y + 0.5F, player.getPlayer().position().z);
                        cloud.setDuration(10);
                        cloud.setRadius(2.0F);
                        cloud.setParticle(ParticleTypes.HEART);
                        cloud.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
                        level.addFreshEntity(cloud);
                    }

                    /** NETHER **/
                } else if (item == ModItems.NETHER_WAND.get()) {
                    BlockPos blockPos = player.getClickedPos();
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

                    if (level.getBlockState(blockPos.above()).isAir())
                        level.setBlock(blockPos.above(), Blocks.FIRE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(1, 1, 0)).isAir())
                        level.setBlock(blockPos.offset(1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 1, 1)).isAir())
                        level.setBlock(blockPos.offset(0, 1, 1), Blocks.FIRE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(-1, 1, 0)).isAir())
                        level.setBlock(blockPos.offset(-1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 1, -1)).isAir())
                        level.setBlock(blockPos.offset(0, 1, -1), Blocks.FIRE.defaultBlockState(), 11);

                    if (!level.isClientSide) {
                        AreaEffectCloud cloud = new AreaEffectCloud(level, blockPos.getX() + 0.5F, blockPos.getY(), blockPos.getZ() + 0.5F);
                        cloud.setDuration(100);
                        cloud.setRadius(1.0F);
                        cloud.setParticle(ParticleTypes.LAVA);
                        level.addFreshEntity(cloud);
                    }

                    /** MAELSTROM **/
                } else if (item == ModItems.MAELSTROM_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
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

                    /** ESCAPE **/
                } else if (item == ModItems.ESCAPE_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
                        player.getPlayer().addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000));
                        player.getPlayer().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 1));

                        AreaEffectCloud cloud1 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 0.5, player.getPlayer().getZ());
                        cloud1.setDuration(500);
                        cloud1.setRadius(15F);
                        cloud1.setWaitTime(0);
                        cloud1.setParticle(ParticleTypes.LARGE_SMOKE);
                        level.addFreshEntity(cloud1);

                        AreaEffectCloud cloud2 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 1.0F, player.getPlayer().getZ());
                        cloud2.setDuration(500);
                        cloud2.setRadius(12F);
                        cloud2.setWaitTime(0);
                        cloud2.setParticle(ParticleTypes.LARGE_SMOKE);
                        level.addFreshEntity(cloud2);

                        AreaEffectCloud cloud3 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 1.5F, player.getPlayer().getZ());
                        cloud3.setDuration(500);
                        cloud3.setRadius(10F);
                        cloud3.setWaitTime(0);
                        cloud3.setParticle(ParticleTypes.LARGE_SMOKE);
                        level.addFreshEntity(cloud3);

                        AreaEffectCloud cloud4 = new AreaEffectCloud(level, player.getPlayer().getX(), player.getPlayer().getY() + 2.0F, player.getPlayer().getZ());
                        cloud4.setDuration(500);
                        cloud4.setRadius(5F);
                        cloud4.setWaitTime(0);
                        cloud4.setParticle(ParticleTypes.LARGE_SMOKE);
                        level.addFreshEntity(cloud4);
                    }

                    /** DESTRUCTION **/
                } else if (item == ModItems.DESTRUCTION_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

                    if (player.getPlayer().isShiftKeyDown())
                        player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
                        if (player.getPlayer().isShiftKeyDown()) {
                            level.addFreshEntity(new PrimedTnt(level, player.getClickedPos().getX(), player.getClickedPos().getY(), player.getClickedPos().getZ(), player.getPlayer()));
                        } else {
                            level.setBlock(player.getClickedPos(), Blocks.AIR.defaultBlockState(), 11);
                        }
                    }

                    /** THUNDER **/
                } else if (item == ModItems.THUNDER_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    if (!level.isClientSide) {
                        if (player.getPlayer().isShiftKeyDown()) {
                            level.getLevelData().setRaining(true);
                            level.setThunderLevel(1);
                        } else {
                            level.getLevelData().setRaining(false);
                        }
                    }

                    /** DEFENSIVE **/
                } else if (item == ModItems.DEFENSIVE_WAND.get()) {
                    BlockPos blockPos = player.getPlayer().blockPosition();

                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());
                    player.getPlayer().addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0));


                    if (player.getPlayer().isShiftKeyDown()) {
                        if (level.getBlockState(blockPos.offset(0, -1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, -1, 0), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 2, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, 2, 0), Blocks.AIR.defaultBlockState(), 11);

                        if (level.getBlockState(blockPos.offset(1, 0, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(1, 0, 0), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(-1, 0, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(-1, 0, 0), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 0, 1)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, 0, 1), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 0, -1)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, 0, -1), Blocks.AIR.defaultBlockState(), 11);

                        if (level.getBlockState(blockPos.offset(1, 1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(1, 1, 0), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(-1, 1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(-1, 1, 0), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 1, 1)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, 1, 1), Blocks.AIR.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 1, -1)) == Blocks.COBBLESTONE.defaultBlockState())
                            level.setBlock(blockPos.offset(0, 1, -1), Blocks.AIR.defaultBlockState(), 11);

                    } else {
                        if (level.getBlockState(blockPos.offset(0, -1, 0)).isAir() || level.getBlockState(blockPos.offset(0, -1, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, -1, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, -1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 2, 0)).isAir() || level.getBlockState(blockPos.offset(0, 2, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, 2, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, 2, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);

                        if (level.getBlockState(blockPos.offset(1, 0, 0)).isAir() || level.getBlockState(blockPos.offset(1, 0, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(1, 0, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(1, 0, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(-1, 0, 0)).isAir() || level.getBlockState(blockPos.offset(-1, 0, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(-1, 0, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(-1, 0, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 0, 1)).isAir() || level.getBlockState(blockPos.offset(0, 0, 1)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, 0, 1)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, 0, 1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 0, -1)).isAir() || level.getBlockState(blockPos.offset(0, 0, -1)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, 0, -1)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, 0, -1), Blocks.COBBLESTONE.defaultBlockState(), 11);

                        if (level.getBlockState(blockPos.offset(1, 1, 0)).isAir() || level.getBlockState(blockPos.offset(1, 1, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(1, 1, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(1, 1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(-1, 1, 0)).isAir() || level.getBlockState(blockPos.offset(-1, 1, 0)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(-1, 1, 0)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(-1, 1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 1, 1)).isAir() || level.getBlockState(blockPos.offset(0, 1, 1)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, 1, 1)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, 1, 1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                        if (level.getBlockState(blockPos.offset(0, 1, -1)).isAir() || level.getBlockState(blockPos.offset(0, 1, -1)).is(BlockTags.REPLACEABLE_PLANTS) || level.getBlockState(blockPos.offset(0, 1, -1)).is(Blocks.SNOW))
                            level.setBlock(blockPos.offset(0, 1, -1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    }

                    /** CHANGING **/
                } else if (item == ModItems.CHANGING_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

                    if (!level.isClientSide && player != null) {
                        BlockPos blockpos = player.getClickedPos();
                        if (!this.handleInteraction(player.getPlayer(), level.getBlockState(blockpos), level, blockpos, true, player.getItemInHand())) {
                            return InteractionResult.FAIL;
                        }
                    }


                    /** CREATURE **/
                } else if (item == ModItems.CREATURE_WAND.get()) {
                    level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    player.getPlayer().getCooldowns().addCooldown(this, Config.WAND_COOLDOWN.get());

                    AltarHelper.getRandomWeakMob(level, player.getClickedPos());
                    AltarHelper.getRandomWeakMob(level, player.getClickedPos());
                    AltarHelper.getRandomWeakMob(level, player.getClickedPos());
                }

                //item stuff
                stack.setDamageValue(stack.getDamageValue() + 1);

                if (stack.getDamageValue() == stack.getMaxDamage()) {
                    level.playSound((Player) null, player.getPlayer().getX(), player.getPlayer().getY(), player.getPlayer().getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    stack.shrink(1);
                }
            }
        }

        if(level.isClientSide) player.getPlayer().awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        Item item = stack.getItem();
        Level level = player.level;
        Random random = new Random();

        if(item == ModItems.AETHER_WAND.get() || item == ModItems.CURSE_WAND.get() || item == ModItems.HOLY_WAND.get() || item == ModItems.STORM_WAND.get() ||
                item == ModItems.MAELSTROM_WAND.get() || item == ModItems.NETHER_WAND.get() || item == ModItems.THUNDER_WAND.get()) {

            level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            /** AETHER **/
            if (item == ModItems.AETHER_WAND.get()) {
                if (entity instanceof Player) {
                    Player entityIn = (Player) entity;

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
                    Player entityIn = (Player) entity;

                    entityIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                    entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    entityIn.hurt(DamageSource.MAGIC, 4.0F);
                    player.hurt(DamageSource.MAGIC, 1.0F);
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity entityIn = (LivingEntity) entity;
                    entityIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 10000, 0));
                    entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    entityIn.hurt(DamageSource.MAGIC, 4.0F);
                    player.hurt(DamageSource.MAGIC, 1.0F);
                }

            /** HOLY **/
            } else if (item == ModItems.HOLY_WAND.get()) {
                if (entity instanceof Player) {
                    Player entityIn = (Player) entity;

                    entityIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0));
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity entityIn = (LivingEntity) entity;
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
                    Player entityIn = (Player) entity;

                    entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                    entityIn.hurt(DamageSource.MAGIC, 1.0F);
                }
                if (entity instanceof LivingEntity) {
                    LivingEntity entityIn = (LivingEntity) entity;
                    entityIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                    entityIn.hurt(DamageSource.MAGIC, 1.0F);
                }

            /** THUNDER **/
            } else if (item == ModItems.THUNDER_WAND.get()) {
                if(!level.isClientSide) {
                    LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level);
                    lightningbolt.moveTo(entity.getX(), entity.getY(), entity.getZ());
                    level.addFreshEntity(lightningbolt);
                }
            }


            if (item != ModItems.STORM_WAND.get()) player.getCooldowns().addCooldown(this, 150);
            if (level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));
            stack.setDamageValue(stack.getDamageValue() + 1);

            if (stack.getDamageValue() == stack.getMaxDamage()) {
                player.level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                stack.shrink(1);
            }
        }
        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        /** STORM **/  //TODO: rework
        if(stack.getItem() == ModItems.STORM_WAND.get() && stack.isEnchanted() == false) {
            stack.enchant(Enchantments.KNOCKBACK, 5);
        }
    }

    /*      TODO: Buggy, using onEntitySwing meanwhile
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Random random = new Random();
        ItemStack stack = player.getUseItem();

        // AETHER //
        if(stack.getItem() == ModItems.AETHER_WAND.get()) {
            level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.PHANTOM_FLAP, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            player.setDeltaMovement(player.getDeltaMovement().x, 0.5D, player.getDeltaMovement().z);
            player.fallDistance = 0.0F;

            level.addParticle(ParticleTypes.SWEEP_ATTACK, player.position().x, player.position().y + 1, player.position().z, 0.0D, 0.0D, 0.0D);
            if (level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));
            stack.setDamageValue(stack.getDamageValue() + 1);

            if (stack.getDamageValue() == stack.getMaxDamage()) {
                level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                stack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
   **/
    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        Random random = new Random();
        Player player = (Player) entity;
        Level level = entity.level;

        /** AETHER **/
        if(stack.getItem() == ModItems.AETHER_WAND.get()) {
            level.playSound((Player) null, entity.position().x, entity.position().y, entity.position().z, SoundEvents.PHANTOM_FLAP, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            entity.setDeltaMovement(entity.getDeltaMovement().x, 0.5D, entity.getDeltaMovement().z);
            entity.fallDistance = 0.0F;

            level.addParticle(ParticleTypes.SWEEP_ATTACK, entity.position().x, entity.position().y + 1, entity.position().z, 0.0D, 0.0D, 0.0D);

            if (level.isClientSide) {
                player.awardStat(Stats.ITEM_USED.get(this));
                stack.setDamageValue(stack.getDamageValue() + 1);
            }

               if (stack.getDamageValue() == stack.getMaxDamage()) {
                   level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                   stack.shrink(1);
               }

        }

        return true;
    }



    /** CHANGING WAND **/
    private boolean handleInteraction(Player player, BlockState pStateClicked, LevelAccessor pAccessor, BlockPos pPos, boolean pShouldCycleState, ItemStack pDebugStack) {
        if (!player.canUseGameMasterBlocks()) {
            return false;
        } else {
            Block block = pStateClicked.getBlock();
            StateDefinition<Block, BlockState> statedefinition = block.getStateDefinition();
            Collection<Property<?>> collection = statedefinition.getProperties();
            String s = Registry.BLOCK.getKey(block).toString();
            if (collection.isEmpty()) {
                return false;
            } else {
                CompoundTag compoundtag = pDebugStack.getOrCreateTagElement("DebugProperty");
                String s1 = compoundtag.getString(s);
                Property<?> property = statedefinition.getProperty(s1);
                if (pShouldCycleState) {
                    if (property == null) {
                        property = collection.iterator().next();
                    }

                    BlockState blockstate = cycleState(pStateClicked, property, player.isSecondaryUseActive());
                    pAccessor.setBlock(pPos, blockstate, 18);

                    if (player.level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));

                } else {
                    property = getRelative(collection, property, player.isSecondaryUseActive());
                    String s2 = property.getName();
                    compoundtag.putString(s, s2);
                }

                return true;
            }
        }
    }


    private static <T extends Comparable<T>> BlockState cycleState(BlockState pState, Property<T> pProperty, boolean pBackwards) {
        return pState.setValue(pProperty, getRelative(pProperty.getPossibleValues(), pState.getValue(pProperty), pBackwards));
    }


    private static <T> T getRelative(Iterable<T> pAllowedValues, @Nullable T pCurrentValue, boolean pBackwards) {
        return (T)(pBackwards ? Util.findPreviousInIterable(pAllowedValues, pCurrentValue) : Util.findNextInIterable(pAllowedValues, pCurrentValue));
    }


    private static <T extends Comparable<T>> String getNameHelper(BlockState pState, Property<T> pProperty) {
        return pProperty.getName(pState.getValue(pProperty));
    }

}

