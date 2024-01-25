package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;


public class BlockRuneDust extends FallingBlock {

	public BlockRuneDust() {
		super(Properties.of()
				.strength(0.2F, 0.0F)
				.sound(SoundType.SOUL_SAND)
				.mapColor(MapColor.NETHER)
				.instrument(NoteBlockInstrument.SNARE)
		);
	}


	@Override
	protected MapCodec<? extends FallingBlock> codec() {
		return null;
	}
}