package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.main.ModItems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class AltarHelper {
	
	public static ItemStack getRandomTreasure() {
		Random rand = new Random();
		
		switch (rand.nextInt(19)) {
		case 0:
			return new ItemStack(Items.DIAMOND);
		case 1:
			return new ItemStack(Items.ELYTRA);
		case 2:
			return new ItemStack(ModItems.SPIRIT_STAR.get());
		case 3:
			return new ItemStack(Items.NETHER_STAR);
		case 4:
			return new ItemStack(Items.TOTEM_OF_UNDYING);
		case 5:
			return new ItemStack(Items.EXPERIENCE_BOTTLE);
		case 6:
			return new ItemStack(Items.END_CRYSTAL);
		case 7:
			return new ItemStack(Items.GHAST_TEAR);
		case 8:
			return new ItemStack(Items.BLAZE_ROD);
		case 9:
			return new ItemStack(Items.DIAMOND_SWORD);
		case 10:
			return new ItemStack(ModItems.SPIRIT_CRYSTAL.get());
		case 11:
			return new ItemStack(Items.DRAGON_BREATH);
		case 12:
			return new ItemStack(Items.BUNDLE);
		case 13:
			return new ItemStack(Items.HEART_OF_THE_SEA);
		case 14:
			return new ItemStack(Items.EMERALD);
		case 15:
			return new ItemStack(Items.AMETHYST_CLUSTER);
		case 16:
			return new ItemStack(Items.ENDER_PEARL);
		case 17:
			return new ItemStack(Items.PRISMARINE_CRYSTALS);
		default:
			return new ItemStack(Items.ENDER_EYE);
		}
	}


	public static ItemStack getRandomPotion() {
		Random rand = new Random();
		ItemStack potion = new ItemStack (Items.POTION).setHoverName(new TranslatableComponent("item.runecraft.potion"));
		ItemStack splash_potion = new ItemStack (Items.SPLASH_POTION).setHoverName(new TranslatableComponent("item.runecraft.splash_potion"));
		ItemStack lingering_potion = new ItemStack (Items.LINGERING_POTION).setHoverName(new TranslatableComponent("item.runecraft.lingering_potion"));
		ArrayList<MobEffectInstance> effects = new ArrayList<MobEffectInstance>();


		switch (rand.nextInt(25)) {
			case 0:
				effects.add(new MobEffectInstance(MobEffects.REGENERATION, 1000, 1));
				effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 1000, 1));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 1:
				effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 2));
				effects.add(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 2));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 2:
				effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 2));
				effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 2));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 3:
				effects.add(new MobEffectInstance(MobEffects.LEVITATION, 300));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 4:
				effects.add(new MobEffectInstance(MobEffects.CONDUIT_POWER, 1000));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 5:
				effects.add(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1000));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 6:
				effects.add(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1000));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 7:
				effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000));
				effects.add(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000));
				effects.add(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 1));
				PotionUtils.setCustomEffects(potion, effects);
				return potion;
			case 8:
				effects.add(new MobEffectInstance(MobEffects.HARM, 1000, 2));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 9:
				effects.add(new MobEffectInstance(MobEffects.LEVITATION, 600));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 10:
				effects.add(new MobEffectInstance(MobEffects.WITHER, 1000, 2));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 11:
				effects.add(new MobEffectInstance(MobEffects.CONFUSION, 1000));
				effects.add(new MobEffectInstance(MobEffects.BLINDNESS, 1000));
				effects.add(new MobEffectInstance(MobEffects.POISON, 1000));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 12:
				effects.add(new MobEffectInstance(MobEffects.REGENERATION, 1000, 1));
				effects.add(new MobEffectInstance(MobEffects.LUCK, 1000, 3));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 13:
				effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000));
				PotionUtils.setCustomEffects(splash_potion, effects);
				return splash_potion;
			case 14:
				effects.add(new MobEffectInstance(MobEffects.HARM, 1000, 2));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 15:
				effects.add(new MobEffectInstance(MobEffects.LEVITATION, 600));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 16:
				effects.add(new MobEffectInstance(MobEffects.WITHER, 1000, 2));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 17:
				effects.add(new MobEffectInstance(MobEffects.CONFUSION, 1000));
				effects.add(new MobEffectInstance(MobEffects.BLINDNESS, 1000));
				effects.add(new MobEffectInstance(MobEffects.POISON, 1000));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 18:
				effects.add(new MobEffectInstance(MobEffects.REGENERATION, 1000, 1));
				effects.add(new MobEffectInstance(MobEffects.LUCK, 1000, 3));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 19:
				effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			case 20:
				effects.add(new MobEffectInstance(MobEffects.BLINDNESS, 1000));
				PotionUtils.setCustomEffects(lingering_potion, effects);
				return lingering_potion;
			default:
				PotionUtils.setPotion(potion, Potions.AWKWARD);
				return potion;
		}
	}
	
	
	public static void getRandomSpell(Level world, BlockPos pos) {
		Random rand = new Random();
		
    	AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX() + 0.5F , pos.getY() + 0.5F, pos.getZ() + 0.5F);
    	cloud.setDuration(500);
    	cloud.setRadius(3);
    	cloud.setFixedColor(0x616161);
    	cloud.setWaitTime(10);
    	cloud.setParticle(ParticleTypes.ENCHANT);
		
		switch (rand.nextInt(5)) {
		case 0:
	    	cloud.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 10000, Config.AREA_SPELL_AMPLIFIER.get()));
	    	world.addFreshEntity(cloud);
			break;

		case 1:
	    	cloud.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 10000, Config.AREA_SPELL_AMPLIFIER.get()));
	    	world.addFreshEntity(cloud);
	    	break;
	    	
		case 2:
	    	cloud.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10000, Config.AREA_SPELL_AMPLIFIER.get()));
	    	world.addFreshEntity(cloud);
	    	break;
	    	
		case 3:
	    	cloud.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000, Config.AREA_SPELL_AMPLIFIER.get()));
	    	world.addFreshEntity(cloud);
	    	break;
	    	
		default:
	    	cloud.addEffect(new MobEffectInstance(MobEffects.LUCK, 10000, Config.AREA_SPELL_AMPLIFIER.get()));
	    	world.addFreshEntity(cloud);
			break;
		}
	}
	
	
	
	public static void getRandomCurse(Level world, BlockPos pos) {
		Random rand = new Random();
		
    	AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
    	cloud.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 5000, 0));
    	cloud.setParticle(ParticleTypes.SMOKE);
    	cloud.setDuration(500);
    	cloud.setRadius(3);
    	cloud.setWaitTime(10);
		
		switch (rand.nextInt(11)) {
		case 0:
	    	Vindicator vindicator = new Vindicator(EntityType.VINDICATOR, world);
	    	vindicator.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(vindicator);
	    	break;
		
		case 1:
	    	Vex vex = new Vex(EntityType.VEX, world);
	    	vex.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(vex);
	    	break;
	    	
		case 2:
	    	Illusioner illusioner = new Illusioner(EntityType.ILLUSIONER, world);
	    	illusioner.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(illusioner);
	    	break;
	    	
		case 3:
	    	Evoker evoker = new Evoker(EntityType.EVOKER, world);
	    	evoker.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(evoker);
	    	break;
	    	
		case 4:
	    	WitherSkeleton wither = new WitherSkeleton(EntityType.WITHER_SKELETON, world);
	    	wither.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(wither);
	    	break;
	    	
		case 5:
	    	Stray stray = new Stray(EntityType.STRAY, world);
	    	stray.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(stray);
	    	break;

		case 6:
			Ravager ravager = new Ravager(EntityType.RAVAGER, world);
			ravager.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			world.addFreshEntity(cloud);
			world.addFreshEntity(ravager);
			break;

		case 7:
			Phantom phantom = new Phantom(EntityType.PHANTOM, world);
			phantom.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			world.addFreshEntity(cloud);
			world.addFreshEntity(phantom);
			break;

		case 8:
			Pillager pillager = new Pillager(EntityType.PILLAGER, world);
			pillager.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			world.addFreshEntity(cloud);
			world.addFreshEntity(pillager);
			break;

		case 9:
			Husk husk = new Husk(EntityType.HUSK, world);
			husk.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			world.addFreshEntity(cloud);
			world.addFreshEntity(husk);
			break;
	    	
		default:
	    	Witch witch = new Witch(EntityType.WITCH, world);
	    	witch.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
	    	world.addFreshEntity(cloud);
	    	world.addFreshEntity(witch);
			break;
		}
	}


	public static void getRandomBann(Level world, BlockPos pos) {
		Random rand = new Random();

		AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
		cloud.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 5000, 0));
		cloud.setParticle(ParticleTypes.LARGE_SMOKE);
		cloud.setDuration(500);
		cloud.setRadius(15);
		cloud.setWaitTime(10);

		switch (rand.nextInt(7)) {
			case 0:
			case 1:
			case 2:
			case 3:
				WitherBoss wither = new WitherBoss(EntityType.WITHER, world);
				wither.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(wither);
				break;

			case 4:
				if(Config.CAN_SPAWN_ENDERDRAGON.get()) {
					EnderDragon dragon = new EnderDragon(EntityType.ENDER_DRAGON, world);
					dragon.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
					world.addFreshEntity(cloud);
					world.addFreshEntity(dragon);
				} else {
					Ghast ghast = new Ghast(EntityType.GHAST, world);
					ghast.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
					world.addFreshEntity(cloud);
					world.addFreshEntity(ghast);
				}
				break;

			default:
				Ghast ghast = new Ghast(EntityType.GHAST, world);
				ghast.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(ghast);
				break;
		}
	}



	public static void getRandomWeakMob(Level world, BlockPos pos) {
		Random rand = new Random();

		AreaEffectCloud cloud = new AreaEffectCloud(world, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
		cloud.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 5000, 0));
		cloud.setParticle(ParticleTypes.SMOKE);
		cloud.setDuration(500);
		cloud.setRadius(3);
		cloud.setWaitTime(10);

		switch (rand.nextInt(8)) {
			case 0:
				CaveSpider caveSpider = new CaveSpider(EntityType.CAVE_SPIDER, world);
				caveSpider.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(caveSpider);
				break;

			case 1:
				Skeleton skeleton = new Skeleton(EntityType.SKELETON, world);
				skeleton.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(skeleton);
				break;

			case 2:
				Creeper creeper = new Creeper(EntityType.CREEPER, world);
				creeper.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(creeper);
				break;

			case 3:
				Spider spider = new Spider(EntityType.SPIDER, world);
				spider.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(spider);
				break;

			case 4:
				Husk husk = new Husk(EntityType.HUSK, world);
				husk.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(husk);
				break;

			default:
				Zombie zombie = new Zombie(EntityType.ZOMBIE, world);
				zombie.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				world.addFreshEntity(cloud);
				world.addFreshEntity(zombie);
				break;
		}
	}

}
