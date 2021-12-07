package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class BlockAsh extends FallingBlock {

	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);


	public BlockAsh() {
		super(Properties.of(Material.SAND)
				.strength(0.2F, 0.0F)
				.sound(SoundType.SAND)
				.color(MaterialColor.COLOR_BLACK)
		);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return CUSTOM_COLLISION_AABB;
	}

}