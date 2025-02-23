package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AltarHelper {

	public static List<ItemStack> TREASURE_REWARDS = Arrays.asList(
        new ItemStack(Items.DIAMOND),
        new ItemStack(Items.ELYTRA),
        new ItemStack(Items.NETHER_STAR),
        new ItemStack(Items.TOTEM_OF_UNDYING),
        new ItemStack(Items.EXPERIENCE_BOTTLE),
        new ItemStack(Items.END_CRYSTAL),
        new ItemStack(Items.GHAST_TEAR),
        new ItemStack(Items.BLAZE_ROD),
        new ItemStack(Items.DIAMOND_SWORD),
        new ItemStack(Items.DRAGON_BREATH),
        new ItemStack(Items.NETHERITE_SCRAP),
        new ItemStack(Items.ENCHANTED_BOOK),
        new ItemStack(Items.GOLDEN_APPLE),
        new ItemStack(Items.ENDER_EYE),
        new ItemStack(Items.EMERALD),
        new ItemStack(Items.AMETHYST_CLUSTER),
        new ItemStack(Items.HEART_OF_THE_SEA),
        new ItemStack(Items.ENDER_PEARL),
        new ItemStack(Items.PRISMARINE_CRYSTALS),
        new ItemStack(ModItems.SPIRIT_STAR.get()),
        new ItemStack(ModItems.SPIRIT_CRYSTAL.get()),
        new ItemStack(Items.ECHO_SHARD),
        new ItemStack(Items.OMINOUS_TRIAL_KEY),
        new ItemStack(Items.HEAVY_CORE)
	);

	public static final String POTION_KEY = "item." + References.MODID + ".potion";
	public static final String SPLASH_POTION_KEY = "item." + References.MODID + ".splash_potion";
	public static final String LINGERING_POTION_KEY = "item." + References.MODID + ".lingering_potion";

	public static List<ItemStack> POTION_REWARDS = Arrays.asList(
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), new MobEffectInstance(MobEffects.ABSORPTION, 1000, 1)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 2), new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 2)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 2), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 2)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.LEVITATION, 300)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.CONDUIT_POWER, 1000)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1000)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1000)),
		createPotion(Items.POTION, POTION_KEY, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000), new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 1)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.HARM, 1000, 2)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.LEVITATION, 600)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.WITHER, 1000, 2)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.CONFUSION, 1000), new MobEffectInstance(MobEffects.BLINDNESS, 1000), new MobEffectInstance(MobEffects.POISON, 1000)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), new MobEffectInstance(MobEffects.LUCK, 1000, 3)),
		createPotion(Items.SPLASH_POTION, SPLASH_POTION_KEY, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.HARM, 1000, 2)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.LEVITATION, 600)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.WITHER, 1000, 2)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.CONFUSION, 1000), new MobEffectInstance(MobEffects.BLINDNESS, 1000), new MobEffectInstance(MobEffects.POISON, 1000)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), new MobEffectInstance(MobEffects.LUCK, 1000, 3)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000)),
		createPotion(Items.LINGERING_POTION, LINGERING_POTION_KEY, new MobEffectInstance(MobEffects.BLINDNESS, 1000))
	);

	public static List<EntityType<?>> CURSE_REWARDS = List.of(
			EntityType.VINDICATOR,
			EntityType.VEX,
			EntityType.ILLUSIONER,
			EntityType.EVOKER,
			EntityType.WITHER_SKELETON,
			EntityType.STRAY,
			EntityType.RAVAGER,
			EntityType.PHANTOM,
			EntityType.PILLAGER,
			EntityType.HUSK,
			EntityType.GHAST,
			EntityType.WITCH
	);

	public static final List<MobEffectInstance> EFFECT_REWARDS = List.of(
			new MobEffectInstance(MobEffects.REGENERATION, 10000, Config.AREA_SPELL_AMPLIFIER.get()),
			new MobEffectInstance(MobEffects.HEALTH_BOOST, 10000, Config.AREA_SPELL_AMPLIFIER.get()),
			new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10000, Config.AREA_SPELL_AMPLIFIER.get()),
			new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000, Config.AREA_SPELL_AMPLIFIER.get()),
			new MobEffectInstance(MobEffects.LUCK, 10000, Config.AREA_SPELL_AMPLIFIER.get())
	);

	public static final List<EntityType<?>> MONSTER_SPAWNS = List.of(
			EntityType.CAVE_SPIDER,
			EntityType.SKELETON,
			EntityType.CREEPER,
			EntityType.SPIDER,
			EntityType.HUSK,
			EntityType.ZOMBIE
	);


	public static ItemStack getRandomTreasure() {
		Random rand = new Random();
		return TREASURE_REWARDS.get(rand.nextInt(TREASURE_REWARDS.size()));
	}


	public static ItemStack getRandomPotion() {
		Random rand = new Random();
		return POTION_REWARDS.get(rand.nextInt(POTION_REWARDS.size()));
	}


	public static void getRandomSpell(Level level, BlockPos pos) {
		Random rand = new Random();
		SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, 500, 3, EFFECT_REWARDS.get(rand.nextInt(EFFECT_REWARDS.size())), level, pos.getCenter());
	}


	public static void getRandomCurse(Level level, BlockPos pos) {
		Random rand = new Random();
		EntityType<?> randomType = CURSE_REWARDS.get(rand.nextInt(CURSE_REWARDS.size()));

		SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.SMOKE, 500, 3, new MobEffectInstance(MobEffects.UNLUCK, 5000, 0), level, pos.getCenter());
		Mob entity = (Mob) randomType.create(level, EntitySpawnReason.MOB_SUMMONED);

		if (entity != null) {
			entity.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			level.addFreshEntity(entity);
		}
	}


	public static void getRandomWeakMob(Level level, BlockPos pos) {
		Random rand = new Random();
		EntityType<?> randomType = MONSTER_SPAWNS.get(rand.nextInt(MONSTER_SPAWNS.size()));

		SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.SMOKE, 500, 3, new MobEffectInstance(MobEffects.UNLUCK, 5000, 0), level, pos.getCenter());
		Mob entity = (Mob) randomType.create(level, EntitySpawnReason.MOB_SUMMONED);

		if (entity != null) {
			entity.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
			level.addFreshEntity(entity);
		}
	}


	private static ItemStack createPotion(Item item, String nameKey, MobEffectInstance... effects) {
		ItemStack potion = new ItemStack(item);

		potion.set(DataComponents.CUSTOM_NAME, Component.translatable(nameKey));
		PotionContents potionContents = new PotionContents(Potions.WATER);

		for (MobEffectInstance effect : effects) {
			potionContents = potionContents.withEffectAdded(effect);
		}

		potion.set(DataComponents.POTION_CONTENTS, potionContents);
		return potion;
	}


	public static void getRandomBann(Level level, BlockPos pos) {
		Random rand = new Random();
		SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.LARGE_SMOKE, 500, 15, new MobEffectInstance(MobEffects.UNLUCK, 5000, 0), level, pos.getCenter());

		switch (rand.nextInt(7)) {
			case 0:
			case 1:
			case 2:
			case 3:
				WitherBoss wither = new WitherBoss(EntityType.WITHER, level);
				wither.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				level.addFreshEntity(wither);
				break;

			case 4:
				if (Config.CAN_SPAWN_ENDERDRAGON.get()) {
					EnderDragon dragon = new EnderDragon(EntityType.ENDER_DRAGON, level);
					dragon.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
					level.addFreshEntity(dragon);
				} else {
					Warden warden = new Warden(EntityType.WARDEN, level);
					warden.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
					level.addFreshEntity(warden);
				}
				break;

			default:
				Warden warden = new Warden(EntityType.WARDEN, level);
				warden.setPos(pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F);
				level.addFreshEntity(warden);
				break;
		}
	}


	public static void spawnRandomGhosts(Level level, BlockPos pos) {
		Random random = new Random();
		int chance = random.nextInt(100);

		if (chance > 80) {
			Vex vex = new Vex(EntityType.VEX, level);
			vex.setPos(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
			level.addFreshEntity(vex);

		} else if (chance == 1) {
			Allay allay = new Allay(EntityType.ALLAY, level);
			allay.setPos(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
			level.addFreshEntity(allay);
		}
	}

}
