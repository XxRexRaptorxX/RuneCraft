package xxrexraptorxx.runecraft.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_RUNESTONES = "runestones";
    public static final String CATEGORY_PORTABLE_RUNESTONES = "portable_runestones";
    public static final String CATEGORY_PAGES = "pages";
    public static final String CATEGORY_WANDS = "wands";

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ForgeConfigSpec.BooleanValue ACTIVATE_ASH_GEN;
    public static ForgeConfigSpec.BooleanValue ACTIVATE_VISIBLE_RUNE_TYPE;
    public static ForgeConfigSpec.BooleanValue ACTIVATE_RUNESTONE_DESCRIPTION;
    public static ForgeConfigSpec.BooleanValue ACTIVATE_RUNESTONE_JEI_DESCRIPTION;
    public static ForgeConfigSpec.IntValue CHARGING_COST;
    public static ForgeConfigSpec.BooleanValue CAN_SPAWN_ENDERDRAGON;

    public static ForgeConfigSpec.BooleanValue ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT;
    //public static ForgeConfigSpec.IntValue PORTABLE_RUNE_STONE_DURABILITY;                            deprecated
    public static ForgeConfigSpec.IntValue PORTABLE_SPELL_DURATION;
    public static ForgeConfigSpec.IntValue PORTABLE_SPELL_RADIUS;
    public static ForgeConfigSpec.IntValue PORTABLE_SPELL_AMPLIFIER;
    public static ForgeConfigSpec.IntValue PORTABLE_SPELL_COOLDOWN;
    public static ForgeConfigSpec.IntValue WAND_COOLDOWN;
    public static ForgeConfigSpec.BooleanValue PORTABLE_RUNE_STONE_XP_REPAIR;
    public static ForgeConfigSpec.BooleanValue WAND_XP_REPAIR;


    public static ForgeConfigSpec.BooleanValue ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED;
    public static ForgeConfigSpec.BooleanValue ACTIVATE_REDSTONE_EFFECT;
    public static ForgeConfigSpec.IntValue SPELL_DURATION;
    public static ForgeConfigSpec.IntValue SPELL_AMPLIFIER;
    public static ForgeConfigSpec.IntValue AREA_SPELL_DURATION;
    public static ForgeConfigSpec.IntValue AREA_SPELL_RADIUS;
    public static ForgeConfigSpec.IntValue AREA_SPELL_AMPLIFIER;

    public static ForgeConfigSpec.IntValue ORB_PAGE_COST;
    public static ForgeConfigSpec.IntValue WAND_PAGE_COST;
    public static ForgeConfigSpec.IntValue SPELL_PAGE_COST;
    public static ForgeConfigSpec.IntValue ALCHEMY_PAGE_COST;
    public static ForgeConfigSpec.IntValue CURSE_PAGE_COST;
    public static ForgeConfigSpec.IntValue ENCHANTING_PAGE_COST;
    public static ForgeConfigSpec.IntValue LOST_PAGE_COST;
    public static ForgeConfigSpec.IntValue BANNED_PAGE_COST;
    public static ForgeConfigSpec.IntValue SOUL_COST;

    public static void init() {
        initServer();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        ACTIVATE_VISIBLE_RUNE_TYPE = builder.comment("Activate the visibility of the rune type name on the item").define("activate_visible_rune_type", true);
        ACTIVATE_RUNESTONE_DESCRIPTION = builder.comment("Activate the description of the rune stones").define("activate_runestone_description", true);
        ACTIVATE_RUNESTONE_JEI_DESCRIPTION = builder.comment("Activate the description of the rune stones in JEI").define("activate_runestone_jei_description", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        ACTIVATE_ASH_GEN = builder.comment("Activate the generation of ash blocks in the nether").define("ash_generation", true);
        CHARGING_COST = builder.comment("The amount of experience levels that you need to create the magical book").defineInRange("charging_cost", 15, 1, 30);
        CAN_SPAWN_ENDERDRAGON = builder.comment("Activate that the banned ritual can spawn an ender dragon").define("can_spawn_enderdragon", false);
        SOUL_COST = builder.comment("The amount of experience levels that you need to use a soul on the altar").defineInRange("soul_cost", 1, 0, 50);
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

}