package xxrexraptorxx.runecraft.registry;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.items.*;
import xxrexraptorxx.runecraft.main.References;
import xxrexraptorxx.runecraft.utils.ArmorMaterials;

public class ModItems {

    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.MODID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final DeferredItem<ItemWand> BASIC_WAND = ITEMS.register("basic_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> AETHER_WAND = ITEMS.register("aether_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> NETHER_WAND = ITEMS.register("nether_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> CURSE_WAND = ITEMS.register("curse_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> HOLY_WAND = ITEMS.register("holy_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> STORM_WAND = ITEMS.register("storm_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> MAELSTROM_WAND = ITEMS.register("maelstrom_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> ESCAPE_WAND = ITEMS.register("escape_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> DEFENSIVE_WAND = ITEMS.register("defensive_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> THUNDER_WAND = ITEMS.register("thunder_wand", ItemWand::new);
    //public static final DeferredItem<ItemWand> TIME_WAND = ITEMS.register("time_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> CREATURE_WAND = ITEMS.register("creature_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> CHANGING_WAND = ITEMS.register("changing_wand", ItemWand::new);
    public static final DeferredItem<ItemWand> DESTRUCTION_WAND = ITEMS.register("destruction_wand", ItemWand::new);
    public static final DeferredItem<ItemMagicalBook> MAGICAL_BOOK = ITEMS.register("magical_book", ItemMagicalBook::new);
    public static final DeferredItem<ItemPage> MAGICAL_PAGE = ITEMS.register("magical_page", ItemPage::new);
    public static final DeferredItem<ItemPage> SPELL_PAGE = ITEMS.register("spell_page", ItemPage::new);
    public static final DeferredItem<ItemPage> ENCHANTING_PAGE = ITEMS.register("enchanting_page", ItemPage::new);
    public static final DeferredItem<ItemPage> WAND_PAGE = ITEMS.register("wand_page", ItemPage::new);
    public static final DeferredItem<ItemPage> ORB_PAGE = ITEMS.register("orb_page", ItemPage::new);
    public static final DeferredItem<ItemPage> ALCHEMY_PAGE = ITEMS.register("alchemy_page", ItemPage::new);
    public static final DeferredItem<ItemPage> CURSE_PAGE = ITEMS.register("curse_page", ItemPage::new);
    public static final DeferredItem<ItemPage> LOST_PAGE = ITEMS.register("lost_page", ItemPage::new);
    public static final DeferredItem<ItemPage> BANNED_PAGE = ITEMS.register("banned_page", ItemPage::new);
    public static final DeferredItem<ItemRelict> ORB = ITEMS.register("orb", ItemRelict::new);
    public static final DeferredItem<ItemRelict> SOUL_ORB = ITEMS.register("soul_orb", ItemRelict::new);
    public static final DeferredItem<ItemRelict> SPIRIT_STAR = ITEMS.register("spirit_star", ItemRelict::new);
    public static final DeferredItem<ItemRelict> SPIRIT_CRYSTAL = ITEMS.register("spirit_crystal", ItemRelict::new);
    public static final DeferredItem<ItemBasic> ASH = ITEMS.register("ash", ItemBasic::new);
    public static final DeferredItem<ItemBasic> RUNE_DUST = ITEMS.register("rune_dust", ItemBasic::new);
    public static final DeferredItem<ItemBasic> CLOTH = ITEMS.register("cloth", ItemBasic::new);
    public static final DeferredItem<ItemSoul> SOUL = ITEMS.register("soul", ItemSoul::new);
    public static final DeferredItem<ItemRune> RUNE_A = ITEMS.register("rune_a", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_B = ITEMS.register("rune_b", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_C = ITEMS.register("rune_c", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_D = ITEMS.register("rune_d", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_E = ITEMS.register("rune_e", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_F = ITEMS.register("rune_f", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_G = ITEMS.register("rune_g", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_H = ITEMS.register("rune_h", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_I = ITEMS.register("rune_i", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_J = ITEMS.register("rune_j", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_K = ITEMS.register("rune_k", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_L = ITEMS.register("rune_l", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_M = ITEMS.register("rune_m", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_N = ITEMS.register("rune_n", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_O = ITEMS.register("rune_o", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_P = ITEMS.register("rune_p", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_Q = ITEMS.register("rune_q", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_R = ITEMS.register("rune_r", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_S = ITEMS.register("rune_s", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_T = ITEMS.register("rune_t", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_U = ITEMS.register("rune_u", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_V = ITEMS.register("rune_v", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_W = ITEMS.register("rune_w", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_X = ITEMS.register("rune_x", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_Y = ITEMS.register("rune_y", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_Z = ITEMS.register("rune_z", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_DMG = ITEMS.register("rune_dmg", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_FRE = ITEMS.register("rune_fre", ItemRune::new);
    //public static finaDeferredItemct<ItemRune> RUNE_GHS = ITEMS.register("rune_ghs", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_HRD = ITEMS.register("rune_hrd", ItemRune::new);
    public static final DeferredItem<ItemRune> RUNE_PTL = ITEMS.register("rune_ptl", ItemRune::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE = ITEMS.register("portable_rune_stone", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_A = ITEMS.register("portable_rune_stone_a", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_B = ITEMS.register("portable_rune_stone_b", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_C = ITEMS.register("portable_rune_stone_c", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_D = ITEMS.register("portable_rune_stone_d", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_E = ITEMS.register("portable_rune_stone_e", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_F = ITEMS.register("portable_rune_stone_f", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_G = ITEMS.register("portable_rune_stone_g", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_H = ITEMS.register("portable_rune_stone_h", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_I = ITEMS.register("portable_rune_stone_i", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_J = ITEMS.register("portable_rune_stone_j", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_K = ITEMS.register("portable_rune_stone_k", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_L = ITEMS.register("portable_rune_stone_l", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_M = ITEMS.register("portable_rune_stone_m", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_N = ITEMS.register("portable_rune_stone_n", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_O = ITEMS.register("portable_rune_stone_o", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_P = ITEMS.register("portable_rune_stone_p", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Q = ITEMS.register("portable_rune_stone_q", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_R = ITEMS.register("portable_rune_stone_r", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_S = ITEMS.register("portable_rune_stone_s", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_T = ITEMS.register("portable_rune_stone_t", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_U = ITEMS.register("portable_rune_stone_u", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_V = ITEMS.register("portable_rune_stone_v", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_W = ITEMS.register("portable_rune_stone_w", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_X = ITEMS.register("portable_rune_stone_x", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Y = ITEMS.register("portable_rune_stone_y", ItemPortableRuneStone::new);
    public static final DeferredItem<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Z = ITEMS.register("portable_rune_stone_z", ItemPortableRuneStone::new);

    public static final DeferredItem<ArmorItem> MAGICAL_CAP = ITEMS.register("magical_cap", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MAGICAL_ROBE = ITEMS.register("magical_robe", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MAGICAL_PANTS = ITEMS.register("magical_pants", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MAGICAL_BOOTS = ITEMS.register("magical_boots", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<SwordItem> RITUAL_DAGGER = ITEMS.register("ritual_dagger", () -> new SwordItem(Tiers.GOLD, 3, -1.0f, new Item.Properties()));

}