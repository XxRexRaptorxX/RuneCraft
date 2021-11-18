package xxrexraptorxx.runecraft.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.runecraft.main.ModItems;

import java.util.Random;

public class RuneHelper {
	
	public static ItemStack createRune(ItemStack stack, RuneType type) {
		CompoundTag tag = stack.getOrCreateTagElement("Type");

		tag.put(type.getName(), tag);

		stack.setTag(tag);
		return stack;
	}
	
	
	public static String getRegistryNameFromTag(ItemStack stack) {
		if(stack.hasTag()) {
			if(stack.getTag().equals("Type")) {
				return stack.getTag().getString("Type");
			}
		}
		System.err.println("Invalid ItemStack without Runetype tag");
		return "a";
	}

	public static String getRuneName(String runeType) {
		switch (runeType) {
			case "a":
				return "Ayem";

			case "b":
				return "Bedt";

			case "c":
				return "Cess";

			case "d":
				return "Doht";

			case "e":
				return "Ekem";

			case "f":
				return "Hefhed";

			case "g":
				return "Geth";

			case "h":
				return "Hekem";

			case "i":
				return "Iya";

			case "j":
				return "Jeb";

			case "k":
				return "Koht";

			case "l":
				return "Lyr";

			case "m":
				return "Meht";

			case "n":
				return "Neht";

			case "o":
				return "Oht";

			case "p":
				return "Payem";

			case "q":
				return "Quam";

			case "r":
				return "Roht";

			case "s":
				return "Seht";

			case "t":
				return "Tayem";

			case "u":
				return "Yoodt";

			case "v":
				return "Vehk";

			case "w":
				return "Web";

			case "x":
				return "Xayah";

			case "y":
				return "Yahkem";

			case "z":
				return "Zyr";

			default:
				System.err.println("Unknown Rune Type");
				return "Unknown";
		}
	}

	
	public static enum RuneType {
		A("a"),
		B("b"),
		C("c"),
		D("d"),
		E("e"),
		F("f"),
		G("g"),
		H("h"),
		I("i"),
		J("j"),
		K("k"),
		L("l"),
		M("m"),
		N("n"),
		O("o"),
		P("p"),
		Q("q"),
		R("r"),
		S("s"),
		T("t"),
		U("u"),
		V("v"),
		W("w"),
		X("x"),
		Y("y"),
		Z("z"),;


		private String name;
		
		private RuneType(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	
	public static MobEffect getEffect(String type) {
    	switch (type) {
		case "a":
			return MobEffects.MOVEMENT_SPEED;
			
		case "b":
			return MobEffects.JUMP;
			
		case "c":
			return MobEffects.REGENERATION;
			
		case "d":
			return MobEffects.INVISIBILITY;
			
		case "e":
			return MobEffects.WITHER;
		
		case "f":
			return MobEffects.LEVITATION;

		case "g":
			return MobEffects.DAMAGE_BOOST;
			
		case "h":
			return MobEffects.MOVEMENT_SLOWDOWN;
			
		case "i":
			return MobEffects.DIG_SPEED;
			
		case "j":
			return MobEffects.DIG_SLOWDOWN;
			
		case "k":
			return MobEffects.HEAL;
			
		case "l":
			return MobEffects.CONFUSION;
			
		case "m":
			return MobEffects.DAMAGE_RESISTANCE;
			
		case "n":
			return MobEffects.FIRE_RESISTANCE;
			
		case "o":
			return MobEffects.WATER_BREATHING;
			
		case "p":
			return MobEffects.BLINDNESS;
			
		case "q":
			return MobEffects.NIGHT_VISION;
			
		case "r":
			return MobEffects.HUNGER;
			
		case "s":
			return MobEffects.WEAKNESS;
			
		case "t":
			return MobEffects.POISON;
			
		case "u":
			return MobEffects.HEALTH_BOOST;
			
		case "v":
			return MobEffects.SATURATION;
			
		case "w":
			return MobEffects.GLOWING;
			
		case "x":
			return MobEffects.LUCK;
			
		case "y":
			return MobEffects.UNLUCK;
			
		case "z":
			return MobEffects.ABSORPTION;
			
		default:
			System.err.println("Unknown Rune Type");
			return MobEffects.UNLUCK; // :(
			}
		}
	
	
	public static Item getRandomRune() {
		Random rand = new Random();
		
     	switch(rand.nextInt(26)) {
		case 1:
			return ModItems.RUNE_A.get();
		case 2:
			return ModItems.RUNE_B.get();
		case 3:
			return ModItems.RUNE_C.get();
		case 4:
			return ModItems.RUNE_D.get();
		case 5:
			return ModItems.RUNE_E.get();
		case 6:
			return ModItems.RUNE_F.get();
		case 7:
			return ModItems.RUNE_G.get();
		case 8:
			return ModItems.RUNE_H.get();
		case 9:
			return ModItems.RUNE_I.get();
		case 10:
			return ModItems.RUNE_J.get();
		case 11:
			return ModItems.RUNE_K.get();
		case 12:
			return ModItems.RUNE_L.get();
		case 13:
			return ModItems.RUNE_M.get();
		case 14:
			return ModItems.RUNE_N.get();
		case 15:
			return ModItems.RUNE_O.get();
		case 16:
			return ModItems.RUNE_P.get();
		case 17:
			return ModItems.RUNE_Q.get();
		case 18:
			return ModItems.RUNE_R.get();
		case 19:
			return ModItems.RUNE_S.get();
		case 20:
			return ModItems.RUNE_T.get();
		case 21:
			return ModItems.RUNE_U.get();
		case 22:
			return ModItems.RUNE_V.get();
		case 23:
			return ModItems.RUNE_W.get();
		case 24:
			return ModItems.RUNE_X.get();
		case 25:
			return ModItems.RUNE_Y.get();
		default:
			return ModItems.RUNE_Z.get();
		}
	}
}