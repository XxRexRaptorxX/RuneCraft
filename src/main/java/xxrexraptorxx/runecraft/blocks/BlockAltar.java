package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Random;


public class BlockAltar extends Block {

	public BlockAltar() {
		super(Properties.of()
				.requiresCorrectToolForDrops()
				.strength(5.0F, 7.0F)
				.sound(SoundType.STONE)
				.mapColor(MapColor.COLOR_BLACK)
				.instrument(NoteBlockInstrument.WITHER_SKELETON)
				.noOcclusion()
				.lightLevel(value -> 7)
		);
	}


	@Override
	public void animateTick(BlockState pState, Level world, BlockPos pos, RandomSource random) {
		Random rand = new Random();

		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 1.0F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;

		world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}