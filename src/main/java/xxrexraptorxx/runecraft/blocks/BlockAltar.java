package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;


public class BlockAltar extends Block {

	public BlockAltar(Properties properties) {
		super(properties);
	}


	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_AMBIENT, ParticleTypes.SMOKE, level, pos);
	}
}