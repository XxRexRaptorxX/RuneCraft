package xxrexraptorxx.runecraft.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.blocks.*;
import xxrexraptorxx.runecraft.main.References;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);

    public static void init(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }


    public static final DeferredBlock<BlockAltar> ALTAR_BLOCK = registerBlock("altar", properties -> new BlockAltar(properties
                .requiresCorrectToolForDrops()
                .strength(5.0F, 7.0F)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .instrument(NoteBlockInstrument.WITHER_SKELETON)
                .noOcclusion()
                .lightLevel(value -> 7)
    ));

    public static final DeferredBlock<BlockRuneScriber> RUNE_SCRIBER_BLOCK = registerBlock("rune_scriber", properties -> new BlockRuneScriber(properties
                .strength(3.5F)
                .sound(SoundType.STONE)
                .mapColor(MapColor.COLOR_BLACK)
                .instrument(NoteBlockInstrument.BASS)
    ));

    public static final DeferredBlock<BlockAsh> ASH_BLOCK = registerBlock("ash_block", properties -> new BlockAsh(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_BLACK)
                .instrument(NoteBlockInstrument.SNARE)
    ));

    public static final DeferredBlock<BlockRuneDust> RUNE_DUST_BLOCK = registerBlock("rune_dust_block", properties -> new BlockRuneDust(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SOUL_SAND)
                .mapColor(MapColor.NETHER)
                .instrument(NoteBlockInstrument.SNARE)
    ));

    public static final DeferredBlock<BlockRuin> RUIN_BLOCK = registerBlock("ruin_block", properties -> new BlockRuin(properties
                .requiresCorrectToolForDrops()
                .strength(1.8F, 7.0F)
                .sound(SoundType.STONE)
                .mapColor(MapColor.DEEPSLATE)
                .instrument(NoteBlockInstrument.BASEDRUM)
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE = registerBlock("rune_stone", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_A = registerBlock("rune_stone_a", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_B = registerBlock("rune_stone_b", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_C = registerBlock("rune_stone_c", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_D = registerBlock("rune_stone_d", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_E = registerBlock("rune_stone_e", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_F = registerBlock("rune_stone_f", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_G = registerBlock("rune_stone_g", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_H = registerBlock("rune_stone_h", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_I = registerBlock("rune_stone_i", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_J = registerBlock("rune_stone_j", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_K = registerBlock("rune_stone_k", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_L = registerBlock("rune_stone_l", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_M = registerBlock("rune_stone_m", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_N = registerBlock("rune_stone_n", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_O = registerBlock("rune_stone_o", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_P = registerBlock("rune_stone_p", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Q = registerBlock("rune_stone_q", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_R = registerBlock("rune_stone_r", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_S = registerBlock("rune_stone_s", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_T = registerBlock("rune_stone_t", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_U = registerBlock("rune_stone_u", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_V = registerBlock("rune_stone_v", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_W = registerBlock("rune_stone_w", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_X = registerBlock("rune_stone_x", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Y = registerBlock("rune_stone_y", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_Z = registerBlock("rune_stone_z", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_DMG = registerBlock("rune_stone_dmg", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_HRD = registerBlock("rune_stone_hrd", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    //public static final DeferredBlock<BlockRuneStone> RUNE_STONE_GHS = registerBlock()("rune_stone_ghs", BlockRuneStone:properties -> new

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_FRE = registerBlock("rune_stone_fre", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
				.strength(7.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.DEEPSLATE)
				.instrument(NoteBlockInstrument.BASS)
				.noOcclusion()
    ));

    public static final DeferredBlock<BlockRuneStone> RUNE_STONE_PTL = registerBlock("rune_stone_ptl", properties -> new BlockRuneStone(properties
                .requiresCorrectToolForDrops()
                .strength(7.0F, 7.0F)
                .sound(SoundType.STONE)
                .mapColor(MapColor.DEEPSLATE)
                .instrument(NoteBlockInstrument.BASS)
                .noOcclusion()
    ));



    public static final DeferredBlock<BlockRune> RUNE_BLOCK_A = registerBlock("rune_block_a", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_B = registerBlock("rune_block_b", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_C = registerBlock("rune_block_c", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_D = registerBlock("rune_block_d", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_E = registerBlock("rune_block_e", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_F = registerBlock("rune_block_f", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_G = registerBlock("rune_block_g", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_H = registerBlock("rune_block_h", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_I = registerBlock("rune_block_i", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_J = registerBlock("rune_block_j", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_K = registerBlock("rune_block_k", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_L = registerBlock("rune_block_l", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_M = registerBlock("rune_block_m", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_N = registerBlock("rune_block_n", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_O = registerBlock("rune_block_o", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_P = registerBlock("rune_block_p", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Q = registerBlock("rune_block_q", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_R = registerBlock("rune_block_r", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_S = registerBlock("rune_block_s", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_T = registerBlock("rune_block_t", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_U = registerBlock("rune_block_u", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_V = registerBlock("rune_block_v", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_W = registerBlock("rune_block_w", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_X = registerBlock("rune_block_x", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Y = registerBlock("rune_block_y", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_Z = registerBlock("rune_block_z", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_DMG = registerBlock("rune_block_dmg", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_FRE = registerBlock("rune_block_fre", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_HRD = registerBlock("rune_block_hrd", properties -> new BlockRune(properties
                .strength(0.2F, 0.0F)
                .sound(SoundType.SAND)
                .mapColor(MapColor.COLOR_RED)
                .noCollission()
                .noOcclusion()
                .instrument(NoteBlockInstrument.FLUTE)
    ));

    public static final DeferredBlock<BlockRune> RUNE_BLOCK_PTL = registerBlock("rune_block_ptl", properties -> new BlockRune(properties
            .strength(0.2F, 0.0F)
            .sound(SoundType.SAND)
            .mapColor(MapColor.COLOR_RED)
            .noCollission()
            .noOcclusion()
            .instrument(NoteBlockInstrument.FLUTE)
    ));


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