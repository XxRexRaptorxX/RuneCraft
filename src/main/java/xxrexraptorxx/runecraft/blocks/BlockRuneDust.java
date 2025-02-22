package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;


public class BlockRuneDust extends FallingBlock {

	public static final MapCodec<BlockRuneDust> CODEC = simpleCodec(BlockRuneDust::new);


	public BlockRuneDust(Properties properties) {
		super(properties);
	}


	@Override
	protected MapCodec<? extends FallingBlock> codec() {
		return codec();
	}
}