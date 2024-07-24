package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xxrexraptorxx.runecraft.main.RuneCraft;
import xxrexraptorxx.runecraft.registry.ModBlocks;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.Random;

public class RuneHelper {

	public static Item getRuneFromType(String type) {
		switch(type) {
			case "a":
				return ModItems.RUNE_A.get();
			case "b":
				return ModItems.RUNE_B.get();
			case "c":
				return ModItems.RUNE_C.get();
			case "d":
				return ModItems.RUNE_D.get();
			case "e":
				return ModItems.RUNE_E.get();
			case "f":
				return ModItems.RUNE_F.get();
			case "g":
				return ModItems.RUNE_G.get();
			case "h":
				return ModItems.RUNE_H.get();
			case "i":
				return ModItems.RUNE_I.get();
			case "j":
				return ModItems.RUNE_J.get();
			case "k":
				return ModItems.RUNE_K.get();
			case "l":
				return ModItems.RUNE_L.get();
			case "m":
				return ModItems.RUNE_M.get();
			case "n":
				return ModItems.RUNE_N.get();
			case "o":
				return ModItems.RUNE_O.get();
			case "p":
				return ModItems.RUNE_P.get();
			case "q":
				return ModItems.RUNE_Q.get();
			case "r":
				return ModItems.RUNE_R.get();
			case "s":
				return ModItems.RUNE_S.get();
			case "t":
				return ModItems.RUNE_T.get();
			case "u":
				return ModItems.RUNE_U.get();
			case "v":
				return ModItems.RUNE_V.get();
			case "w":
				return ModItems.RUNE_W.get();
			case "x":
				return ModItems.RUNE_X.get();
			case "y":
				return ModItems.RUNE_Y.get();
			case "z":
				return ModItems.RUNE_Z.get();
			case "dmg":
				return ModItems.RUNE_DMG.get();
			case "fre":
				return ModItems.RUNE_FRE.get();
			case "hrd":
				return ModItems.RUNE_HRD.get();
			case "ptl":
				return ModItems.RUNE_PTL.get();
			default:
				RuneCraft.LOGGER.error("Unknown rune type. [getRuneFromType]");
				return ModItems.RUNE_A.get();
		}
	}


	public static Block getRuneStoneFromType(String type) {
		switch(type) {
			case "a":
				return ModBlocks.RUNE_STONE_A.get();
			case "b":
				return ModBlocks.RUNE_STONE_B.get();
			case "c":
				return ModBlocks.RUNE_STONE_C.get();
			case "d":
				return ModBlocks.RUNE_STONE_D.get();
			case "e":
				return ModBlocks.RUNE_STONE_E.get();
			case "f":
				return ModBlocks.RUNE_STONE_F.get();
			case "g":
				return ModBlocks.RUNE_STONE_G.get();
			case "h":
				return ModBlocks.RUNE_STONE_H.get();
			case "i":
				return ModBlocks.RUNE_STONE_I.get();
			case "j":
				return ModBlocks.RUNE_STONE_J.get();
			case "k":
				return ModBlocks.RUNE_STONE_K.get();
			case "l":
				return ModBlocks.RUNE_STONE_L.get();
			case "m":
				return ModBlocks.RUNE_STONE_M.get();
			case "n":
				return ModBlocks.RUNE_STONE_N.get();
			case "o":
				return ModBlocks.RUNE_STONE_O.get();
			case "p":
				return ModBlocks.RUNE_STONE_P.get();
			case "q":
				return ModBlocks.RUNE_STONE_Q.get();
			case "r":
				return ModBlocks.RUNE_STONE_R.get();
			case "s":
				return ModBlocks.RUNE_STONE_S.get();
			case "t":
				return ModBlocks.RUNE_STONE_T.get();
			case "u":
				return ModBlocks.RUNE_STONE_U.get();
			case "v":
				return ModBlocks.RUNE_STONE_V.get();
			case "w":
				return ModBlocks.RUNE_STONE_W.get();
			case "x":
				return ModBlocks.RUNE_STONE_X.get();
			case "y":
				return ModBlocks.RUNE_STONE_Y.get();
			case "z":
				return ModBlocks.RUNE_STONE_Z.get();
			case "dmg":
				return ModBlocks.RUNE_STONE_DMG.get();
			case "fre":
				return ModBlocks.RUNE_STONE_FRE.get();
			case "hrd":
				return ModBlocks.RUNE_STONE_HRD.get();
			case "ptl":
				return ModBlocks.RUNE_STONE_PTL.get();
			default:
				RuneCraft.LOGGER.error("Unknown rune type. [getRuneStoneFromType]");
				return ModBlocks.RUNE_STONE.get();
		}
	}


