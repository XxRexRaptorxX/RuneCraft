package xxrexraptorxx.runecraft.main;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xxrexraptorxx.runecraft.blocks.*;
import xxrexraptorxx.runecraft.utils.CreativeTab;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, References.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, References.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }


    //BLOCKS
    public static final RegistryObject<BlockAltar> ALTAR_BLOCK = BLOCKS.register("altar", BlockAltar::new);
    public static final RegistryObject<Item> ALTAR_BLOCKITEM = ITEMS.register("altar", () -> new BlockItem(ALTAR_BLOCK.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockRuneScriber> RUNE_SCRIBER_BLOCK = BLOCKS.register("rune_scriber", BlockRuneScriber::new);
    public static final RegistryObject<Item> RUNE_SCRIBER_BLOCKITEM = ITEMS.register("rune_scriber", () -> new BlockItem(RUNE_SCRIBER_BLOCK.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockAshe> ASHE_BLOCK = BLOCKS.register("ashe_block", BlockAshe::new);
    public static final RegistryObject<Item> ASHE_BLOCKITEM = ITEMS.register("ashe_block", () -> new BlockItem(ASHE_BLOCK.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockRuneDust> RUNE_DUST_BLOCK = BLOCKS.register("rune_dust_block", BlockRuneDust::new);
    public static final RegistryObject<Item> RUNE_DUST_BLOCKITEM = ITEMS.register("rune_dust_block", () -> new BlockItem(RUNE_DUST_BLOCK.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockRuin> RUIN_BLOCK = BLOCKS.register("ruin_block", BlockRuin::new);
    public static final RegistryObject<Item> RUIN_BLOCKITEM = ITEMS.register("ruin_block", () -> new BlockItem(RUIN_BLOCK.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE = BLOCKS.register("rune_stone", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_BLOCKITEM = ITEMS.register("rune_stone", () -> new BlockItem(RUNE_STONE.get(), new Item.Properties().tab(CreativeTab.MOD_TAB)));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_A = BLOCKS.register("rune_stone_a", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_A_BLOCKITEM = ITEMS.register("rune_stone_a", () -> new BlockItem(RUNE_STONE_A.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_B = BLOCKS.register("rune_stone_b", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_B_BLOCKITEM = ITEMS.register("rune_stone_b", () -> new BlockItem(RUNE_STONE_B.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_C = BLOCKS.register("rune_stone_c", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_C_BLOCKITEM = ITEMS.register("rune_stone_c", () -> new BlockItem(RUNE_STONE_C.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_D = BLOCKS.register("rune_stone_d", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE__BLOCKITEM = ITEMS.register("rune_stone_d", () -> new BlockItem(RUNE_STONE_D.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_E = BLOCKS.register("rune_stone_e", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_E_BLOCKITEM = ITEMS.register("rune_stone_e", () -> new BlockItem(RUNE_STONE_E.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_F = BLOCKS.register("rune_stone_f", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_F_BLOCKITEM = ITEMS.register("rune_stone_f", () -> new BlockItem(RUNE_STONE_F.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_G = BLOCKS.register("rune_stone_g", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_G_BLOCKITEM = ITEMS.register("rune_stone_g", () -> new BlockItem(RUNE_STONE_G.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_H = BLOCKS.register("rune_stone_h", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_H_BLOCKITEM = ITEMS.register("rune_stone_h", () -> new BlockItem(RUNE_STONE_H.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_I = BLOCKS.register("rune_stone_i", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_I_BLOCKITEM = ITEMS.register("rune_stone_i", () -> new BlockItem(RUNE_STONE_I.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_J = BLOCKS.register("rune_stone_j", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_J_BLOCKITEM = ITEMS.register("rune_stone_j", () -> new BlockItem(RUNE_STONE_J.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_K = BLOCKS.register("rune_stone_k", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_K_BLOCKITEM = ITEMS.register("rune_stone_k", () -> new BlockItem(RUNE_STONE_K.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_L = BLOCKS.register("rune_stone_l", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_L_BLOCKITEM = ITEMS.register("rune_stone_l", () -> new BlockItem(RUNE_STONE_L.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_M = BLOCKS.register("rune_stone_m", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_M_BLOCKITEM = ITEMS.register("rune_stone_m", () -> new BlockItem(RUNE_STONE_M.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_N = BLOCKS.register("rune_stone_n", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_N_BLOCKITEM = ITEMS.register("rune_stone_n", () -> new BlockItem(RUNE_STONE_N.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_O = BLOCKS.register("rune_stone_o", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_O_BLOCKITEM = ITEMS.register("rune_stone_o", () -> new BlockItem(RUNE_STONE_O.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_P = BLOCKS.register("rune_stone_p", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_P_BLOCKITEM = ITEMS.register("rune_stone_p", () -> new BlockItem(RUNE_STONE_P.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_Q = BLOCKS.register("rune_stone_q", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_Q_BLOCKITEM = ITEMS.register("rune_stone_q", () -> new BlockItem(RUNE_STONE_Q.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_R = BLOCKS.register("rune_stone_r", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_R_BLOCKITEM = ITEMS.register("rune_stone_r", () -> new BlockItem(RUNE_STONE_R.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_S = BLOCKS.register("rune_stone_s", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_S_BLOCKITEM = ITEMS.register("rune_stone_s", () -> new BlockItem(RUNE_STONE_S.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_T = BLOCKS.register("rune_stone_t", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_T_BLOCKITEM = ITEMS.register("rune_stone_t", () -> new BlockItem(RUNE_STONE_T.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_U = BLOCKS.register("rune_stone_u", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_U_BLOCKITEM = ITEMS.register("rune_stone_u", () -> new BlockItem(RUNE_STONE_U.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_V = BLOCKS.register("rune_stone_v", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_V_BLOCKITEM = ITEMS.register("rune_stone_v", () -> new BlockItem(RUNE_STONE_V.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_W = BLOCKS.register("rune_stone_w", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_W_BLOCKITEM = ITEMS.register("rune_stone_w", () -> new BlockItem(RUNE_STONE_W.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_X = BLOCKS.register("rune_stone_x", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_X_BLOCKITEM = ITEMS.register("rune_stone_x", () -> new BlockItem(RUNE_STONE_X.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_Y = BLOCKS.register("rune_stone_y", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_Y_BLOCKITEM = ITEMS.register("rune_stone_y", () -> new BlockItem(RUNE_STONE_Y.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_Z = BLOCKS.register("rune_stone_z", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_Z_BLOCKITEM = ITEMS.register("rune_stone_z", () -> new BlockItem(RUNE_STONE_Z.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_DMG = BLOCKS.register("rune_stone_dmg", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_DMG_BLOCKITEM = ITEMS.register("rune_stone_dmg", () -> new BlockItem(RUNE_STONE_DMG.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_HRD = BLOCKS.register("rune_stone_hrd", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_HRD_BLOCKITEM = ITEMS.register("rune_stone_hrd", () -> new BlockItem(RUNE_STONE_HRD.get(), new Item.Properties()));

    //public static final RegistryObject<BlockRuneStone> RUNE_STONE_GHS = BLOCKS.register("rune_stone_ghs", BlockRuneStone::new);
    //public static final RegistryObject<Item> RUNE_STONE_GHS_BLOCKITEM = ITEMS.register("rune_stone_ghs", () -> new BlockItem(RUNE_STONE_GHS.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_FRE = BLOCKS.register("rune_stone_fre", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_FRE_BLOCKITEM = ITEMS.register("rune_stone_fre", () -> new BlockItem(RUNE_STONE_FRE.get(), new Item.Properties()));

    public static final RegistryObject<BlockRuneStone> RUNE_STONE_PTL = BLOCKS.register("rune_stone_ptl", BlockRuneStone::new);
    public static final RegistryObject<Item> RUNE_STONE_PTL_BLOCKITEM = ITEMS.register("rune_stone_ptl", () -> new BlockItem(RUNE_STONE_PTL.get(), new Item.Properties()));
}