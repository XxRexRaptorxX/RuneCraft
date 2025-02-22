package xxrexraptorxx.runecraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.blocks.*;
import xxrexraptorxx.runecraft.main.References;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);

    public static void init(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }


    //BLOCKS
    public static final DeferredBlock<BlockAltar> ALTAR_BLOCK = BLOCKS.register("altar", BlockAltar::new);
    public static final DeferredItem<Item> ALTAR_BLOCKITEM = ITEMS.register("altar", () -> new BlockItem(ALTAR_BLOCK.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneScriber> RUNE_SCRIBER_BLOCK = BLOCKS.register("rune_scriber", BlockRuneScriber::new);
    public static final DeferredItem<Item> RUNE_SCRIBER_BLOCKITEM = ITEMS.register("rune_scriber", () -> new BlockItem(RUNE_SCRIBER_BLOCK.get(), new Item.Properties()));

    public static final DeferredBlock<BlockAsh> ASH_BLOCK = BLOCKS.register("ash_block", BlockAsh::new);
    public static final DeferredItem<Item> ASH_BLOCKITEM = ITEMS.register("ash_block", () -> new BlockItem(ASH_BLOCK.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneDust> RUNE_DUST_BLOCK = BLOCKS.register("rune_dust_block", BlockRuneDust::new);
    public static final DeferredItem<Item> RUNE_DUST_BLOCKITEM = ITEMS.register("rune_dust_block", () -> new BlockItem(RUNE_DUST_BLOCK.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuin> RUIN_BLOCK = BLOCKS.register("ruin_block", BlockRuin::new);
    public static final DeferredItem<Item> RUIN_BLOCKITEM = ITEMS.register("ruin_block", () -> new BlockItem(RUIN_BLOCK.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE = BLOCKS.register("rune_stone", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_BLOCKITEM = ITEMS.register("rune_stone", () -> new BlockItem(RUNE_STONE.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_A = BLOCKS.register("rune_stone_a", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_A_BLOCKITEM = ITEMS.register("rune_stone_a", () -> new BlockItem(RUNE_STONE_A.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_B = BLOCKS.register("rune_stone_b", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_B_BLOCKITEM = ITEMS.register("rune_stone_b", () -> new BlockItem(RUNE_STONE_B.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_C = BLOCKS.register("rune_stone_c", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_C_BLOCKITEM = ITEMS.register("rune_stone_c", () -> new BlockItem(RUNE_STONE_C.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_D = BLOCKS.register("rune_stone_d", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_D_BLOCKITEM = ITEMS.register("rune_stone_d", () -> new BlockItem(RUNE_STONE_D.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_E = BLOCKS.register("rune_stone_e", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_E_BLOCKITEM = ITEMS.register("rune_stone_e", () -> new BlockItem(RUNE_STONE_E.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_F = BLOCKS.register("rune_stone_f", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_F_BLOCKITEM = ITEMS.register("rune_stone_f", () -> new BlockItem(RUNE_STONE_F.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_G = BLOCKS.register("rune_stone_g", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_G_BLOCKITEM = ITEMS.register("rune_stone_g", () -> new BlockItem(RUNE_STONE_G.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_H = BLOCKS.register("rune_stone_h", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_H_BLOCKITEM = ITEMS.register("rune_stone_h", () -> new BlockItem(RUNE_STONE_H.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_I = BLOCKS.register("rune_stone_i", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_I_BLOCKITEM = ITEMS.register("rune_stone_i", () -> new BlockItem(RUNE_STONE_I.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_J = BLOCKS.register("rune_stone_j", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_J_BLOCKITEM = ITEMS.register("rune_stone_j", () -> new BlockItem(RUNE_STONE_J.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_K = BLOCKS.register("rune_stone_k", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_K_BLOCKITEM = ITEMS.register("rune_stone_k", () -> new BlockItem(RUNE_STONE_K.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_L = BLOCKS.register("rune_stone_l", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_L_BLOCKITEM = ITEMS.register("rune_stone_l", () -> new BlockItem(RUNE_STONE_L.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_M = BLOCKS.register("rune_stone_m", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_M_BLOCKITEM = ITEMS.register("rune_stone_m", () -> new BlockItem(RUNE_STONE_M.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_N = BLOCKS.register("rune_stone_n", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_N_BLOCKITEM = ITEMS.register("rune_stone_n", () -> new BlockItem(RUNE_STONE_N.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_O = BLOCKS.register("rune_stone_o", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_O_BLOCKITEM = ITEMS.register("rune_stone_o", () -> new BlockItem(RUNE_STONE_O.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_P = BLOCKS.register("rune_stone_p", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_P_BLOCKITEM = ITEMS.register("rune_stone_p", () -> new BlockItem(RUNE_STONE_P.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Q = BLOCKS.register("rune_stone_q", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_Q_BLOCKITEM = ITEMS.register("rune_stone_q", () -> new BlockItem(RUNE_STONE_Q.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_R = BLOCKS.register("rune_stone_r", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_R_BLOCKITEM = ITEMS.register("rune_stone_r", () -> new BlockItem(RUNE_STONE_R.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_S = BLOCKS.register("rune_stone_s", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_S_BLOCKITEM = ITEMS.register("rune_stone_s", () -> new BlockItem(RUNE_STONE_S.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_T = BLOCKS.register("rune_stone_t", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_T_BLOCKITEM = ITEMS.register("rune_stone_t", () -> new BlockItem(RUNE_STONE_T.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_U = BLOCKS.register("rune_stone_u", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_U_BLOCKITEM = ITEMS.register("rune_stone_u", () -> new BlockItem(RUNE_STONE_U.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_V = BLOCKS.register("rune_stone_v", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_V_BLOCKITEM = ITEMS.register("rune_stone_v", () -> new BlockItem(RUNE_STONE_V.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_W = BLOCKS.register("rune_stone_w", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_W_BLOCKITEM = ITEMS.register("rune_stone_w", () -> new BlockItem(RUNE_STONE_W.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_X = BLOCKS.register("rune_stone_x", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_X_BLOCKITEM = ITEMS.register("rune_stone_x", () -> new BlockItem(RUNE_STONE_X.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Y = BLOCKS.register("rune_stone_y", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_Y_BLOCKITEM = ITEMS.register("rune_stone_y", () -> new BlockItem(RUNE_STONE_Y.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Z = BLOCKS.register("rune_stone_z", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_Z_BLOCKITEM = ITEMS.register("rune_stone_z", () -> new BlockItem(RUNE_STONE_Z.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_DMG = BLOCKS.register("rune_stone_dmg", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_DMG_BLOCKITEM = ITEMS.register("rune_stone_dmg", () -> new BlockItem(RUNE_STONE_DMG.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_HRD = BLOCKS.register("rune_stone_hrd", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_HRD_BLOCKITEM = ITEMS.register("rune_stone_hrd", () -> new BlockItem(RUNE_STONE_HRD.get(), new Item.Properties()));

    //public static final DeferredBlock<BlockRuneStone> RUNE_STONE_GHS = BLOCKS.register("rune_stone_ghs", BlockRuneStone::new);
    //public static final DeferredItem<Item> RUNE_STONE_GHS_BLOCKITEM = ITEMS.register("rune_stone_ghs", () -> new BlockItem(RUNE_STONE_GHS.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_FRE = BLOCKS.register("rune_stone_fre", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_FRE_BLOCKITEM = ITEMS.register("rune_stone_fre", () -> new BlockItem(RUNE_STONE_FRE.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_PTL = BLOCKS.register("rune_stone_ptl", BlockRuneStone::new);
    public static final DeferredItem<Item> RUNE_STONE_PTL_BLOCKITEM = ITEMS.register("rune_stone_ptl", () -> new BlockItem(RUNE_STONE_PTL.get(), new Item.Properties()));


    public static final DeferredBlock<BlockRune> RUNE_BLOCK_A = BLOCKS.register("rune_block_a", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_A_BLOCKITEM = ITEMS.register("rune_block_a", () -> new BlockItem(RUNE_BLOCK_A.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_B = BLOCKS.register("rune_block_b", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_B_BLOCKITEM = ITEMS.register("rune_block_b", () -> new BlockItem(RUNE_BLOCK_B.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_C = BLOCKS.register("rune_block_c", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_C_BLOCKITEM = ITEMS.register("rune_block_c", () -> new BlockItem(RUNE_BLOCK_C.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_D = BLOCKS.register("rune_block_d", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_D_BLOCKITEM = ITEMS.register("rune_block_d", () -> new BlockItem(RUNE_BLOCK_D.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_E = BLOCKS.register("rune_block_e", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_E_BLOCKITEM = ITEMS.register("rune_block_e", () -> new BlockItem(RUNE_BLOCK_E.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_F = BLOCKS.register("rune_block_f", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_F_BLOCKITEM = ITEMS.register("rune_block_f", () -> new BlockItem(RUNE_BLOCK_F.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_G = BLOCKS.register("rune_block_g", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_G_BLOCKITEM = ITEMS.register("rune_block_g", () -> new BlockItem(RUNE_BLOCK_G.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_H = BLOCKS.register("rune_block_h", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_H_BLOCKITEM = ITEMS.register("rune_block_h", () -> new BlockItem(RUNE_BLOCK_H.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_I = BLOCKS.register("rune_block_i", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_I_BLOCKITEM = ITEMS.register("rune_block_i", () -> new BlockItem(RUNE_BLOCK_I.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_J = BLOCKS.register("rune_block_j", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_J_BLOCKITEM = ITEMS.register("rune_block_j", () -> new BlockItem(RUNE_BLOCK_J.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_K = BLOCKS.register("rune_block_k", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_K_BLOCKITEM = ITEMS.register("rune_block_k", () -> new BlockItem(RUNE_BLOCK_K.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_L = BLOCKS.register("rune_block_l", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_L_BLOCKITEM = ITEMS.register("rune_block_l", () -> new BlockItem(RUNE_BLOCK_L.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_M = BLOCKS.register("rune_block_m", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_M_BLOCKITEM = ITEMS.register("rune_block_m", () -> new BlockItem(RUNE_BLOCK_M.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_N = BLOCKS.register("rune_block_n", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_N_BLOCKITEM = ITEMS.register("rune_block_n", () -> new BlockItem(RUNE_BLOCK_N.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_O = BLOCKS.register("rune_block_o", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_O_BLOCKITEM = ITEMS.register("rune_block_o", () -> new BlockItem(RUNE_BLOCK_O.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_P = BLOCKS.register("rune_block_p", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_P_BLOCKITEM = ITEMS.register("rune_block_p", () -> new BlockItem(RUNE_BLOCK_P.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Q = BLOCKS.register("rune_block_q", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_Q_BLOCKITEM = ITEMS.register("rune_block_q", () -> new BlockItem(RUNE_BLOCK_Q.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_R = BLOCKS.register("rune_block_r", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_R_BLOCKITEM = ITEMS.register("rune_block_r", () -> new BlockItem(RUNE_BLOCK_R.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_S = BLOCKS.register("rune_block_s", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_S_BLOCKITEM = ITEMS.register("rune_block_s", () -> new BlockItem(RUNE_BLOCK_S.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_T = BLOCKS.register("rune_block_t", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_T_BLOCKITEM = ITEMS.register("rune_block_t", () -> new BlockItem(RUNE_BLOCK_T.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_U = BLOCKS.register("rune_block_u", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_U_BLOCKITEM = ITEMS.register("rune_block_u", () -> new BlockItem(RUNE_BLOCK_U.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_V = BLOCKS.register("rune_block_v", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_V_BLOCKITEM = ITEMS.register("rune_block_v", () -> new BlockItem(RUNE_BLOCK_V.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_W = BLOCKS.register("rune_block_w", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_W_BLOCKITEM = ITEMS.register("rune_block_w", () -> new BlockItem(RUNE_BLOCK_W.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_X = BLOCKS.register("rune_block_x", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_X_BLOCKITEM = ITEMS.register("rune_block_x", () -> new BlockItem(RUNE_BLOCK_X.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Y = BLOCKS.register("rune_block_y", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_Y_BLOCKITEM = ITEMS.register("rune_block_y", () -> new BlockItem(RUNE_BLOCK_Y.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Z = BLOCKS.register("rune_block_z", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_Z_BLOCKITEM = ITEMS.register("rune_block_z", () -> new BlockItem(RUNE_BLOCK_Z.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_DMG = BLOCKS.register("rune_block_dmg", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_DMG_BLOCKITEM = ITEMS.register("rune_block_dmg", () -> new BlockItem(RUNE_BLOCK_DMG.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_FRE = BLOCKS.register("rune_block_fre", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_FRE_BLOCKITEM = ITEMS.register("rune_block_fre", () -> new BlockItem(RUNE_BLOCK_FRE.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_HRD = BLOCKS.register("rune_block_hrd", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_HRD_BLOCKITEM = ITEMS.register("rune_block_hrd", () -> new BlockItem(RUNE_BLOCK_HRD.get(), new Item.Properties()));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_PTL = BLOCKS.register("rune_block_ptl", BlockRune::new);
    public static final DeferredItem<Item> RUNE_BLOCK_PTL_BLOCKITEM = ITEMS.register("rune_block_ptl", () -> new BlockItem(RUNE_BLOCK_PTL.get(), new Item.Properties()));


    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockCreator) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockCreator.apply(BlockBehaviour.Properties.of().setId(blockId(name))));
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ModItems.itemId(name)).useBlockDescriptionPrefix()));
    }

    public static ResourceKey<Block> blockId(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }
}