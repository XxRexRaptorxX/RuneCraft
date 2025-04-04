package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import xxrexraptorxx.runecraft.main.References;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_RUNESTONES = "runestones";
    public static final String CATEGORY_PORTABLE_RUNESTONES = "portable_runestones";
    public static final String CATEGORY_PAGES = "pages";
    public static final String CATEGORY_ALTAR = "altar";
    public static final String CATEGORY_WANDS = "wands";
    public static final String CATEGORY_WORLD = "world";

    public static ModConfigSpec SERVER_CONFIG;
    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec COMMON_CONFIG;

    public static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ModConfigSpec.BooleanValue PATREON_REWARDS;

    public static ModConfigSpec.BooleanValue ACTIVATE_VISIBLE_RUNE_TYPE;
    public static ModConfigSpec.BooleanValue ACTIVATE_RUNESTONE_DESCRIPTION;
    public static ModConfigSpec.BooleanValue ACTIVATE_RUNESTONE_JEI_DESCRIPTION;
    public static ModConfigSpec.IntValue CHARGING_COST;
    public static ModConfigSpec.BooleanValue CAN_SPAWN_ENDERDRAGON;

    public static ModConfigSpec.BooleanValue ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT;
    //public static ModConfigSpec.IntValue PORTABLE_RUNE_STONE_DURABILITY;                            deprecated
    public static ModConfigSpec.IntValue PORTABLE_SPELL_DURATION;
    public static ModConfigSpec.IntValue PORTABLE_SPELL_RADIUS;
    public static ModConfigSpec.IntValue PORTABLE_SPELL_AMPLIFIER;
    public static ModConfigSpec.IntValue PORTABLE_SPELL_COOLDOWN;
    public static ModConfigSpec.IntValue WAND_COOLDOWN;
    public static ModConfigSpec.BooleanValue PORTABLE_RUNE_STONE_XP_REPAIR;
    public static ModConfigSpec.BooleanValue WAND_XP_REPAIR;


    public static ModConfigSpec.BooleanValue ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED;
    public static ModConfigSpec.BooleanValue ACTIVATE_REDSTONE_EFFECT;
    public static ModConfigSpec.IntValue SPELL_DURATION;
    public static ModConfigSpec.IntValue SPELL_AMPLIFIER;
    public static ModConfigSpec.IntValue AREA_SPELL_DURATION;
    public static ModConfigSpec.IntValue AREA_SPELL_RADIUS;
    public static ModConfigSpec.IntValue AREA_SPELL_AMPLIFIER;

    public static ModConfigSpec.IntValue ORB_PAGE_COST;
    public static ModConfigSpec.IntValue WAND_PAGE_COST;
    public static ModConfigSpec.IntValue SPELL_PAGE_COST;
    public static ModConfigSpec.IntValue ALCHEMY_PAGE_COST;
    public static ModConfigSpec.IntValue CURSE_PAGE_COST;
    public static ModConfigSpec.IntValue ENCHANTING_PAGE_COST;
    public static ModConfigSpec.IntValue LOST_PAGE_COST;
    public static ModConfigSpec.IntValue BANNED_PAGE_COST;
    public static ModConfigSpec.IntValue SOUL_COST;
    public static ModConfigSpec.ConfigValue<ArrayList<String>> ALTAR_TREASURES;

    public static void init(ModContainer container) {
        initServer();
        initClient();
        initCommon();

        container.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        container.registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
        container.registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG);
    }


    public static void initClient() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        ACTIVATE_VISIBLE_RUNE_TYPE = builder.comment("Activate the visibility of the rune type name on the item").define("activate_visible_rune_type", true);
        ACTIVATE_RUNESTONE_DESCRIPTION = builder.comment("Activate the description of the rune stones").define("activate_runestone_description", true);
        ACTIVATE_RUNESTONE_JEI_DESCRIPTION = builder.comment("Activate the description of the rune stones in JEI").define("activate_runestone_jei_description", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        CHARGING_COST = builder.comment("The amount of experience levels that you need to create the magical book").defineInRange("charging_cost", 15, 1, 30);
        CAN_SPAWN_ENDERDRAGON = builder.comment("Activate that the banned ritual can spawn an ender dragon").define("can_spawn_enderdragon", false);
        builder.pop();

        builder.comment("Altar").push(CATEGORY_ALTAR);
        SOUL_COST = builder.comment("The amount of experience levels that you need to use a soul on the altar").defineInRange("soul_cost", 1, 0, 50);
        ALTAR_TREASURES = builder.comment("A list of all the items that can spawn on an altar during a treasure ritual [modid:item]").define("altar_treasures", new ArrayList<>(Arrays.asList(
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ELYTRA).toString(),
                BuiltInRegistries.ITEM.getKey(Items.NETHER_STAR).toString(),
                BuiltInRegistries.ITEM.getKey(Items.TOTEM_OF_UNDYING).toString(),
                BuiltInRegistries.ITEM.getKey(Items.EXPERIENCE_BOTTLE).toString(),
                BuiltInRegistries.ITEM.getKey(Items.END_CRYSTAL).toString(),
                BuiltInRegistries.ITEM.getKey(Items.GHAST_TEAR).toString(),
                BuiltInRegistries.ITEM.getKey(Items.BLAZE_ROD).toString(),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_SWORD).toString(),
                BuiltInRegistries.ITEM.getKey(Items.DRAGON_BREATH).toString(),
                BuiltInRegistries.ITEM.getKey(Items.NETHERITE_SCRAP).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ENCHANTED_BOOK).toString(),
                BuiltInRegistries.ITEM.getKey(Items.GOLDEN_APPLE).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ENCHANTED_GOLDEN_APPLE).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ENDER_EYE).toString(),
                BuiltInRegistries.ITEM.getKey(Items.EMERALD).toString(),
                BuiltInRegistries.ITEM.getKey(Items.AMETHYST_CLUSTER).toString(),
                BuiltInRegistries.ITEM.getKey(Items.HEART_OF_THE_SEA).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ENDER_PEARL).toString(),
                BuiltInRegistries.ITEM.getKey(Items.PRISMARINE_CRYSTALS).toString(),
                BuiltInRegistries.ITEM.getKey(Items.ECHO_SHARD).toString(),
                BuiltInRegistries.ITEM.getKey(Items.OMINOUS_TRIAL_KEY).toString(),
                BuiltInRegistries.ITEM.getKey(Items.HEAVY_CORE).toString(),
                References.MODID + ":spirit_star", References.MODID + ":spirit_crystal"
        )));
        builder.pop();

        builder.comment("Rune Stones").push(CATEGORY_RUNESTONES);
        ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED = builder.comment("Activate the area effect of the rune stones when right clicked").define("activate_area_effect", true);
        ACTIVATE_REDSTONE_EFFECT = builder.comment("Activate the rune stone effect if the block is powered by redstone").define("activate_redstone_effect", true);
        SPELL_DURATION = builder.comment("The spell duration of the block effects").defineInRange("spell_duration", 200, 50, 10000);
        SPELL_AMPLIFIER = builder.comment("The spell amplifier of the block effects").defineInRange("spell_amplifier", 1, 0, 5);
        AREA_SPELL_DURATION = builder.comment("The duration of the area effect cloud of the rune stones").defineInRange("area_spell_duration", 200, 10, 10000);
        AREA_SPELL_AMPLIFIER = builder.comment("The amplifier of the area effect cloud of the rune stones").defineInRange("area_spell_amplifier", 0, 0, 5);
        AREA_SPELL_RADIUS = builder.comment("The radius of the area effect cloud of the rune stones").defineInRange("area_spell_radius", 8, 1, 50);
        builder.pop();

        builder.comment("Portable Rune Stones").push(CATEGORY_PORTABLE_RUNESTONES);
        //PORTABLE_RUNE_STONE_DURABILITY = builder.comment("The durability of portable rune stones").defineInRange("portable_runestone_durability", 200, 1, 1000);
        ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT = builder.comment("Activate if the effects from the portable rune stones are public").define("activate_runestone_public_effect", true);
        PORTABLE_SPELL_DURATION = builder.comment("The duration of the portable rune stone effects").defineInRange("portable_spell_duration", 200, 10, 1000);
        PORTABLE_SPELL_AMPLIFIER = builder.comment("The amplifier of the portable rune stone effects").defineInRange("portable_spell_amplifier", 0, 0, 5);
        PORTABLE_SPELL_RADIUS = builder.comment("The radius of the portable rune stone effects").defineInRange("portable_spell_radius", 2, 1, 10);
        PORTABLE_SPELL_COOLDOWN = builder.comment("The cooldown of the portable rune stone effects (should be more than portable spell duration)").defineInRange("portable_spell_cooldown", 300, 10, 10000);
        PORTABLE_RUNE_STONE_XP_REPAIR = builder.comment("Should the portable rune stones on the altar be able to be repaired with XP?").define("portable_rune_stones_xp_repair", false);
        builder.pop();

        builder.comment("Pages").push(CATEGORY_PAGES);
        ORB_PAGE_COST = builder.comment("The amount of experience levels that you need to use the orb page on the altar").defineInRange("orb_page_cost", 10, 0, 50);
        ENCHANTING_PAGE_COST = builder.comment("The amount of experience levels that you need to use the enchanting page on the altar").defineInRange("enchanting_page_cost", 10, 0, 50);
        SPELL_PAGE_COST = builder.comment("The amount of experience levels that you need to use the spell page on the altar").defineInRange("spell_page_cost", 5, 0, 50);
        WAND_PAGE_COST = builder.comment("The amount of experience levels that you need to use the wand page on the altar").defineInRange("wand_page_cost", 10, 0, 50);
        CURSE_PAGE_COST = builder.comment("The amount of experience levels that you need to use the curse page on the altar").defineInRange("curse_page_cost", 5, 0, 50);
        ALCHEMY_PAGE_COST = builder.comment("The amount of experience levels that you need to use the alchemy page on the altar").defineInRange("alchemy_page_cost", 10, 0, 50);
        LOST_PAGE_COST = builder.comment("The amount of experience levels that you need to use the lost page on the altar").defineInRange("lost_page_cost", 10, 0, 50);
        BANNED_PAGE_COST = builder.comment("The amount of experience levels that you need to use the banned page on the altar").defineInRange("banned_page_cost", 20, 0, 50);
        builder.pop();

        builder.comment("Wands").push(CATEGORY_WANDS);
        WAND_COOLDOWN = builder.comment("The cooldown of wand effects").defineInRange("wand_cooldown", 150, 5, 10000);
        WAND_XP_REPAIR = builder.comment("Should the wands on the altar be able to be repaired with XP?").define("wand_xp_repair", true);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    public static void initCommon() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        COMMON_CONFIG = builder.build();
    }

}