package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class BlockAsh extends FallingBlock {

	public static final MapCodec<BlockAsh> CODEC = simpleCodec(BlockAsh::new);
	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);


	public BlockAsh(Properties properties) {
		super(properties);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return CUSTOM_COLLISION_AABB;
	}


	@Override
	protected MapCodec<? extends FallingBlock> codec() {
		return CODEC;
	}
}