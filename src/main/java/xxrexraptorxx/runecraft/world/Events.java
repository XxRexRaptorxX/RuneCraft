package xxrexraptorxx.runecraft.world;

import com.mojang.authlib.GameProfile;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
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
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.VersionChecker;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
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

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = References.MODID, bus = EventBusSubscriber.Bus.GAME)
public class Events {

    /** Update Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event) {
        if (Config.UPDATE_CHECKER != null && Config.UPDATE_CHECKER.get()) {

            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                var player = Minecraft.getInstance().player;
                if (player == null) return;

                var modContainer = ModList.get().getModContainerById(References.MODID).orElse(null);

                if (modContainer != null) {
                    var versionCheckResult = VersionChecker.getResult(modContainer.getModInfo());

                    if (versionCheckResult.status() == VersionChecker.Status.OUTDATED || versionCheckResult.status() == VersionChecker.Status.BETA_OUTDATED) {
                        MutableComponent url = Component.literal(ChatFormatting.GREEN + "Click here to update!")
                                .withStyle(style -> style.withClickEvent(new ClickEvent.OpenUrl(URI.create(References.URL))));

                        player.displayClientMessage(Component.literal(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), false);
                        player.displayClientMessage(url, false);

                        hasShownUp = true;

                    } else if (versionCheckResult.status() == VersionChecker.Status.FAILED) {
                        RuneCraft.LOGGER.error(References.NAME + "'s version checker failed!");
                        hasShownUp = true;
                    }
                }
            }
        }
    }


    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    /**
     * Distributes supporter rewards on first login.
     */
    @SubscribeEvent
    public static void SupporterRewards(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (Config.PATREON_REWARDS.get()) {
            // Check if the player already has rewards
            if (!player.getInventory().contains(new ItemStack(Items.PAPER))) {
                if (player instanceof ServerPlayer serverPlayer) { // Ensure the player is a ServerPlayer
                    // Check if the player is logging in for the first time
                    if (serverPlayer.getStats().getValue(Stats.CUSTOM, Stats.PLAY_TIME) < 5) {

                        // Perform supporter checks asynchronously
                        CompletableFuture.runAsync(() -> {
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Supporter"), player)) {
                                giveSupporterReward(player, level);
                            }
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Premium%20Supporter"), player)) {
                                givePremiumSupporterReward(player, level);
                            }
                            if (SupporterCheck(URI.create("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Elite"), player)) {
                                giveEliteReward(player);
                            }
                        });
                    }
                }
            }
        }
    }


    /**
     * Checks if the player is in the supporter list from the given URI.
     *
     * @param uri URI to a file containing supporter names
     * @param player The in-game player
     * @return true if the player is a supporter, otherwise false
     */
    private static boolean SupporterCheck(URI uri, Player player) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse supporter list
            List<String> supporterList = List.of(response.body().split("\\R")); // Split lines
            return supporterList.contains(player.getName().getString());

        } catch (Exception e) {
            RuneCraft.LOGGER.error("Failed to fetch or process supporter list from URI: {}", uri, e);
            return false;
        }
    }


    private static void giveSupporterReward(Player player, Level level) {
        ItemStack certificate = new ItemStack(Items.PAPER);
        certificate.set(DataComponents.CUSTOM_NAME, Component.literal("Thank you for supporting me in my work!").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(" - XxRexRaptorxX").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN)));

        ItemStack reward = new ItemStack(Items.PLAYER_HEAD);
        var profile = new GameProfile(player.getUUID(), player.getName().getString());
        reward.set(DataComponents.PROFILE, new ResolvableProfile(profile));

        level.playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
        player.getInventory().add(reward);
        player.getInventory().add(certificate);
    }


    private static void givePremiumSupporterReward(Player player, Level level) {
        ItemStack reward = new ItemStack(Items.DIAMOND_SWORD, 1);
        Registry<Enchantment> enchantmentsRegistry = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);

        reward.enchant(enchantmentsRegistry.getOrThrow(Enchantments.MENDING), 1);
        reward.enchant(enchantmentsRegistry.getOrThrow(Enchantments.SHARPNESS), 3);
        reward.set(DataComponents.ENCHANTMENTS, reward.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));
        player.getInventory().add(reward);
    }


    private static void giveEliteReward(Player player) {
        ItemStack star = new ItemStack(Items.NETHER_STAR);

        star.set(DataComponents.CUSTOM_NAME, Component.literal("Elite Star"));
        player.getInventory().add(star);
    }


    /** Rune Stone Functions **/

    @SubscribeEvent
    public static void changeRuneStoneType(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        Block block = level.getBlockState(pos).getBlock();

        if(!level.isClientSide) {
            if (BuiltInRegistries.BLOCK.getKey(block).toString().contains(References.MODID + ":rune_stone")) {
                level.playSound((Player) null, pos, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);

                if(block != ModBlocks.RUNE_STONE.get()) {   //test if a runestone is not empty
                    //Area effect
                    if (Config.ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED.get() && !BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID + ":rune_") && block != ModBlocks.RUNE_STONE.get() &&
                            block != ModBlocks.RUNE_STONE_DMG.get() && block != ModBlocks.RUNE_STONE_FRE.get() &&  block != ModBlocks.RUNE_STONE_HRD.get() && block != ModBlocks.RUNE_STONE_PTL.get()) {

                        SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, Config.AREA_SPELL_DURATION.get(), Config.AREA_SPELL_RADIUS.get().floatValue(),
                                new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21)), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()), level, pos.getCenter());
                    }
                }

                if (BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID + ":rune_")) {
                    //Set the rune
                    if (block == ModBlocks.RUNE_STONE.get()) {                                          //test if the rune stone is already active (& prevents an error)
                        event.getItemStack().shrink(1);                                       // > rune stone is empty
                        level.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);

                    } else {                                                                                                                  // > rune stone is active
                        if (!BuiltInRegistries.BLOCK.getKey(block).toString().substring(21).equals(BuiltInRegistries.ITEM.getKey(item).toString().substring(15))) {      //test that the item and blockstate is NOT the same type
                            ItemEntity drop = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21))));
                            level.addFreshEntity(drop);
                            event.getItemStack().shrink(1);
                            level.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        //Empty runestone   //TODO: buggy
        //if (block == ModBlocks.RUNE_STONE.get() && !item.getRegistryName().toString().contains(References.MODID + ":rune_")) {
        //    if(world.isClientSide)  player.sendMessage(new TranslatableComponent("message." + References.MODID + ".empty_runestone", new Object[]{10}), UUID.randomUUID());
        //}
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
                        //ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        //Spawn a lightning bolt
                        if (!level.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setDeltaMovement(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            //Item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.CHARGING_COST.get());

                            ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.MAGICAL_BOOK.get()));
                            level.addFreshEntity(reward);

                            AltarHelper.spawnRandomGhosts(level, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (level.isClientSide)
                            player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_full_moon", new Object[]{10}), true);
                    }
                } else {
                    if (level.isClientSide)
                        player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (level.isClientSide)
                    player.displayClientMessage(Component.translatable("message." + References.MODID + ".wrong_block", new Object[]{10}), true);
            }

        }
    }


    @SubscribeEvent
    public static void onInteractWithPages (PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        /* PAGES */
        if (item == ModItems.WAND_PAGE.get() || item == ModItems.ORB_PAGE.get() || item == ModItems.CURSE_PAGE.get() ||
                item == ModItems.LOST_PAGE.get() || item == ModItems.SPELL_PAGE.get() || item == ModItems.ALCHEMY_PAGE.get() ||
                item == ModItems.BANNED_PAGE.get() || item == ModItems.ENCHANTING_PAGE.get()) {

            if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= ItemPage.getPageXpRequirement(item)) {

                    if (!player.level().isDay()) {

                        //Ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        if (!level.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setDeltaMovement(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            //item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, ItemPage.getPageXpRequirement(item));

                            //rewards
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
                                book.set(DataComponents.CUSTOM_NAME, Component.translatable("item." + References.MODID + ".enchanting_book"));

                                ItemEntity reward = new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, book);
                                level.addFreshEntity(reward);
                            }

                            AltarHelper.spawnRandomGhosts(level, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (level.isClientSide)
                            player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_night", new Object[]{10}), true);
                    }
                } else {
                    if (level.isClientSide)
                        player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (level.isClientSide)
                    player.displayClientMessage(Component.translatable("message." + References.MODID + ".wrong_block", new Object[]{10}), true);
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithWands (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID) && BuiltInRegistries.ITEM.getKey(item).toString().contains("_wand")) {
            if (Config.WAND_XP_REPAIR.get() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    //Ambient
                    level.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.F);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                    //Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (level.isClientSide) player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_enough_levels", new Object[]{10}), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithPortableRuneStones (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level level = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID) && BuiltInRegistries.ITEM.getKey(item).toString().contains("portable_rune_stone")) {
            if (Config.PORTABLE_RUNE_STONE_XP_REPAIR.get() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    //Ambient
                    level.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                    SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                    //Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (level.isClientSide) player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_enough_levels", new Object[]{10}), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithSoul (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        if (stack.getItem() == ModItems.SOUL.get() && stack.has(DataComponents.CUSTOM_DATA)) {

            if (level.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= Config.SOUL_COST.get()) {

                    if (!player.level().isDay()) {

                        //Ambient
                        level.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.ITEM_USED, ParticleTypes.HAPPY_VILLAGER, level, pos);
                        SpellHelper.spawnParticleEffects(ParticleShapeTypes.PENTERGRAM, ParticleTypes.ENCHANT, level, pos);

                        if (!level.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                            lightningbolt.setDeltaMovement(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            level.addFreshEntity(lightningbolt);

                            //item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.SOUL_COST.get());

                            //rewards
                            try {
                                ItemStack egg = new ItemStack(Objects.requireNonNull(SpawnEggItem.byId(EntityType.byString(String.valueOf(Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).copyTag().getString("owner"))).get())));
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
                        if(level.isClientSide)
                            player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_night", new Object[]{10}), true);
                    }
                } else {
                    if (level.isClientSide)
                        player.displayClientMessage(Component.translatable("message." + References.MODID + ".not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (level.isClientSide)
                    player.displayClientMessage(Component.translatable("message." + References.MODID + ".wrong_block", new Object[]{10}), true);
            }
        }
    }


    /** Soul stuff **/

    //public static final DamageSource SOUL_REAPER = new DamageSource(References.MODID + ".soul_reaper"); TODO

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        Entity attacker = event.getSource().getEntity();
        Entity victim = event.getEntity();
        Level level = victim.level();
        Position pos = victim.position();
        BlockPos blockPos = victim.getOnPos();

        //Attacker
        if (attacker instanceof ServerPlayer) {
            if (((ServerPlayer) attacker).getMainHandItem().getItem().equals(ModItems.RITUAL_DAGGER.get())) {

                //TODO: give soul hunter and soulless effect

                //give the player a soul item with the entity name and the entity id as tag
                CompoundTag tag = new CompoundTag();
                ItemStack stack = new ItemStack(ModItems.SOUL.get());

                tag.putString("owner", victim.getType().toString().substring(7).replace(".", ":"));
                stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
                stack.set(DataComponents.CUSTOM_NAME, Component.translatable(victim.getDisplayName().getString()).append(" ").append(Component.translatable("item." + References.MODID + ".soul")));

                ((Player) attacker).addItem(stack);

                //Ambient
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
       //     if (player.getLastDamageSource().equals(SOUL_REAPER)) {     //TODO test server side

                //TODO: give soulless effect
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
            list.add(Component.translatable("message." + References.MODID + ".rune_stone_desc").withStyle(ChatFormatting.GRAY));

        } else if (BuiltInRegistries.BLOCK.getKey(ModBlocks.RUNE_SCRIBER_BLOCK.get()).getPath().equals(BuiltInRegistries.ITEM.getKey(item).getPath())) {
            list.add(Component.literal(ChatFormatting.RED + "Work in progress..."));
        }
    }

}
