package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;


public class BlockRuneDust extends FallingBlock {

    public static final MapCodec<BlockRuneDust> CODEC = simpleCodec(BlockRuneDust::new);


    public BlockRuneDust(Properties properties) {
        super(properties);
    }


    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }


    @Override
    public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return defaultMapColor().calculateARGBColor(MapColor.Brightness.NORMAL);
    }
}
