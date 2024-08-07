package xxrexraptorxx.runecraft.world;

import com.mojang.authlib.GameProfile;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
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
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.main.RuneCraft;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.Config;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


@EventBusSubscriber(modid = References.MODID, bus = EventBusSubscriber.Bus.GAME)
public class Events {

    /** Update-Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event) {
        if (Config.UPDATE_CHECKER.get()) {
            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.OUTDATED ||
                        VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.BETA_OUTDATED ) {

                    MutableComponent url = Component.literal(ChatFormatting.GREEN + "Click here to update!");
                    url.withStyle(url.getStyle().withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, References.URL)));

                    Minecraft.getInstance().player.displayClientMessage(Component.literal(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), false);
                    Minecraft.getInstance().player.displayClientMessage(url, false);

                    hasShownUp = true;

                } else if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.FAILED) {
                    RuneCraft.LOGGER.error(References.NAME + "'s version checker failed!");
                    hasShownUp = true;

                }
            }
        }
    }


    /**
     * Distributes the supporter rewards on first join.
     */
    @SubscribeEvent
    public static void SupporterRewards(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (Config.PATREON_REWARDS.get()) {

            try {
                URL SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Supporter");
                URL PREMIUM_SUPPORTER_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Premium%20Supporter");
                URL ELITE_URL = new URL("https://raw.githubusercontent.com/XxRexRaptorxX/Patreons/main/Elite");

                //test if a player already has rewards
                if (!player.getInventory().contains(new ItemStack(Items.PAPER))) {

                    ServerPlayer serverPlayer = (ServerPlayer) player;
                    //test if player joins the first time
                    if (serverPlayer.getStats().getValue(Stats.CUSTOM, Stats.PLAY_TIME) < 5) {

                        //test if player is supporter
                        if (SupporterCheck(SUPPORTER_URL, player)) {

                            ItemStack certificate = new ItemStack(Items.PAPER);
                            certificate.set(DataComponents.CUSTOM_NAME, Component.literal("Thank you for supporting me in my work!").withStyle(ChatFormatting.GOLD).append(Component.literal(" - XxRexRaptorxX").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GREEN)));

                            ItemStack reward = new ItemStack(Items.PLAYER_HEAD);
                            var profile = new GameProfile(player.getUUID(), player.getName().getString());
                            reward.set(DataComponents.PROFILE, new ResolvableProfile(profile));

                            level.playSound((Player) null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.15F + 0.8F);
                            player.addItem(reward);
                            player.addItem(certificate);
                        }

                        //test if player is premium supporter
                        if (SupporterCheck(PREMIUM_SUPPORTER_URL, player)) {
                            ItemStack reward = new ItemStack(Items.DIAMOND_SWORD, 1);
                            Registry<Enchantment> enchantmentsRegistry = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT);

                            reward.enchant(enchantmentsRegistry.getHolderOrThrow(Enchantments.MENDING), 1);
                            reward.enchant(enchantmentsRegistry.getHolderOrThrow(Enchantments.SHARPNESS), 3);
                            reward.set(DataComponents.ENCHANTMENTS, reward.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));

                            reward.set(DataComponents.CUSTOM_NAME, Component.literal("Rex's Night Sword").withStyle(ChatFormatting.DARK_GRAY));

                            player.addItem(reward);
                        }

                        //test if player is elite
                        if (SupporterCheck(ELITE_URL, player)) {
                            ItemStack star = new ItemStack(Items.NETHER_STAR);
                            star.set(DataComponents.CUSTOM_NAME, Component.literal("Elite Star"));

                            player.addItem(star);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Tests if a player is a supporter
     *
     * @param url url to a file that contains the supporter names
     * @param player ingame player
     * @return true/false
     */
    private static boolean SupporterCheck(URL url, Player player) {
        try {
            Scanner scanner = new Scanner(url.openStream());
            List<String> supporterList = scanner.tokens().toList();

            for (String name: supporterList) {
                //test if player is in supporter list
                if (player.getName().getString().equals(name)) {
                    return true;
                }
            }

            scanner.close();

        } catch (MalformedURLException e) {
            RuneCraft.LOGGER.error("Supporter list URL not found! >>" + url);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /** Rune Stone Functions **/

    @SubscribeEvent
    public static void changeRuneStoneType(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Item item = event.getItemStack().getItem();
        BlockPos pos = event.getPos();
        Level world = event.getLevel();
        Block block = world.getBlockState(pos).getBlock();

        if(!world.isClientSide) {
            if (BuiltInRegistries.BLOCK.getKey(block).toString().contains("runecraft:rune_stone")) {
                world.playSound((Player) null, pos, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.8F);

                if(block != ModBlocks.RUNE_STONE.get()) {   //test if a runestone is not empty
                    //Area effect
                    if (Config.ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED.get() && !BuiltInRegistries.ITEM.getKey(item).toString().contains("runecraft:rune_") && block != ModBlocks.RUNE_STONE.get() &&
                            block != ModBlocks.RUNE_STONE_DMG.get() && block != ModBlocks.RUNE_STONE_FRE.get() &&  block != ModBlocks.RUNE_STONE_HRD.get() && block != ModBlocks.RUNE_STONE_PTL.get()) {

                        AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX(), pos.getY() + 0.5F, pos.getZ());
                        cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21)), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
                        cloud.setDuration(Config.AREA_SPELL_DURATION.get());
                        cloud.setRadius(Config.AREA_SPELL_RADIUS.get());
                        //cloud.setFixedColor(0x616161);
                        cloud.setWaitTime(10);
                        cloud.setParticle(ParticleTypes.ENCHANT);
                        world.addFreshEntity(cloud);
                    }
                }

                if (BuiltInRegistries.ITEM.getKey(item).toString().contains("runecraft:rune_")) {
                    //Set the rune
                    if (block == ModBlocks.RUNE_STONE.get()) {                                          //test if the rune stone is already active (& prevents an error)
                        event.getItemStack().shrink(1);                                       // > rune stone is empty
                        world.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);

                    } else {                                                                                                                  // > rune stone is active
                        if (!BuiltInRegistries.BLOCK.getKey(block).toString().substring(21).equals(BuiltInRegistries.ITEM.getKey(item).toString().substring(15))) {      //test that the item and blockstate is NOT the same type
                            ItemEntity drop = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(block).toString().substring(21))));
                            world.addFreshEntity(drop);
                            event.getItemStack().shrink(1);
                            world.setBlock(pos, RuneHelper.getRuneStoneFromType(BuiltInRegistries.ITEM.getKey(item).toString().substring(15)).defaultBlockState(), 2);
                        }
                    }
                }
            }
        }
        //Empty runestone   //TODO: buggy
        //if (block == ModBlocks.RUNE_STONE.get() && !item.getRegistryName().toString().contains("runecraft:rune_")) {
        //    if(world.isClientSide)  player.sendMessage(new TranslatableComponent("message.runecraft.empty_runestone", new Object[]{10}), UUID.randomUUID());
        //}
    }




     /** Altar Functions **/

    @SubscribeEvent
    public static void onInteractWithMagicalBook(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        Random random = new Random();

        /** MAGICAL BOOK **/
        if (item == Items.BOOK) {
            if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= AltarHelper.getPageXpRequirement(item)) {

                    if (world.getMoonPhase() == 0) {
                        //ambient
                        world.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.8F);

                        for (int i = 0; i < 2; i++) {
                            world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
                        }

                        //Spawn a lightning bolt
                        if (!world.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(world);
                            lightningbolt.moveTo(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            world.addFreshEntity(lightningbolt);

                            //Item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.CHARGING_COST.get());

                            ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.MAGICAL_BOOK.get()));
                            world.addFreshEntity(reward);

                            AltarHelper.spawnRandomGhosts(world, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (world.isClientSide)
                            player.displayClientMessage(Component.translatable("message.runecraft.not_full_moon", new Object[]{10}), true);
                    }
                } else {
                    if (world.isClientSide)
                        player.displayClientMessage(Component.translatable("message.runecraft.not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (world.isClientSide)
                    player.displayClientMessage(Component.translatable("message.runecraft.wrong_block", new Object[]{10}), true);
            }

        }
    }


    @SubscribeEvent
    public static void onInteractWithPages (PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        /** PAGES **/
        if (item == ModItems.WAND_PAGE.get() || item == ModItems.ORB_PAGE.get() || item == ModItems.CURSE_PAGE.get() ||
                item == ModItems.LOST_PAGE.get() || item == ModItems.SPELL_PAGE.get() || item == ModItems.ALCHEMY_PAGE.get() ||
                item == ModItems.BANNED_PAGE.get() || item == ModItems.ENCHANTING_PAGE.get()) {

            if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= AltarHelper.getPageXpRequirement(item)) {

                    if (!player.level().isDay()) {

                        //Ambient
                        world.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.8F);

                        for (int i = 0; i < 2; i++) {
                            world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
                        }

                        if (!world.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(world);
                            lightningbolt.moveTo(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            world.addFreshEntity(lightningbolt);

                            //item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, AltarHelper.getPageXpRequirement(item));

                            //rewards
                            if (item == ModItems.WAND_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.BASIC_WAND.get()));
                                world.addFreshEntity(reward);

                            } else if (item == ModItems.ORB_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.ORB.get(), 10));
                                world.addFreshEntity(reward);

                            } else if (item == ModItems.LOST_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, AltarHelper.getRandomTreasure());
                                world.addFreshEntity(reward);

                            } else if (item == ModItems.CURSE_PAGE.get()) {
                                AltarHelper.getRandomCurse(world, pos);

                            } else if (item == ModItems.SPELL_PAGE.get()) {
                                AltarHelper.getRandomSpell(world, pos);

                            } else if (item == ModItems.BANNED_PAGE.get()) {
                                AltarHelper.getRandomBann(world, pos);

                            } else if (item == ModItems.ALCHEMY_PAGE.get()) {
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, AltarHelper.getRandomPotion());
                                world.addFreshEntity(reward);

                            } else if (item == ModItems.ENCHANTING_PAGE.get()) {
                                ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
                                book.set(DataComponents.CUSTOM_NAME, Component.translatable("item.runecraft.enchanting_book"));

                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, book);
                                world.addFreshEntity(reward);
                            }

                            AltarHelper.spawnRandomGhosts(world, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if (world.isClientSide)
                            player.displayClientMessage(Component.translatable("message.runecraft.not_night", new Object[]{10}), true);
                    }
                } else {
                    if (world.isClientSide)
                        player.displayClientMessage(Component.translatable("message.runecraft.not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (world.isClientSide)
                    player.displayClientMessage(Component.translatable("message.runecraft.wrong_block", new Object[]{10}), true);
            }
        }
    }

    //TODO CURSE WAND PARTICLE FIX
    @SubscribeEvent
    public static void onInteractWithWands (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level world = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID) && BuiltInRegistries.ITEM.getKey(item).toString().contains("_wand")) {
            if (Config.WAND_XP_REPAIR.get() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    //Ambient
                    world.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.F);

                    for (int i = 0; i < 2; i++) {
                        world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
                    }

                    //Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (world.isClientSide) player.displayClientMessage(Component.translatable("message.runecraft.not_enough_levels", new Object[]{10}), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithPortableRuneStones (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        Level world = event.getLevel();
        Player player = event.getEntity();
        BlockPos pos = event.getPos();

        if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get() && BuiltInRegistries.ITEM.getKey(item).toString().contains(References.MODID) && BuiltInRegistries.ITEM.getKey(item).toString().contains("portable_rune_stone")) {
            if (Config.PORTABLE_RUNE_STONE_XP_REPAIR.get() && stack.getDamageValue() > 0) {
                if (player.experienceLevel >= 1) {

                    //Ambient
                    world.playSound((Player) null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.8F);

                    for (int i = 0; i < 2; i++) {
                        world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
                    }

                    //Item stuff
                    player.onEnchantmentPerformed(null, 1);

                    if (stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                    } else {
                        stack.setDamageValue(0);
                    }


                } else {
                    if (world.isClientSide) player.displayClientMessage(Component.translatable("message.runecraft.not_enough_levels", new Object[]{10}), true);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onInteractWithSoul (PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        if (stack.getItem() == ModItems.SOUL.get() && stack.has(DataComponents.CUSTOM_DATA)) {

            if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                if (player.experienceLevel >= Config.SOUL_COST.get()) {

                    if (!player.level().isDay()) {

                        //Ambient
                        world.playSound((Player) null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.8F);

                        for (int i = 0; i < 2; i++) {
                            world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
                            world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D);
                        }

                        if (!world.isClientSide) {
                            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(world);
                            lightningbolt.moveTo(pos.getX(), pos.getY(), pos.getZ());
                            lightningbolt.setVisualOnly(true);
                            world.addFreshEntity(lightningbolt);

                            //item stuff
                            event.getItemStack().shrink(1);
                            player.onEnchantmentPerformed(null, Config.SOUL_COST.get());

                            //rewards
                            try {
                                ItemStack egg = new ItemStack(Objects.requireNonNull(SpawnEggItem.byId(EntityType.byString(Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).copyTag().getString("owner")).get())));
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, egg);
                                world.addFreshEntity(reward);

                            } catch (Exception e) {
                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(Items.CHARCOAL));
                                world.addFreshEntity(reward);

                                RuneCraft.LOGGER.error(e);
                                RuneCraft.LOGGER.error("Entity Type: " + stack.get(DataComponents.CUSTOM_DATA).copyTag().getString("owner"));
                            }

                            AltarHelper.spawnRandomGhosts(world, pos);

                            event.setUseBlock(TriState.FALSE);
                            event.setUseItem(TriState.FALSE);
                            event.setCanceled(true);
                        }


                    } else {
                        if(world.isClientSide)
                            player.displayClientMessage(Component.translatable("message.runecraft.not_night", new Object[]{10}), true);
                    }
                } else {
                    if (world.isClientSide)
                        player.displayClientMessage(Component.translatable("message.runecraft.not_enough_levels", new Object[]{10}), true);
                }
            } else {
                if (world.isClientSide)
                    player.displayClientMessage(Component.translatable("message.runecraft.wrong_block", new Object[]{10}), true);
            }
        }
    }


    /** Soul stuff **/

    //public static final DamageSource SOUL_REAPER = new DamageSource(References.MODID + ".soul_reaper"); TODO

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        Entity attacker = event.getSource().getEntity();
        Entity victim = event.getEntity();
        Level world = event.getEntity().level();
        BlockPos pos = event.getEntity().getOnPos();

        //Attacker
        if (attacker instanceof ServerPlayer) {
            if (((ServerPlayer) attacker).getMainHandItem().getItem().equals(ModItems.RITUAL_DAGGER.get())) {

                //TODO: give soul hunter and soul

                //give the player a soul item with the entity name and the entity id as tag
                CompoundTag tag = new CompoundTag();
                ItemStack stack = new ItemStack(ModItems.SOUL.get());

                tag.putString("owner", victim.getType().toString().substring(7).replace(".", ":"));
                stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
                stack.set(DataComponents.CUSTOM_NAME, Component.translatable(victim.getDisplayName().getString()).append(" ").append(Component.translatable("item.runecraft.soul")));

                ((Player) attacker).addItem(stack);

                //Ambient
                world.playSound((Player) null, pos, SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 1.0F);
            }
        }
    }


    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();

       // if (player instanceof ServerPlayer) {
       //     if (player.getLastDamageSource().equals(SOUL_REAPER)) {     //TODO test server side

                //TODO: give soulless
    }


    /** Wandering Trader **/
    @SubscribeEvent
    public static void addTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new BasicItemListing(5, new ItemStack(ModItems.SPIRIT_CRYSTAL.get(), 1), 3, 10));
    }

}
