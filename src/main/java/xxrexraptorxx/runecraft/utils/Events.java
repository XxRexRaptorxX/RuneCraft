package xxrexraptorxx.runecraft.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
                    System.err.println("Version checker failed!");
                }
            }
        }
    }




    /** Altar Functions **/
/**
    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.RightClickBlock event) {
        //MAGICAL BOOK
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(Items.BOOK))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCost) {

                    if(world.getCurrentMoonPhaseFactor() == 1 && !world.isDaytime()) {
                        // convert
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCost);
                            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.magicalBook).copy());

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_full_moon", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }

        //WAND
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ModItems.wandPage))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCostPages) {

                    if(!world.isDaytime()) {
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCostPages);
                            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.wandBasic).copy());

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_night", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }

        //ORB
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ModItems.orbPage))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCostPages) {

                    if(!world.isDaytime()) {
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCostPages);
                            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.orb).copy());

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_night", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }

        //LOST PAGE
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ModItems.lostPage))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCostPages) {

                    if(!world.isDaytime()) {
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCostPages);
                            ItemHandlerHelper.giveItemToPlayer(player, AltarHelper.getRandomItem().copy());

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_night", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }

        //SPELL
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ModItems.spellPage))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCostPages) {

                    if(!world.isDaytime()) {
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCostPages);
                            AltarHelper.getRandomSpell(world, pos);

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_night", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }


        //CURSE
        if(ItemStack.areItemsEqual(event.getItemStack(), new ItemStack(ModItems.cursePage))) {
            World world = event.getWorld();
            BlockPos pos = event.getPos();

            if(world.getBlockState(pos).getBlock() == ModBlocks.altar) {
                EntityPlayer player = event.getEntityPlayer();

                if(event.getEntityPlayer().experienceLevel >= ConfigGeneral.chargingCostPages) {

                    if(!world.isDaytime()) {
                        player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                        for (int i = 0; i < 2; i++) {
                            world.spawnParticle(EnumParticleTypes.LAVA, 		  pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 1.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() - 0.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() - 0.1F, pos.getY() + 1.3F, pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D, new int[0]);
                            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5F, pos.getY() + 1.3F, pos.getZ() + 1.1F, 0.0D, 0.0D, 0.0D, new int[0]);
                        }
                        EntityLightningBolt entity = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true);
                        world.spawnEntity(entity);

                        if(!event.getWorld().isRemote) {
                            event.getItemStack().shrink(1);
                            player.onEnchant(null, ConfigGeneral.chargingCostPages);
                            AltarHelper.getRandomCurse(world, pos);

                            event.setUseBlock(Result.DENY);
                            event.setUseItem(Result.DENY);
                            event.setCanceled(true);
                        }
                    } else {
                        player.sendStatusMessage(new TextComponentTranslation("message.not_night", new Object[] { 10 }), true);
                    }
                } else {
                    player.sendStatusMessage(new TextComponentTranslation("message.not_enough_levels", new Object[] { 10 }), true);
                }
            } else {
                EntityPlayer player = event.getEntityPlayer();
                player.sendStatusMessage(new TextComponentTranslation("message.wrong_block", new Object[] { 10 }), true);
            }
        }

    }
**/

}
