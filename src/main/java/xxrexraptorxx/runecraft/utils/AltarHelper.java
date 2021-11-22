package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.main.ModItems;

import java.util.Random;

public class AltarHelper {
	
	public static ItemStack getRandomTreasure() {
		Random rand = new Random();
		
		switch (rand.nextInt(16)) {
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
		default:
			return new ItemStack(Items.COAL, 5);
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
			Ravager ravanger = new Ravager(EntityType.RAVAGER, world);
			ravanger.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			world.addFreshEntity(cloud);
			world.addFreshEntity(ravanger);
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

}
