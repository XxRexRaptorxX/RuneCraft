package xxrexraptorxx.runecraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.items.*;
import xxrexraptorxx.runecraft.main.References;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);


    public static void init(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

    public static final DeferredItem<ItemWand> BASIC_WAND = ITEMS.register("basic_wand", () -> new ItemWand(new Item.Properties().setId(itemId("basic_wand"))));
    public static final DeferredItem<ItemWand> AETHER_WAND = ITEMS.register("aether_wand", () -> new ItemWand(new Item.Properties().setId(itemId("aether_wand"))));
    public static final DeferredItem<ItemWand> NETHER_WAND = ITEMS.register("nether_wand", () -> new ItemWand(new Item.Properties().setId(itemId("nether_wand"))));
    public static final DeferredItem<ItemWand> CURSE_WAND = ITEMS.register("curse_wand", () -> new ItemWand(new Item.Properties().setId(itemId("curse_wand"))));
    public static final DeferredItem<ItemWand> HOLY_WAND = ITEMS.register("holy_wand", () -> new ItemWand(new Item.Properties().setId(itemId("holy_wand"))));
    public static final DeferredItem<ItemWand> STORM_WAND = ITEMS.register("storm_wand", () -> new ItemWand(new Item.Properties().setId(itemId("storm_wand"))));
    public static final DeferredItem<ItemWand> MAELSTROM_WAND = ITEMS.register("maelstrom_wand", () -> new ItemWand(new Item.Properties().setId(itemId("maelstrom_wand"))));
    public static final DeferredItem<ItemWand> ESCAPE_WAND = ITEMS.register("escape_wand", () -> new ItemWand(new Item.Properties().setId(itemId("escape_wand"))));
    public static final DeferredItem<ItemWand> DEFENSIVE_WAND = ITEMS.register("defensive_wand", () -> new ItemWand(new Item.Properties().setId(itemId("defensive_wand"))));
    public static final DeferredItem<ItemWand> THUNDER_WAND = ITEMS.register("thunder_wand", () -> new ItemWand(new Item.Properties().setId(itemId("thunder_wand"))));
    //public static final DeferredItem<ItemWand> TIME_WAND = ITEMSregister()registerItem()("time_wand", ItemWandprops new () ::(new Ite.Properties.setId(itemId())""
    public static final DeferredItem<ItemWand> CREATURE_WAND = ITEMS.register("creature_wand", () -> new ItemWand(new Item.Properties().setId(itemId("creature_wand"))));
    public static final DeferredItem<ItemWand> CHANGING_WAND = ITEMS.register("changing_wand", () -> new ItemWand(new Item.Properties().setId(itemId("changing_wand"))));
    public static final DeferredItem<ItemWand> DESTRUCTION_WAND = ITEMS.register("destruction_wand", () -> new ItemWand(new Item.Properties().setId(itemId("destruction_wand"))));
    public static final DeferredItem<ItemMagicalBook> MAGICAL_BOOK = ITEMS.register("magical_book", () -> new ItemMagicalBook(new Item.Properties().setId(itemId("magical_book"))));
    public static final DeferredItem<ItemPage> MAGICAL_PAGE = ITEMS.register("magical_page", () -> new ItemPage(new Item.Properties().setId(itemId("magical_page"))));
    public static final DeferredItem<ItemPage> SPELL_PAGE = ITEMS.register("spell_page", () -> new ItemPage(new Item.Properties().setId(itemId("spell_page"))));
    public static final DeferredItem<ItemPage> ENCHANTING_PAGE = ITEMS.register("enchanting_page", () -> new ItemPage(new Item.Properties().setId(itemId("enchanting_page"))));
    public static final DeferredItem<ItemPage> WAND_PAGE = ITEMS.register("wand_page", () -> new ItemPage(new Item.Properties().setId(itemId("wand_page"))));
    public static final DeferredItem<ItemPage> ORB_PAGE = ITEMS.register("orb_page", () -> new ItemPage(new Item.Properties().setId(itemId("orb_page"))));
    public static final DeferredItem<ItemPage> ALCHEMY_PAGE = ITEMS.register("alchemy_page", () -> new ItemPage(new Item.Properties().setId(itemId("alchemy_page"))));
    public static final DeferredItem<ItemPage> CURSE_PAGE = ITEMS.register("curse_page", () -> new ItemPage(new Item.Properties().setId(itemId("curse_page"))));
    public static final DeferredItem<ItemPage> LOST_PAGE = ITEMS.register("lost_page", () -> new ItemPage(new Item.Properties().setId(itemId("lost_page"))));
    public static final DeferredItem<ItemPage> BANNED_PAGE = ITEMS.register("banned_page", () -> new ItemPage(new Item.Properties().setId(itemId("banned_page"))));
    public static final DeferredItem<ItemRelict> ORB = ITEMS.register("orb", () -> new ItemRelict(new Item.Properties().setId(itemId("orb"))));
    public static final DeferredItem<ItemRelict> SOUL_ORB = ITEMS.register("soul_orb", () -> new ItemRelict(new Item.Properties().setId(itemId("soul_orb"))));
    public static final DeferredItem<ItemRelict> SPIRIT_STAR = ITEMS.register("spirit_star", () -> new ItemRelict(new Item.Properties().setId(itemId("spirit_star"))));
    public static final DeferredItem<ItemRelict> SPIRIT_CRYSTAL = ITEMS.register("spirit_crystal", () -> new ItemRelict(new Item.Properties().setId(itemId("spirit_crystal"))));
    public static final DeferredItem<Item> ASH = ITEMS.register("ash", () -> new Item(new Item.Properties().setId(itemId("ash"))));
    public static final DeferredItem<Item> RUNE_DUST = ITEMS.register("rune_dust", () -> new Item(new Item.Properties().setId(itemId("rune_dust"))));
    public static final DeferredItem<Item> CLOTH = ITEMS.register("cloth", () -> new Item(new Item.Properties().setId(itemId("cloth"))));
    public static final DeferredItem<ItemSoul> SOUL = ITEMS.register("soul", () -> new ItemSoul(new Item.Properties().setId(itemId("soul"))));
    public static final DeferredItem<ItemRune> RUNE_A = ITEMS.register("rune_a", () -> new ItemRune(new Item.Properties().setId(itemId("rune_a"))));
    public static final DeferredItem<ItemRune> RUNE_B = ITEMS.register("rune_b", () -> new ItemRune(new Item.Properties().setId(itemId("rune_b"))));
    public static final DeferredItem<ItemRune> RUNE_C = ITEMS.register("rune_c", () -> new ItemRune(new Item.Properties().setId(itemId("rune_c"))));
    public static final DeferredItem<ItemRune> RUNE_D = ITEMS.register("rune_d", () -> new ItemRune(new Item.Properties().setId(itemId("rune_d"))));
    public static final DeferredItem<ItemRune> RUNE_E = ITEMS.register("rune_e", () -> new ItemRune(new Item.Properties().setId(itemId("rune_e"))));
    public static final DeferredItem<ItemRune> RUNE_F = ITEMS.register("rune_f", () -> new ItemRune(new Item.Properties().setId(itemId("rune_f"))));
    public static final DeferredItem<ItemRune> RUNE_G = ITEMS.register("rune_g", () -> new ItemRune(new Item.Properties().setId(itemId("rune_g"))));
    public static final DeferredItem<ItemRune> RUNE_H = ITEMS.register("rune_h", () -> new ItemRune(new Item.Properties().setId(itemId("rune_h"))));
    public static final DeferredItem<ItemRune> RUNE_I = ITEMS.register("rune_i", () -> new ItemRune(new Item.Properties().setId(itemId("rune_i"))));
    public static final DeferredItem<ItemRune> RUNE_J = ITEMS.register("rune_j", () -> new ItemRune(new Item.Properties().setId(itemId("rune_j"))));
    public static final DeferredItem<ItemRune> RUNE_K = ITEMS.register("rune_k", () -> new ItemRune(new Item.Properties().setId(itemId("rune_k"))));
    public static final DeferredItem<ItemRune> RUNE_L = ITEMS.register("rune_l", () -> new ItemRune(new Item.Properties().setId(itemId("rune_l"))));
    public static final DeferredItem<ItemRune> RUNE_M = ITEMS.register("rune_m", () -> new ItemRune(new Item.Properties().setId(itemId("rune_m"))));
    public static final DeferredItem<ItemRune> RUNE_N = ITEMS.register("rune_n", () -> new ItemRune(new Item.Properties().setId(itemId("rune_n"))));
    public static final DeferredItem<ItemRune> RUNE_O = ITEMS.register("rune_o", () -> new ItemRune(new Item.Properties().setId(itemId("rune_o"))));
    public static final DeferredItem<ItemRune> RUNE_P = ITEMS.register("rune_p", () -> new ItemRune(new Item.Properties().setId(itemId("rune_p"))));
    public static final DeferredItem<ItemRune> RUNE_Q = ITEMS.register("rune_q", () -> new ItemRune(new Item.Properties().setId(itemId("rune_q"))));
    public static final DeferredItem<ItemRune> RUNE_R = ITEMS.register("rune_r", () -> new ItemRune(new Item.Properties().setId(itemId("rune_r"))));
    public static final DeferredItem<ItemRune> RUNE_S = ITEMS.register("rune_s", () -> new ItemRune(new Item.Properties().setId(itemId("rune_s"))));
    public static final DeferredItem<ItemRune> RUNE_T = ITEMS.register("rune_t", () -> new ItemRune(new Item.Properties().setId(itemId("rune_t"))));
    public static final DeferredItem<ItemRune> RUNE_U = ITEMS.register("rune_u", () -> new ItemRune(new Item.Properties().setId(itemId("rune_u"))));
    public static final DeferredItem<ItemRune> RUNE_V = ITEMS.register("rune_v", () -> new ItemRune(new Item.Properties().setId(itemId("rune_v"))));
    public static final DeferredItem<ItemRune> RUNE_W = ITEMS.register("rune_w", () -> new ItemRune(new Item.Properties().setId(itemId("rune_w"))));
    public static final DeferredItem<ItemRune> RUNE_X = ITEMS.register("rune_x", () -> new ItemRune(new Item.Properties().setId(itemId("rune_x"))));
    public static final DeferredItem<ItemRune> RUNE_Y = ITEMS.register("rune_y", () -> new ItemRune(new Item.Properties().setId(itemId("rune_y"))));
    public static final DeferredItem<ItemRune> RUNE_Z = ITEMS.register("rune_z", () -> new ItemRune(new Item.Properties().setId(itemId("rune_z"))));
    public static final DeferredItem<ItemRune> RUNE_DMG = ITEMS.register("rune_dmg", () -> new ItemRune(new Item.Properties().setId(itemId("rune_dmg"))));
    public static final DeferredItem<ItemRune> RUNE_FRE = ITEMS.register("rune_fre", () -> new ItemRune(new Item.Properties().setId(itemId("rune_fre"))));
    //public static finaDeferredItemct<ItemRune> RUNE_GHS = ITEMS.register("rune_ghs", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_HRD = ITEMS.register("rune_hrd", () -> new ItemRune(new Item.Properties().setId(itemId("rune_hrd"))));
    public static final DeferredItem<ItemRune> RUNE_PTL = ITEMS.register("rune_ptl", () -> new ItemRune(new Item.Properties().setId(itemId("rune_ptl"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE = ITEMS.register("portable_rune_stone", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_A = ITEMS.register("portable_rune_stone_a", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_a"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_B = ITEMS.register("portable_rune_stone_b", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_b"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_C = ITEMS.register("portable_rune_stone_c", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_c"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_D = ITEMS.register("portable_rune_stone_d", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_d"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_E = ITEMS.register("portable_rune_stone_e", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_e"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_F = ITEMS.register("portable_rune_stone_f", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_f"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_G = ITEMS.register("portable_rune_stone_g", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_g"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_H = ITEMS.register("portable_rune_stone_h", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_h"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_I = ITEMS.register("portable_rune_stone_i", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_i"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_J = ITEMS.register("portable_rune_stone_j", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_j"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_K = ITEMS.register("portable_rune_stone_k", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_k"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_L = ITEMS.register("portable_rune_stone_l", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_l"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_M = ITEMS.register("portable_rune_stone_m", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_m"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_N = ITEMS.register("portable_rune_stone_n", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_n"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_O = ITEMS.register("portable_rune_stone_o", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_o"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_P = ITEMS.register("portable_rune_stone_p", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_p"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Q = ITEMS.register("portable_rune_stone_q", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_q"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_R = ITEMS.register("portable_rune_stone_r", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_r"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_S = ITEMS.register("portable_rune_stone_s", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_s"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_T = ITEMS.register("portable_rune_stone_t", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_t"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_U = ITEMS.register("portable_rune_stone_u", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_u"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_V = ITEMS.register("portable_rune_stone_v", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_v"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_W = ITEMS.register("portable_rune_stone_w", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_w"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_X = ITEMS.register("portable_rune_stone_x", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_x"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Y = ITEMS.register("portable_rune_stone_y", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_y"))));
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Z = ITEMS.register("portable_rune_stone_z", () -> new ItemPortableRuneStone(new Item.Properties().setId(itemId("portable_rune_stone_z"))));

    public static final DeferredItem<ArmorItem> MAGICAL_CAP = ITEMS.registerItem("magical_cap", props -> new ItemArmorMagical(ModArmorMaterials.MAGICAL_ARMOR_MATERIAL, ArmorType.HELMET, props));
    public static final DeferredItem<ArmorItem> MAGICAL_ROBE = ITEMS.registerItem("magical_robe", props -> new ItemArmorMagical(ModArmorMaterials.MAGICAL_ARMOR_MATERIAL, ArmorType.CHESTPLATE, props));
    public static final DeferredItem<ArmorItem> MAGICAL_PANTS = ITEMS.registerItem("magical_pants", props -> new ItemArmorMagical(ModArmorMaterials.MAGICAL_ARMOR_MATERIAL, ArmorType.LEGGINGS, props));
    public static final DeferredItem<ArmorItem> MAGICAL_BOOTS = ITEMS.registerItem("magical_boots", props -> new ItemArmorMagical(ModArmorMaterials.MAGICAL_ARMOR_MATERIAL, ArmorType.BOOTS, props));

    public static final DeferredItem<SwordItem> RITUAL_DAGGER = ITEMS.registerItem("ritual_dagger", props -> new SwordItem(ToolMaterial.GOLD, 3, -1.5f, props));


    public static ResourceKey<Item> itemId(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }

}