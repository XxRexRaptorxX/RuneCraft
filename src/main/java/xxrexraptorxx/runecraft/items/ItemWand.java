package xxrexraptorxx.runecraft.items;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.DebugStickState;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ItemWand extends Item {

    public ItemWand(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .stacksTo(1)
                .durability(200)
        );
    }


    @Override
    public InteractionResult useOn(UseOnContext event) {
        Level level = event.getLevel();
        Player player = event.getPlayer();
        Item item = event.getItemInHand().getItem();
        ItemStack stack = event.getItemInHand();
        Position pos = event.getPlayer().position();
        BlockPos clickedPos = event.getClickedPos();
        Random random = new Random();

        //test if used on a alter (to enable xp repair without using the wand effect)
        if (!level.getBlockState(event.getClickedPos()).getBlock().equals(ModBlocks.ALTAR_BLOCK.get())) {

            ArrayList<MobEffectInstance> effectInstances = new ArrayList<>();
            level.playSound((Player) null, pos.x(), pos.y(), pos.z(), SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            if (item != ModItems.CHANGING_WAND.get() || item != ModItems.DESTRUCTION_WAND.get()) {
                player.getCooldowns().addCooldown(stack, Config.WAND_COOLDOWN.get());
            }

            /* BASIC */
            if (item == ModItems.BASIC_WAND.get()) {
                effectInstances.add(new MobEffectInstance(MobEffects.WEAKNESS, 150, 0));
                SpellHelper.spawnSpellEffect(SpellShapes.RING, ParticleTypes.FIREWORK, 20, 3, effectInstances, level, pos);


            /* CURSE */
            } else if (item == ModItems.CURSE_WAND.get()) {
                effectInstances.add(new MobEffectInstance(MobEffects.UNLUCK, 1000, 0));
                effectInstances.add(new MobEffectInstance(MobEffects.HARM, 10, 0));
                SpellHelper.spawnSpellEffect(SpellShapes.RING, ParticleTypes.SMOKE, 20, 3, effectInstances, level, pos);

                effectInstances.removeLast();
                event.getPlayer().hurt(level.damageSources().magic(), 2.0F);
                SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.LARGE_SMOKE, 20, 3, effectInstances, level, pos);

            /* HOLY */
            } else if (item == ModItems.HOLY_WAND.get()) {
                effectInstances.add(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
                SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.HEART, 10, 2, effectInstances, level, pos);

            /* NETHER */
            } else if (item == ModItems.NETHER_WAND.get()) {
                if (level.getBlockState(clickedPos.above()).isAir())
                    level.setBlock(clickedPos.above(), Blocks.FIRE.defaultBlockState(), 11);
                if (level.getBlockState(clickedPos.offset(1, 1, 0)).isAir())
                    level.setBlock(clickedPos.offset(1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                if (level.getBlockState(clickedPos.offset(0, 1, 1)).isAir())
                    level.setBlock(clickedPos.offset(0, 1, 1), Blocks.FIRE.defaultBlockState(), 11);
                if (level.getBlockState(clickedPos.offset(-1, 1, 0)).isAir())
                    level.setBlock(clickedPos.offset(-1, 1, 0), Blocks.FIRE.defaultBlockState(), 11);
                if (level.getBlockState(clickedPos.offset(0, 1, -1)).isAir())
                    level.setBlock(clickedPos.offset(0, 1, -1), Blocks.FIRE.defaultBlockState(), 11);

                SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.LAVA, 100, 1, level, clickedPos.getCenter());

            /* MAELSTROM */
            } else if (item == ModItems.MAELSTROM_WAND.get()) {
                effectInstances.add(new MobEffectInstance(MobEffects.WITHER, 200, 1));
                SpellHelper.spawnSpellEffect(SpellShapes.RING, ParticleTypes.SMOKE, 10, 3, effectInstances, level, pos);
                SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.LAVA, 10, 4, level, pos);

            /* ESCAPE */
            } else if (item == ModItems.ESCAPE_WAND.get()) {
                SpellHelper.spawnSpellEffect(SpellShapes.STACKED, ParticleTypes.LARGE_SMOKE, 500, 15, level, pos);
                event.getPlayer().addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000));
                event.getPlayer().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 1));


            /* DESTRUCTION */
            } else if (item == ModItems.DESTRUCTION_WAND.get()) {
                if (player.isShiftKeyDown())
                    player.getCooldowns().addCooldown(stack, Config.WAND_COOLDOWN.get());

                if (!level.isClientSide) {
                    if (event.getPlayer().isShiftKeyDown()) {
                        level.addFreshEntity(new PrimedTnt(level, clickedPos.getX(), clickedPos.getY(), clickedPos.getZ(), event.getPlayer()));
                    } else {
                        level.destroyBlock(event.getClickedPos(), false);
                    }
                }

            /* THUNDER */
            } else if (item == ModItems.THUNDER_WAND.get()) {

                if (!level.isClientSide) {
                    if (player.isShiftKeyDown()) {
                        level.getLevelData().setRaining(true);
                        level.setThunderLevel(1);
                    } else {
                        level.getLevelData().setRaining(false);
                    }
                }

            /* DEFENSIVE */
            } else if (item == ModItems.DEFENSIVE_WAND.get()) {
                BlockPos blockPos = event.getPlayer().blockPosition();
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0));

                if (player.isShiftKeyDown()) {
                    if (level.getBlockState(blockPos.offset(0, -1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, -1, 0), false);
                    if (level.getBlockState(blockPos.offset(0, 2, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, 2, 0), false);

                    if (level.getBlockState(blockPos.offset(1, 0, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(1, 0, 0), false);
                    if (level.getBlockState(blockPos.offset(-1, 0, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(-1, 0, 0), false);
                    if (level.getBlockState(blockPos.offset(0, 0, 1)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, 0, 1), false);
                    if (level.getBlockState(blockPos.offset(0, 0, -1)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, 0, -1), false);

                    if (level.getBlockState(blockPos.offset(1, 1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(1, 1, 0), false);
                    if (level.getBlockState(blockPos.offset(-1, 1, 0)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(-1, 1, 0), false);
                    if (level.getBlockState(blockPos.offset(0, 1, 1)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, 1, 1), false);
                    if (level.getBlockState(blockPos.offset(0, 1, -1)) == Blocks.COBBLESTONE.defaultBlockState())
                        level.destroyBlock(blockPos.offset(0, 1, -1), false);

                } else {
                    if (level.getBlockState(blockPos.offset(0, -1, 0)).isAir() || level.getBlockState(blockPos.offset(0, -1, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, -1, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, -1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 2, 0)).isAir() || level.getBlockState(blockPos.offset(0, 2, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, 2, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, 2, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);

                    if (level.getBlockState(blockPos.offset(1, 0, 0)).isAir() || level.getBlockState(blockPos.offset(1, 0, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(1, 0, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(1, 0, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(-1, 0, 0)).isAir() || level.getBlockState(blockPos.offset(-1, 0, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(-1, 0, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(-1, 0, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 0, 1)).isAir() || level.getBlockState(blockPos.offset(0, 0, 1)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, 0, 1)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, 0, 1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 0, -1)).isAir() || level.getBlockState(blockPos.offset(0, 0, -1)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, 0, -1)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, 0, -1), Blocks.COBBLESTONE.defaultBlockState(), 11);

                    if (level.getBlockState(blockPos.offset(1, 1, 0)).isAir() || level.getBlockState(blockPos.offset(1, 1, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(1, 1, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(1, 1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(-1, 1, 0)).isAir() || level.getBlockState(blockPos.offset(-1, 1, 0)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(-1, 1, 0)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(-1, 1, 0), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 1, 1)).isAir() || level.getBlockState(blockPos.offset(0, 1, 1)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, 1, 1)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, 1, 1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                    if (level.getBlockState(blockPos.offset(0, 1, -1)).isAir() || level.getBlockState(blockPos.offset(0, 1, -1)).is(BlockTags.REPLACEABLE) || level.getBlockState(blockPos.offset(0, 1, -1)).is(Blocks.SNOW))
                        level.setBlock(blockPos.offset(0, 1, -1), Blocks.COBBLESTONE.defaultBlockState(), 11);
                }

           /* CHANGING */
            } else if (item == ModItems.CHANGING_WAND.get()) {
                if (!level.isClientSide) {
                    if (!this.handleInteraction(player, level.getBlockState(clickedPos), level, clickedPos, true, event.getItemInHand())) {
                        return InteractionResult.FAIL;
                    }
                }

            /* CREATURE */
            } else if (item == ModItems.CREATURE_WAND.get()) {
                AltarHelper.getRandomWeakMob(level, clickedPos);
                AltarHelper.getRandomWeakMob(level, clickedPos);
                AltarHelper.getRandomWeakMob(level, clickedPos);
            }


            //general stuff
            stack.setDamageValue(stack.getDamageValue() + 1);

            if (stack.getDamageValue() == stack.getMaxDamage()) {
                level.playSound((Player) null, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                stack.shrink(1);
            }
        }

        if(level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        Item item = stack.getItem();
        Level level = player.level();
        Random random = new Random();

        level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        /* AETHER */
        if (item == ModItems.AETHER_WAND.get()) {
            SpellHelper.addPlayerEffects(entity, new MobEffectInstance(MobEffects.LEVITATION, 100, 1), 1);

        /* CURSE */
        } else if (item == ModItems.CURSE_WAND.get()) {
            SpellHelper.addPlayerEffects(entity, new MobEffectInstance(MobEffects.UNLUCK, 10000, 0), 2);
            SpellHelper.addPlayerEffects(entity, new MobEffectInstance(MobEffects.WITHER, 100, 0), 2);
            player.hurt(level.damageSources().magic(), 2.0F);

        /* HOLY */
        } else if (item == ModItems.HOLY_WAND.get()) {
            SpellHelper.addPlayerEffects(entity, new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 0);

        /* STORM */
        } else if (item == ModItems.STORM_WAND.get()) {
            SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.SMOKE, 20, 3, level, player.position());
            SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.SMOKE, 20, 3, level, player.position());
            //player.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(20);

        /* NETHER */
        } else if (item == ModItems.NETHER_WAND.get()) {
            entity.setRemainingFireTicks(10);

        /* MAELSTROM */
        } else if (item == ModItems.MAELSTROM_WAND.get()) {
            SpellHelper.addPlayerEffects(entity, new MobEffectInstance(MobEffects.WITHER, 200, 0), 1.0F);

        /* THUNDER */
        } else if (item == ModItems.THUNDER_WAND.get()) {
            if(!level.isClientSide) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                lightningbolt.moveTo(entity.getX(), entity.getY(), entity.getZ());
                level.addFreshEntity(lightningbolt);
            }
        }


        //general stuff
        if (item != ModItems.STORM_WAND.get()) player.getCooldowns().addCooldown(stack, 150);
        if (level.isClientSide) player.awardStat(Stats.ITEM_USED.get(this));

        stack.setDamageValue(stack.getDamageValue() + 1);
        if (stack.getDamageValue() == stack.getMaxDamage()) {
            level.playSound((Player) null, player.position().x, player.position().y, player.position().z, SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            stack.shrink(1);
        }

        return false;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        /* STORM */  //TODO: rework
        if(stack.getItem() == ModItems.STORM_WAND.get() && !stack.isEnchanted()) {
            Registry<Enchantment> enchantmentsRegistry = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

            stack.enchant(enchantmentsRegistry.getOrThrow(Enchantments.KNOCKBACK), 5);
            stack.set(DataComponents.ENCHANTMENTS, stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));
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
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity, InteractionHand hand) {
        Random random = new Random();
        Player player = (Player) entity;
        Level level = entity.level();

        /* AETHER */
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


    /* CHANGING WAND */
    private boolean handleInteraction(Player player, BlockState state, LevelAccessor level, BlockPos pos, boolean p_150807_, ItemStack stack) {
        if (!player.canUseGameMasterBlocks()) {
            return false;

        } else {
            Holder<Block> holder = state.getBlockHolder();
            StateDefinition<Block, BlockState> statedefinition = ((Block)holder.value()).getStateDefinition();
            Collection<Property<?>> collection = statedefinition.getProperties();
            if (collection.isEmpty()) {
                message(player, Component.translatable(this.getDescriptionId() + ".empty", new Object[]{holder.getRegisteredName()}));
                return false;

            } else {
                DebugStickState debugstickstate = (DebugStickState)stack.get(DataComponents.DEBUG_STICK_STATE);
                if (debugstickstate == null) {
                    return false;

                } else {
                    Property<?> property = (Property)debugstickstate.properties().get(holder);
                    if (p_150807_) {
                        if (property == null) {
                            property = (Property)collection.iterator().next();
                        }

                        BlockState blockstate = cycleState(state, property, player.isSecondaryUseActive());
                        level.setBlock(pos, blockstate, 18);
                        if (player.level().isClientSide) player.awardStat(Stats.ITEM_USED.get(this));

                        message(player, Component.translatable(this.getDescriptionId() + ".update", new Object[]{property.getName(), getNameHelper(blockstate, property)}));

                    } else {
                        property = (Property)getRelative(collection, property, player.isSecondaryUseActive());
                        stack.set(DataComponents.DEBUG_STICK_STATE, debugstickstate.withProperty(holder, property));
                        message(player, Component.translatable(this.getDescriptionId() + ".select", new Object[]{property.getName(), getNameHelper(state, property)}));
                    }

                    return true;
                }
            }
        }
    }

    private static void message(Player player, Component component) {
        ((ServerPlayer)player).sendSystemMessage(component, true);
    }


    private static <T extends Comparable<T>> BlockState cycleState(BlockState state, Property<T> property, boolean backwards) {
        return state.setValue(property, getRelative(property.getPossibleValues(), state.getValue(property), backwards));
    }


    private static <T> T getRelative(Iterable<T> allowedValues, @Nullable T currentValue, boolean backwards) {
        return (T)(backwards ? Util.findPreviousInIterable(allowedValues, currentValue) : Util.findNextInIterable(allowedValues, currentValue));
    }


    private static <T extends Comparable<T>> String getNameHelper(BlockState state, Property<T> property) {
        return property.getName(state.getValue(property));
    }

}

