package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class BlockAsh extends FallingBlock {

	protected static final VoxelShape CUSTOM_COLLISION_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);


	public BlockAsh() {
		super(Properties.of()
				.strength(0.2F, 0.0F)
				.sound(SoundType.SAND)
				.mapColor(MapColor.COLOR_BLACK)
				.instrument(NoteBlockInstrument.SNARE)
		);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return CUSTOM_COLLISION_AABB;
	}


	@Override
	protected MapCodec<? extends FallingBlock> codec() {
		return null;
	}
}