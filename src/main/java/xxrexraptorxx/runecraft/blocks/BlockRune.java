package xxrexraptorxx.runecraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import xxrexraptorxx.runecraft.utils.RuneHelper;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;

import javax.annotation.Nullable;

public class BlockRune extends FallingBlock {

    public static final MapCodec<BlockRune> CODEC = simpleCodec(BlockRune::new);
    protected static final VoxelShape CUSTOM_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.00D, 16.0D);


    public BlockRune(Properties properties) {
        super(properties);
    }


    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entityIn) {
        if(!level.isClientSide) {
            if(entityIn instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) entityIn;
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10));
            }
        }
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        SpellHelper.spawnParticleEffects(ParticleShapeTypes.BLOCK_EVENT, ParticleTypes.ENCHANT, level, pos);

        if(!level.isClientSide) {
            ItemEntity drop = new ItemEntity(level, pos.getX(), pos.getY() + 0.8F, pos.getZ(), new ItemStack(RuneHelper.getRuneFromType(BuiltInRegistries.BLOCK.getKey(this).toString().substring(21))));
            level.addFreshEntity(drop);
        }
    }



    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CUSTOM_SHAPE;
    }


    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }


    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return canSupportCenter(level, pos.below(), Direction.DOWN);
    }



    //Facing

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);

    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }


    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
