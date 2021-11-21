package xxrexraptorxx.runecraft.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
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




    /** Altar Functions **/

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        Level world = event.getWorld();
        BlockPos pos = event.getPos();
        Player player = event.getPlayer();

            /** MAGICAL BOOK **/
            if(stack == new ItemStack(Items.BOOK)) {
                if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                    if (player.experienceLevel >= Config.CHARGING_COST.get()) {

                        if (world.getMoonPhase() == 0) {
                            // convert
                            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1f, 1f);

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
                                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.MAGICAL_BOOK.get())); //TODO copy?

                                event.setUseBlock(Event.Result.DENY);
                                event.setUseItem(Event.Result.DENY);
                                event.setCanceled(true);
                            }
                        } else {
                            player.sendMessage(new TranslatableComponent("message.runecraft.not_full_moon", new Object[]{10}), UUID.randomUUID());
                        }
                    } else {
                        player.sendMessage(new TranslatableComponent("message.runecraft.not_enough_levels", new Object[]{10}), UUID.randomUUID());
                    }
                } else {
                    player.sendMessage(new TranslatableComponent("message.runecraft.wrong_block", new Object[]{10}), UUID.randomUUID());
                }

                /** PAGES **/
            } else if(stack.getItem() == ModItems.WAND_PAGE.get() || stack.getItem() == ModItems.ORB_PAGE.get() || stack.getItem() == ModItems.CURSE_PAGE.get() ||
                stack.getItem() == ModItems.LOST_PAGE.get() || stack.getItem() == ModItems.SPELL_PAGE.get()) {

                if (world.getBlockState(pos).getBlock() == ModBlocks.ALTAR_BLOCK.get()) {

                    if (player.experienceLevel >= Config.CHARGING_COST_PAGES.get()) {
                        if (world.isNight()) { //TODO TEST
                            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1f, 1f);

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
                                if (stack.getItem() == ModItems.WAND_PAGE.get()) {
                                    ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.BASIC_WAND.get()));

                                } else if (stack.getItem() == ModItems.ORB_PAGE.get()) {
                                    ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.ORB.get()));

                                } else if (stack.getItem() == ModItems.LOST_PAGE.get()) {
                                    ItemHandlerHelper.giveItemToPlayer(player, AltarHelper.getRandomItem());

                                } else if (stack.getItem() == ModItems.CURSE_PAGE.get()) {
                                    AltarHelper.getRandomCurse(world, pos);

                                } else if (stack.getItem() == ModItems.SPELL_PAGE.get()) {
                                    AltarHelper.getRandomSpell(world, pos);
                                }

                                event.setUseBlock(Event.Result.DENY);
                                event.setUseItem(Event.Result.DENY);
                                event.setCanceled(true);
                            }
                        } else {
                            player.sendMessage(new TranslatableComponent("message.runecraft.not_night", new Object[]{10}), UUID.randomUUID());
                        }
                    } else {
                        player.sendMessage(new TranslatableComponent("message.runecraft.not_enough_levels", new Object[]{10}), UUID.randomUUID());
                    }
                } else {
                    player.sendMessage(new TranslatableComponent("message.runecraft.wrong_block", new Object[]{10}), UUID.randomUUID());
                }
           }
    }


}
