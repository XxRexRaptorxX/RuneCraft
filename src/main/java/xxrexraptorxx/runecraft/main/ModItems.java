package xxrexraptorxx.runecraft.main;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.runecraft.items.*;
import xxrexraptorxx.runecraft.utils.ArmorMaterials;
import xxrexraptorxx.runecraft.utils.CreativeTab;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<ItemWand> BASIC_WAND = ITEMS.register("basic_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> AETHER_WAND = ITEMS.register("aether_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> NETHER_WAND = ITEMS.register("nether_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> CURSE_WAND = ITEMS.register("curse_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> HOLY_WAND = ITEMS.register("holy_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> STORM_WAND = ITEMS.register("storm_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> MAELSTROM_WAND = ITEMS.register("maelstrom_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> ESCAPE_WAND = ITEMS.register("escape_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> DEFENSIVE_WAND = ITEMS.register("defensive_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> THUNDER_WAND = ITEMS.register("thunder_wand", ItemWand::new);
    //public static final RegistryObject<ItemWand> TIME_WAND = ITEMS.register("time_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> CREATURE_WAND = ITEMS.register("creature_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> CHANGING_WAND = ITEMS.register("changing_wand", ItemWand::new);
    public static final RegistryObject<ItemWand> DESTRUCTION_WAND = ITEMS.register("destruction_wand", ItemWand::new);
    public static final RegistryObject<ItemMagicalBook> MAGICAL_BOOK = ITEMS.register("magical_book", ItemMagicalBook::new);
    public static final RegistryObject<ItemPage> MAGICAL_PAGE = ITEMS.register("magical_page", ItemPage::new);
    public static final RegistryObject<ItemPage> SPELL_PAGE = ITEMS.register("spell_page", ItemPage::new);
    public static final RegistryObject<ItemPage> ENCHANTING_PAGE = ITEMS.register("enchanting_page", ItemPage::new);
    public static final RegistryObject<ItemPage> WAND_PAGE = ITEMS.register("wand_page", ItemPage::new);
    public static final RegistryObject<ItemPage> ORB_PAGE = ITEMS.register("orb_page", ItemPage::new);
    public static final RegistryObject<ItemPage> ALCHEMY_PAGE = ITEMS.register("alchemy_page", ItemPage::new);
    public static final RegistryObject<ItemPage> CURSE_PAGE = ITEMS.register("curse_page", ItemPage::new);
    public static final RegistryObject<ItemPage> LOST_PAGE = ITEMS.register("lost_page", ItemPage::new);
    public static final RegistryObject<ItemPage> BANNED_PAGE = ITEMS.register("banned_page", ItemPage::new);
    public static final RegistryObject<ItemRelict> ORB = ITEMS.register("orb", ItemRelict::new);
    public static final RegistryObject<ItemRelict> SPIRIT_STAR = ITEMS.register("spirit_star", ItemRelict::new);
    public static final RegistryObject<ItemRelict> SPIRIT_CRYSTAL = ITEMS.register("spirit_crystal", ItemRelict::new);
    public static final RegistryObject<ItemBasic> ASH = ITEMS.register("ash", ItemBasic::new);
    public static final RegistryObject<ItemBasic> RUNE_DUST = ITEMS.register("rune_dust", ItemBasic::new);
    public static final RegistryObject<ItemBasic> CLOTH = ITEMS.register("cloth", ItemBasic::new);
    public static final RegistryObject<ItemSoul> SOUL = ITEMS.register("soul", ItemSoul::new);
    public static final RegistryObject<ItemRune> RUNE_A = ITEMS.register("rune_a", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_B = ITEMS.register("rune_b", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_C = ITEMS.register("rune_c", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_D = ITEMS.register("rune_d", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_E = ITEMS.register("rune_e", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_F = ITEMS.register("rune_f", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_G = ITEMS.register("rune_g", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_H = ITEMS.register("rune_h", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_I = ITEMS.register("rune_i", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_J = ITEMS.register("rune_j", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_K = ITEMS.register("rune_k", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_L = ITEMS.register("rune_l", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_M = ITEMS.register("rune_m", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_N = ITEMS.register("rune_n", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_O = ITEMS.register("rune_o", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_P = ITEMS.register("rune_p", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_Q = ITEMS.register("rune_q", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_R = ITEMS.register("rune_r", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_S = ITEMS.register("rune_s", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_T = ITEMS.register("rune_t", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_U = ITEMS.register("rune_u", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_V = ITEMS.register("rune_v", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_W = ITEMS.register("rune_w", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_X = ITEMS.register("rune_x", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_Y = ITEMS.register("rune_y", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_Z = ITEMS.register("rune_z", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_DMG = ITEMS.register("rune_dmg", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_FRE = ITEMS.register("rune_fre", ItemRune::new);
    //public static final RegistryObject<ItemRune> RUNE_GHS = ITEMS.register("rune_ghs", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_HRD = ITEMS.register("rune_hrd", ItemRune::new);
    public static final RegistryObject<ItemRune> RUNE_PTL = ITEMS.register("rune_ptl", ItemRune::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE = ITEMS.register("portable_rune_stone", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_A = ITEMS.register("portable_rune_stone_a", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_B = ITEMS.register("portable_rune_stone_b", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_C = ITEMS.register("portable_rune_stone_c", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_D = ITEMS.register("portable_rune_stone_d", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_E = ITEMS.register("portable_rune_stone_e", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_F = ITEMS.register("portable_rune_stone_f", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_G = ITEMS.register("portable_rune_stone_g", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_H = ITEMS.register("portable_rune_stone_h", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_I = ITEMS.register("portable_rune_stone_i", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_J = ITEMS.register("portable_rune_stone_j", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_K = ITEMS.register("portable_rune_stone_k", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_L = ITEMS.register("portable_rune_stone_l", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_M = ITEMS.register("portable_rune_stone_m", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_N = ITEMS.register("portable_rune_stone_n", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_O = ITEMS.register("portable_rune_stone_o", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_P = ITEMS.register("portable_rune_stone_p", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Q = ITEMS.register("portable_rune_stone_q", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_R = ITEMS.register("portable_rune_stone_r", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_S = ITEMS.register("portable_rune_stone_s", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_T = ITEMS.register("portable_rune_stone_t", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_U = ITEMS.register("portable_rune_stone_u", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_V = ITEMS.register("portable_rune_stone_v", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_W = ITEMS.register("portable_rune_stone_w", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_X = ITEMS.register("portable_rune_stone_x", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Y = ITEMS.register("portable_rune_stone_y", ItemPortableRuneStone::new);
    public static final RegistryObject<ItemPortableRuneStone> PORTABLE_RUNE_STONE_Z = ITEMS.register("portable_rune_stone_z", ItemPortableRuneStone::new);

    public static final RegistryObject<ArmorItem> MAGICAL_CAP = ITEMS.register("magical_cap", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> MAGICAL_ROBE = ITEMS.register("magical_robe", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> MAGICAL_PANTS = ITEMS.register("magical_pants", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTab.MOD_TAB)));
    public static final RegistryObject<ArmorItem> MAGICAL_BOOTS = ITEMS.register("magical_boots", () -> new ItemArmorMagical(ArmorMaterials.MAGICAL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeTab.MOD_TAB)));

}