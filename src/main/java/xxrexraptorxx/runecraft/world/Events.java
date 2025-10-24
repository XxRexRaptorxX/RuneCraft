package xxrexraptorxx.runecraft.world;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.TriState;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import xxrexraptorxx.magmacore.utils.FormattingHelper;
import xxrexraptorxx.runecraft.items.ItemPage;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.main.RuneCraft;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

import java.util.List;
import java.util.Objects;
import java.util.Random;


@EventBusSubscriber(modid = References.MODID)
public class Events {

    @SubscribeEvent
    private static void addFeaturePacks(final AddPackFindersEvent event) {
        event.addPackFinders(ResourceLocation.fromNamespaceAndPath(References.MODID, "packs/no_book_on_first_join"), PackType.SERVER_DATA,
                Component.literal("Disable RuneCraft book upon entering the world!"), PackSource.FEATURE, false, Pack.Position.TOP);

    }


    /** Rune Stone Functions **/

    @SubscribeEvent
    public static void changeRuneStoneType(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        Block block = level.getBlockState(pos).getBlock();

        if (!level.isClientSide()) {
            if (BuiltInRegistries.BLOCK.getKey(block).toString().contains(References.MODID + ":rune_stone")) {
                level.playSound((Player) null, pos, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);

                if (block != ModBlocks.RUNE_STONE.get()) { // test if a runestone is not empty
                    // Area effect
                    if (Config.isActivateAreaEffectWhenRightClicked() && !BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID + ":rune_")
                            && block != ModBlocks.RUNE_STONE.get() && block != ModBlocks.RUNE_STONE_DMG.get() && block != ModBlocks.RUNE_STONE_FRE.get()
                            && block != ModBlocks.RUNE_STONE_HRD.get() && block != ModBlocks.RUNE_STONE_PTL.get()) {

                        SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, Config.getAreaSpellDuration(), Config.getAreaSpellRadius(),
                                new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21)), Config.getSpellDuration(),
                                        Config.getSpellAmplifier()),
                                level, pos.getCenter());
                    }
                }

                if (BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID + ":rune_")) {
                    // Set the rune
                    if (block == ModBlocks.RUNE_STONE.get()) { // test if the rune stone is already active (& prevents an error)
                        event.getItemStack().shrink(1); // > rune stone is empty
                        level.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);

                    } else { // > rune stone is active
                        if (!BuiltInRegistries.BLOCK.getKey(block).toString().substring(21).equals(BuiltInRegistries.ITEM.getKey(item).toString().substring(15))) { // test that the
                                                                                                                                                                    // item and
                                                                                                                                                                    // blockstate is
                                                                                                                                                                    // NOT the same
                                                                                                                                                                    // type
                            ItemEntity drop = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D,
                                    new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21))));
                            level.addFreshEntity(drop);
                            event.getItemStack().shrink(1);
                            level.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        // Empty runestone //TODO: buggy
        // if (block == ModBlocks.RUNE_STONE.get() && !item.getRegistryName().toString().contains(References.MODID + ":rune_")) {
        // if(world.isClientSide) player.sendMessage(new TranslatableComponent("message." + References.MODID + ".empty_runestone", new Object[]{10}), UUID.randomUUID());
        // }
    }


    /** Altar Functions **/

    @SubscribeEvent
    public static void onInteractWithMagicalBook(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        Random random = new Random();

        /* MAGICAL BOOK */
        if (item == Items.BOOK) {
            if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= ItemPage.getPageXpRequirement(item)) {

                    if (level.getMoonPhase() == 0) {
                        // ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        // Spawn a lightning bolt
                        if (!level.isClientSide()) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setPos(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            // Item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.getChargingCost());

                            ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.MAGICAL_BOOK.get()));
                            level.addFreshEntity(reward);

                            AltarHelper.spawnRandomGhosts(level, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_full_moon"), true);
                    }
                } else {
                    if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_enough_levels"), true);
                }
            } else {
                if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "wrong_block"), true);
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithPages(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        /* PAGES */
        if (item == ModItems.WAND_PAGE.get() || item == ModItems.ORB_PAGE.get() || item == ModItems.CURSE_PAGE.get() || item == ModItems.LOST_PAGE.get()
                || item == ModItems.SPELL_PAGE.get() || item == ModItems.ALCHEMY_PAGE.get() || item == ModItems.BANNED_PAGE.get() || item == ModItems.ENCHANTING_PAGE.get()) {

            if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {
                if (player.experienceLevel >= ItemPage.getPageXpRequirement(item)) {
                    if (level.getSkyDarken() >= 5 || !level.dimensionType().hasSkyLight()) {

                        // Ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        if (!level.isClientSide()) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setPos(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            // item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, ItemPage.getPageXpRequirement(item));

                            // rewards
                            if (item == ModItems.WAND_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.BASIC_WAND.get()));
                                level.addFreshEntity(reward);

                            } else if (item == ModItems.ORB_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.ORB.get(), 10));
                                level.addFreshEntity(reward);

                            } else if (item == ModItems.LOST_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, AltarHelper.getRandomTreasure());
                                level.addFreshEntity(reward);

                            } else if (item == ModItems.CURSE_PAGE.get()) {
                                AltarHelper.getRandomCurse(level, pos);

                            } else if (item == ModItems.SPELL_PAGE.get()) {
                                AltarHelper.getRandomSpell(level, pos);

                            } else if (item == ModItems.BANNED_PAGE.get()) {
                                AltarHelper.getRandomBann(level, pos);

                            } else if (item == ModItems.ALCHEMY_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, AltarHelper.getRandomPotion());
                                level.addFreshEntity(reward);

                            } else if (item == ModItems.ENCHANTING_PAGE.get()) {
                                ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
                                book.set(DataComponents.CUSTOM_NAME, FormattingHelper.setModLangComponent("item", References.MODID, "enchanting_book"));

                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, book);
                                level.addFreshEntity(reward);
                            }

                            AltarHelper.spawnRandomGhosts(level, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_night"), true);
                    }
                } else {
                    if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_enough_levels"), true);
                }
            } else {
                if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "wrong_block"), true);
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithWands(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID)
                && BuiltInRegistries.ITEM.getKey(item).toString().contains("_wand")) {
            if (Config.getWandXPRepair() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    // Ambient
                    level.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                    // Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_enough_levels"), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithPortableRuneStones(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID)
                && BuiltInRegistries.ITEM.getKey(item).toString().contains("portable_rune_stone")) {
            if (Config.isPortableRuneStoneXpRepair() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    // Ambient
                    level.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                    // Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_enough_levels"), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithSoul(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        if (stack.getItem() == ModItems.SOUL.get() && stack.has(DataComponents.CUSTOM_DATA)) {
            if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {
                if (player.experienceLevel >= Config.getSoulCost()) {
                    if (level.getSkyDarken() >= 5 || !level.dimensionType().hasSkyLight()) {

                        // Ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        if (!level.isClientSide()) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setPos(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            // item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.getSoulCost());

                            // rewards
                            try {
                                ItemStack egg = new ItemStack(Objects.requireNonNull(SpawnEggItem.byId(
                                        EntityType.byString(String.valueOf(Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).copyTag().getString("owner"))).get())));
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, egg);
                                level.addFreshEntity(reward);

                            } catch (Exception e) {
                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(Items.CHARCOAL));
                                level.addFreshEntity(reward);

                                RuneCraft.LOGGER.error(e);
                                RuneCraft.LOGGER.error("Entity Type: " + stack.get(DataComponents.CUSTOM_DATA).copyTag().getString("owner"));
                            }

                            AltarHelper.spawnRandomGhosts(level, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_night"), true);
                    }
                } else {
                    if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "not_enough_levels"), true);
                }
            } else {
                if (level.isClientSide()) player.displayClientMessage(FormattingHelper.setModLangComponent("message", References.MODID, "wrong_block"), true);
            }
        }
    }


    /** Soul stuff **/

    // public static final DamageSource SOUL_REAPER = new DamageSource(References.MODID + ".soul_reaper"); TODO

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        Entity attacker = event.getSource().getEntity();
        Entity victim = event.getEntity();
        Level level = victim.level();
        Position pos = victim.position();
        BlockPos blockPos = victim.getOnPos();

        // Attacker
        if (attacker instanceof ServerPlayer) {
            if (((ServerPlayer) attacker).getMainHandItem().getItem().equals(ModItems.RITUAL_DAGGER.get())) {

                // TODO: give soul hunter and soulless effect

                // give the player a soul item with the entity name and the entity id as tag
                CompoundTag tag = new CompoundTag();
                ItemStack stack = new ItemStack(ModItems.SOUL.get());

                tag.putString("owner", victim.getType().toString().substring(7).replace(".", ":"));
                stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
                stack.set(DataComponents.CUSTOM_NAME,
                        Component.translatable(victim.getDisplayName().getString()).append(" ").append(FormattingHelper.setModLangComponent("item", References.MODID, "soul")));

                ((Player) attacker).addItem(stack);

                // Ambient
                level.playSound((Player) null, blockPos, SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 1.0F);
                level.addParticle(ParticleTypes.SOUL, pos.x(), pos.y() + 0.3F, pos.z(), 0.0D, 0.0D, 0.0D);
                SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, blockPos);
            }
        }
    }


    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();

        // if (player instanceof ServerPlayer) {
        // if (player.getLastDamageSource().equals(SOUL_REAPER)) { //TODO test server side

        // TODO: give soulless effect
    }


    /** Wandering Trader **/
    @SubscribeEvent
    public static void addTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new BasicItemListing(5, new ItemStack(ModItems.SPIRIT_CRYSTAL.get(), 1), 3, 10));
    }


    @SubscribeEvent
    public static void addingToolTips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        List<Component> list = event.getToolTip();

        if (BuiltInRegistries.ITEM.getKey(item).getPath().contains(References.MODID + ":rune_stone_")) {
            list.add(FormattingHelper.setModLangComponent("message", References.MODID, "rune_stone_desc").withStyle(ChatFormatting.GRAY));

        } else if (BuiltInRegistries.BLOCK.getKey(ModBlocks.RUNE_SCRIBER_BLOCK.get()).getPath().equals(BuiltInRegistries.ITEM.getKey(item).getPath())) {
            list.add(Component.literal(ChatFormatting.RED + "Work in progress..."));
        }
    }

}