	public static Block getRuneBlockFromType(String type) {
		switch (type) {
			case "a":
				return ModBlocks.RUNE_BLOCK_A.get();
			case "b":
				return ModBlocks.RUNE_BLOCK_B.get();
			case "c":
				return ModBlocks.RUNE_BLOCK_C.get();
			case "d":
				return ModBlocks.RUNE_BLOCK_D.get();
			case "e":
				return ModBlocks.RUNE_BLOCK_E.get();
			case "f":
				return ModBlocks.RUNE_BLOCK_F.get();
			case "g":
				return ModBlocks.RUNE_BLOCK_G.get();
			case "h":
				return ModBlocks.RUNE_BLOCK_H.get();
			case "i":
				return ModBlocks.RUNE_BLOCK_I.get();
			case "j":
				return ModBlocks.RUNE_BLOCK_J.get();
			case "k":
				return ModBlocks.RUNE_BLOCK_K.get();
			case "l":
				return ModBlocks.RUNE_BLOCK_L.get();
			case "m":
				return ModBlocks.RUNE_BLOCK_M.get();
			case "n":
				return ModBlocks.RUNE_BLOCK_N.get();
			case "o":
				return ModBlocks.RUNE_BLOCK_O.get();
			case "p":
				return ModBlocks.RUNE_BLOCK_P.get();
			case "q":
				return ModBlocks.RUNE_BLOCK_Q.get();
			case "r":
				return ModBlocks.RUNE_BLOCK_R.get();
			case "s":
				return ModBlocks.RUNE_BLOCK_S.get();
			case "t":
				return ModBlocks.RUNE_BLOCK_T.get();
			case "u":
				return ModBlocks.RUNE_BLOCK_U.get();
			case "v":
				return ModBlocks.RUNE_BLOCK_V.get();
			case "w":
				return ModBlocks.RUNE_BLOCK_W.get();
			case "x":
				return ModBlocks.RUNE_BLOCK_X.get();
			case "y":
				return ModBlocks.RUNE_BLOCK_Y.get();
			case "z":
				return ModBlocks.RUNE_BLOCK_Z.get();
			case "dmg":
				return ModBlocks.RUNE_BLOCK_DMG.get();
			case "fre":
				return ModBlocks.RUNE_BLOCK_FRE.get();
			case "hrd":
				return ModBlocks.RUNE_BLOCK_HRD.get();
			case "ptl":
				return ModBlocks.RUNE_BLOCK_PTL.get();
			default:
				RuneCraft.LOGGER.error("Unknown rune type. [getRuneBlockFromType]");
				return ModBlocks.RUNE_BLOCK_A.get();
		}
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

			case "dmg":
				return "Dama";
			case "fre":
				return "Fre";
			case "hrd":
				return "Har";
			case "ptl":
				return "Pot";
			case "ghs":
				return "Ghos";

			default:
				RuneCraft.LOGGER.error("Unknown Rune Type. [getRuneName]");
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
	
	
	public static Holder<MobEffect> getEffect(String type) {
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
			RuneCraft.LOGGER.error("Unknown Rune Type. [getEffect]");
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