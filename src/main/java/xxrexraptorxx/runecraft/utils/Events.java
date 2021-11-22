package xxrexraptorxx.runecraft.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import xxrexraptorxx.runecraft.main.ModBlocks;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

import java.util.Random;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Events {


    /** Update-Checker **/
    private static boolean hasShownUp = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (Config.UPDATE_CHECKER.get()) {
            if (!hasShownUp && Minecraft.getInstance().screen == null) {
                if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.OUTDATED ||
                        VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.BETA_OUTDATED ) {

                    Minecraft.getInstance().player.sendMessage(new TextComponent(ChatFormatting.BLUE + "A newer version of " + ChatFormatting.YELLOW + References.NAME + ChatFormatting.BLUE + " is available!"), UUID.randomUUID());
                    Minecraft.getInstance().player.sendMessage(new TextComponent(ChatFormatting.GRAY + References.URL), UUID.randomUUID());

                    hasShownUp = true;
                } else if (VersionChecker.getResult(ModList.get().getModContainerById(References.MODID).get().getModInfo()).status() == VersionChecker.Status.FAILED) {
                    System.err.println(References.NAME + "'s version checker failed!");
                }
            }
        }
    }


    /** Rune Stone Functions **/

    @SubscribeEvent
    public static void changeRuneStoneType(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();
        Item item = event.getItemStack().getItem();
        BlockPos pos = event.getPos();
        Level world = event.getWorld();
        Block block = world.getBlockState(pos).getBlock();

        if(!world.isClientSide) {
            if (block.getRegistryName().toString().contains("runecraft:rune_stone")) {
                world.playSound((Player) null, pos, SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.F);

                //Area effect
                if (Config.ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED.get() && !item.getRegistryName().toString().contains("runecraft:rune_") && block != ModBlocks.RUNE_STONE.get() &&
                        block != ModBlocks.RUNE_STONE_DMG.get() && block != ModBlocks.RUNE_STONE_FRE.get() &&  block != ModBlocks.RUNE_STONE_HRD.get() && block != ModBlocks.RUNE_STONE_PTL.get()) {

                    AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX(), pos.getY() + 0.5F, pos.getZ());
                    cloud.addEffect(new MobEffectInstance(RuneHelper.getEffect(block.getRegistryName().toString().substring(21)), Config.SPELL_DURATION.get(), Config.SPELL_AMPLIFIER.get()));
                    cloud.setDuration(Config.AREA_SPELL_DURATION.get());
                    cloud.setRadius(Config.AREA_SPELL_RADIUS.get());
                    cloud.setFixedColor(0x616161);
                    cloud.setWaitTime(10);
                    cloud.setParticle(ParticleTypes.ENCHANT);
                    world.addFreshEntity(cloud);
                }

                if (item.getRegistryName().toString().contains("runecraft:rune_")) {

                    //Set the rune
                    if (block == ModBlocks.RUNE_STONE.get()) {                                          //test if the rune stone is already active (& prevents an error)
                        event.getItemStack().shrink(1);                                       // > rune stone is empty
                        world.setBlock(pos, RuneHelper.getRuneStoneFromType(item.getRegistryName().toString().substring(15)).defaultBlockState(), 2);

                    } else {                                                                                                                  // > rune stone is active
                        if (!block.getRegistryName().toString().substring(21).equals(item.getRegistryName().toString().substring(15))) {      //test that the item and blockstate is NOT the same type
                            ItemEntity drop = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRuneFromType(block.getRegistryName().toString().substring(21))));
                            world.addFreshEntity(drop);
                            event.getItemStack().shrink(1);
                            world.setBlock(pos, RuneHelper.getRuneStoneFromType(item.getRegistryName().toString().substring(15)).defaultBlockState(), 2);
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
    public static void onInteract(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level world = event.getWorld();
        BlockPos pos = event.getPos();
        Player player = event.getPlayer();
        Random random = new Random();

        /** MAGICAL BOOK **/
            if(item == Items.BOOK) {
                if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                    if (player.experienceLevel >= Config.CHARGING_COST.get()) {

                        if (world.getMoonPhase() == 0) {
                            // convert
                            world.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.F);

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

                                event.getItemStack().shrink(1);
                                player.onEnchantmentPerformed(null, Config.CHARGING_COST.get());

                                ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.MAGICAL_BOOK.get()));
                                world.addFreshEntity(reward);

                                if(random.nextInt(3) == 1) {
                                    Vex vex = new Vex(EntityType.VEX, world);
                                    vex.setPos(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
                                    world.addFreshEntity(vex);

                                    event.setUseBlock(Event.Result.DENY);
                                    event.setUseItem(Event.Result.DENY);
                                    event.setCanceled(true);
                                }

                                event.setUseBlock(Event.Result.DENY);
                                event.setUseItem(Event.Result.DENY);
                                event.setCanceled(true);
                            }
                        } else {
                            if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.not_full_moon", new Object[]{10}), UUID.randomUUID());
                        }
                    } else {
                        if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.not_enough_levels", new Object[]{10}), UUID.randomUUID());
                    }
                } else {
                    if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.wrong_block", new Object[]{10}), UUID.randomUUID());
                }

                /** PAGES **/
            } else if(item == ModItems.WAND_PAGE.get() || item == ModItems.ORB_PAGE.get() || item == ModItems.CURSE_PAGE.get() ||
                    item == ModItems.LOST_PAGE.get() || item == ModItems.SPELL_PAGE.get()) {

                if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                    if (player.experienceLevel >= Config.CHARGING_COST_PAGES.get()) {
                        if (player.level.isDay() == false) {
                            world.playSound((Player)null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 0.5F, world.random.nextFloat() * 0.15F + 0.F);

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

                                event.getItemStack().shrink(1);
                                player.onEnchantmentPerformed(null, Config.CHARGING_COST_PAGES.get());

                                //reward
                                if (item == ModItems.WAND_PAGE.get()) {
                                    ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.BASIC_WAND.get()));
                                    world.addFreshEntity(reward);

                                } else if (item == ModItems.ORB_PAGE.get()) {
                                    ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, new ItemStack(ModItems.ORB.get()));
                                    world.addFreshEntity(reward);

                                } else if (item == ModItems.LOST_PAGE.get()) {
                                    ItemEntity reward = new ItemEntity(world, pos.getX() + 0.5F, pos.getY() + 1.1F, pos.getZ() + 0.5F, AltarHelper.getRandomTreasure());
                                    world.addFreshEntity(reward);

                                } else if (item == ModItems.CURSE_PAGE.get()) {
                                    AltarHelper.getRandomCurse(world, pos);

                                } else if (item == ModItems.SPELL_PAGE.get()) {
                                    AltarHelper.getRandomSpell(world, pos);
                                }

                                if(random.nextInt(3) == 1) {
                                    Vex vex = new Vex(EntityType.VEX, world);
                                    vex.setPos(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
                                    world.addFreshEntity(vex);

                                    event.setUseBlock(Event.Result.DENY);
                                    event.setUseItem(Event.Result.DENY);
                                    event.setCanceled(true);
                                }
                            }
                        } else { //TODO BUGGY makes no sense!
                            //if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.not_night", new Object[]{10}), UUID.randomUUID());
                        }
                    } else {
                        if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.not_enough_levels", new Object[]{10}), UUID.randomUUID());
                    }
                } else {
                    if(world.isClientSide) player.sendMessage(new TranslatableComponent("message.runecraft.wrong_block", new Object[]{10}), UUID.randomUUID());
                }
           }
    }


}
