package xxrexraptorxx.runecraft.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.ModConfigSpec;
import xxrexraptorxx.magmacore.config.ConfigHelper;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Config {

    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec SERVER_CONFIG;
    public static ModConfigSpec CLIENT_CONFIG;

    private static ModConfigSpec.BooleanValue ACTIVATE_VISIBLE_RUNE_TYPE;
    private static ModConfigSpec.BooleanValue ACTIVATE_RUNESTONE_DESCRIPTION;
    private static ModConfigSpec.BooleanValue ACTIVATE_RUNESTONE_JEI_DESCRIPTION;

    private static ModConfigSpec.IntValue CHARGING_COST;
    private static ModConfigSpec.BooleanValue CAN_SPAWN_ENDERDRAGON;
    private static ModConfigSpec.IntValue SOUL_COST;
    private static ModConfigSpec.ConfigValue<ArrayList<String>> ALTAR_TREASURES;

    private static ModConfigSpec.BooleanValue ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED;
    private static ModConfigSpec.BooleanValue ACTIVATE_REDSTONE_EFFECT;
    private static ModConfigSpec.IntValue SPELL_DURATION;
    private static ModConfigSpec.IntValue SPELL_AMPLIFIER;
    private static ModConfigSpec.IntValue AREA_SPELL_DURATION;
    private static ModConfigSpec.IntValue AREA_SPELL_RADIUS;
    private static ModConfigSpec.IntValue AREA_SPELL_AMPLIFIER;

    private static ModConfigSpec.BooleanValue ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT;
    private static ModConfigSpec.IntValue PORTABLE_SPELL_DURATION;
    private static ModConfigSpec.IntValue PORTABLE_SPELL_RADIUS;
    private static ModConfigSpec.IntValue PORTABLE_SPELL_AMPLIFIER;
    private static ModConfigSpec.IntValue PORTABLE_SPELL_COOLDOWN;
    private static ModConfigSpec.BooleanValue PORTABLE_RUNE_STONE_XP_REPAIR;
    private static ModConfigSpec.IntValue ORB_PAGE_COST;
    private static ModConfigSpec.IntValue ENCHANTING_PAGE_COST;
    private static ModConfigSpec.IntValue SPELL_PAGE_COST;
    private static ModConfigSpec.IntValue WAND_PAGE_COST;
    private static ModConfigSpec.IntValue CURSE_PAGE_COST;
    private static ModConfigSpec.IntValue ALCHEMY_PAGE_COST;
    private static ModConfigSpec.IntValue LOST_PAGE_COST;
    private static ModConfigSpec.IntValue BANNED_PAGE_COST;

    private static ModConfigSpec.IntValue WAND_COOLDOWN;
    private static ModConfigSpec.BooleanValue WAND_XP_REPAIR;


    static {
        // CLIENT
        ConfigHelper.setCategory(CLIENT_BUILDER, "runes");
        ACTIVATE_VISIBLE_RUNE_TYPE = CLIENT_BUILDER.comment("Show the rune type name as tooltips on the items").define("activate_visible_rune_type", true);
        CLIENT_BUILDER.pop();

        ConfigHelper.setCategory(CLIENT_BUILDER, "runestones");
        ACTIVATE_RUNESTONE_DESCRIPTION = CLIENT_BUILDER.comment("Show runestone descriptions as tooltips on the items").define("activate_runestone_description", true);
        ACTIVATE_RUNESTONE_JEI_DESCRIPTION = CLIENT_BUILDER.comment("Show runestone descriptions in recipe viewers").define("activate_runestone_jei_description", true);
        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();


        // SERVER
        ConfigHelper.setCategory(SERVER_BUILDER, "altar");
        SOUL_COST = SERVER_BUILDER.comment("XP cost to use a soul on the altar").defineInRange("soul_cost", 1, 0, 50);
        ALTAR_TREASURES = SERVER_BUILDER.comment("Items that can spawn on the altar during a treasure ritual").define("altar_treasures", new ArrayList<>(Arrays.asList(
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
                        ModItems.SPIRIT_STAR.getKey().location().toString(),
                        ModItems.SPIRIT_CRYSTAL.getKey().location().toString()
                )));
        CHARGING_COST = SERVER_BUILDER.comment("XP cost to create a magical book").defineInRange("charging_cost", 15, 1, 30);
        CAN_SPAWN_ENDERDRAGON = SERVER_BUILDER.comment("Allow the banned ritual to spawn ender dragons").define("can_spawn_enderdragon", false);
        SERVER_BUILDER.pop();

        ConfigHelper.setCategory(SERVER_BUILDER, "runestones");
        ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED = SERVER_BUILDER.comment("Trigger a area effect on right-click").define("activate_area_effect", true);
        ACTIVATE_REDSTONE_EFFECT = SERVER_BUILDER.comment("Trigger effect when powered by redstone").define("activate_redstone_effect", true);
        SPELL_DURATION = SERVER_BUILDER.comment("Set the spell duration").defineInRange("spell_duration", 200, 50, 10000);
        SPELL_AMPLIFIER = SERVER_BUILDER.comment("Set the spell amplifier").defineInRange("spell_amplifier", 1, 0, 5);
        AREA_SPELL_DURATION = SERVER_BUILDER.comment("Duration of the area effect").defineInRange("area_spell_duration", 200, 10, 10000);
        AREA_SPELL_AMPLIFIER = SERVER_BUILDER.comment("Amplifier of the area effect").defineInRange("area_spell_amplifier", 0, 0, 5);
        AREA_SPELL_RADIUS = SERVER_BUILDER.comment("Radius of the area effect").defineInRange("area_spell_radius", 8, 1, 50);
        SERVER_BUILDER.pop();

        ConfigHelper.setCategory(SERVER_BUILDER, "portable_runestones");
        ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT = SERVER_BUILDER.comment("Makes the portable rune effects public").define("activate_runestone_public_effect", true);
        PORTABLE_SPELL_DURATION = SERVER_BUILDER.comment("Duration of portable rune effects").defineInRange("portable_spell_duration", 200, 10, 1000);
        PORTABLE_SPELL_AMPLIFIER = SERVER_BUILDER.comment("Amplifier of portable rune effects").defineInRange("portable_spell_amplifier", 0, 0, 5);
        PORTABLE_SPELL_RADIUS = SERVER_BUILDER.comment("Radius of portable rune effects").defineInRange("portable_spell_radius", 2, 1, 10);
        PORTABLE_SPELL_COOLDOWN = SERVER_BUILDER.comment("Cooldown of portable rune effects").defineInRange("portable_spell_cooldown", 300, 10, 10000);
        PORTABLE_RUNE_STONE_XP_REPAIR = SERVER_BUILDER.comment("Makes portable runes repairable with XP").define("portable_rune_stone_xp_repair", true);
        SERVER_BUILDER.pop();

        ConfigHelper.setCategory(SERVER_BUILDER,"pages");
        ORB_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a orb page on altar").defineInRange("orb_page_cost", 10, 0, 50);
        ENCHANTING_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a enchanting page").defineInRange("enchanting_page_cost", 10, 0, 50);
        SPELL_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a spell page").defineInRange("spell_page_cost", 5, 0, 50);
        WAND_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a wand page").defineInRange("wand_page_cost", 10, 0, 50);
        CURSE_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a curse page").defineInRange("curse_page_cost", 5, 0, 50);
        ALCHEMY_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a alchemy page").defineInRange("alchemy_page_cost", 10, 0, 50);
        LOST_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a lost page").defineInRange("lost_page_cost", 10, 0, 50);
        BANNED_PAGE_COST = SERVER_BUILDER.comment("Set the required XP to use a banned page").defineInRange("banned_page_cost", 20, 0, 50);
        SERVER_BUILDER.pop();

        ConfigHelper.setCategory(SERVER_BUILDER,"wands");
        WAND_COOLDOWN = SERVER_BUILDER.comment("Cooldown time of wand effects").defineInRange("wand_cooldown", 150, 5, 10000);
        WAND_XP_REPAIR = SERVER_BUILDER.comment("Allow XP repair of wands on the altar").define("wand_xp_repair", true);
        WAND_COOLDOWN = SERVER_BUILDER.comment("Cooldown time for using a wand").defineInRange("wand_cooldown", 20, 1, 1000);
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
    }


    // CLIENT
    public static boolean getActivateVisibleRuneType() { return ACTIVATE_VISIBLE_RUNE_TYPE.get(); }
    public static boolean getActivateRunestoneDescription() { return ACTIVATE_RUNESTONE_DESCRIPTION.get(); }
    public static boolean getActivateRunestoneJeiDescription() { return ACTIVATE_RUNESTONE_JEI_DESCRIPTION.get(); }

    // SERVER
    public static int getChargingCost() { return CHARGING_COST.get(); }
    public static boolean canSpawnEnderdragon() { return CAN_SPAWN_ENDERDRAGON.get(); }

    public static int getSoulCost() { return SOUL_COST.get(); }
    public static List<String> getAltarTreasures() { return ALTAR_TREASURES.get(); }

    public static boolean isActivateAreaEffectWhenRightClicked() { return ACTIVATE_AREA_EFFECT_WHEN_RIGHT_CLICKED.get(); }
    public static boolean isActivateRedstoneEffect() { return ACTIVATE_REDSTONE_EFFECT.get(); }
    public static int getSpellDuration() { return SPELL_DURATION.get(); }
    public static int getSpellAmplifier() { return SPELL_AMPLIFIER.get(); }
    public static int getAreaSpellDuration() { return AREA_SPELL_DURATION.get(); }
    public static float getAreaSpellRadius() { return AREA_SPELL_RADIUS.get().floatValue(); }
    public static int getAreaSpellAmplifier() { return AREA_SPELL_AMPLIFIER.get(); }
    public static boolean isActivatePortableRuneStonePublicEffect() { return ACTIVATE_PORTABLE_RUNESTONE_PUBLIC_EFFECT.get(); }
    public static int getPortableSpellDuration() { return PORTABLE_SPELL_DURATION.get(); }
    public static int getPortableSpellAmplifier() { return PORTABLE_SPELL_AMPLIFIER.get(); }
    public static float getPortableSpellRadius() { return PORTABLE_SPELL_RADIUS.get().floatValue(); }
    public static int getPortableSpellCooldown() { return PORTABLE_SPELL_COOLDOWN.get(); }
    public static boolean isPortableRuneStoneXpRepair() { return PORTABLE_RUNE_STONE_XP_REPAIR.get(); }
    public static int getOrbPageCost() { return ORB_PAGE_COST.get(); }
    public static int getEnchantingPageCost() { return ENCHANTING_PAGE_COST.get(); }
    public static int getSpellPageCost() { return SPELL_PAGE_COST.get(); }
    public static int getWandPageCost() { return WAND_PAGE_COST.get(); }
    public static int getCursePageCost() { return CURSE_PAGE_COST.get(); }
    public static int getAlchemyPageCost() { return ALCHEMY_PAGE_COST.get(); }
    public static int getLostPageCost() { return LOST_PAGE_COST.get(); }
    public static int getBannedPageCost() { return BANNED_PAGE_COST.get(); }
    public static int getWandCooldown() { return WAND_COOLDOWN.get(); }
    public static boolean getWandXPRepair() { return WAND_XP_REPAIR.get(); }
}
