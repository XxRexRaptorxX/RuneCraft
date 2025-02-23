package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import xxrexraptorxx.runecraft.utils.RuneHelper;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.ParticleShapeTypes;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class BlockRuin extends Block {

	public BlockRuin(Properties properties) {
		super(properties);
	}


	@Override
	public void onBlockExploded(BlockState state, ServerLevel level, BlockPos pos, Explosion explosion) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.RUNESTONE_CLUSTERED, ParticleTypes.ENCHANT, level, pos);

		if(!level.isClientSide) {
			level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

			ItemEntity drop1 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			ItemEntity drop2 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			ItemEntity drop3 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			level.addFreshEntity(drop1);
			level.addFreshEntity(drop2);
			level.addFreshEntity(drop3);
		}
	}


	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
		SpellHelper.spawnParticleEffects(ParticleShapeTypes.RUNESTONE_CLUSTERED, ParticleTypes.ENCHANT, level, pos);

		if(!level.isClientSide) {
			ItemEntity drop1 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			ItemEntity drop2 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			ItemEntity drop3 = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, new ItemStack(RuneHelper.getRandomRune()));
			level.addFreshEntity(drop1);
			level.addFreshEntity(drop2);
			level.addFreshEntity(drop3);
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(RuneHelper.getRandomRune()));
		drops.add(new ItemStack(RuneHelper.getRandomRune()));
		drops.add(new ItemStack(RuneHelper.getRandomRune()));

		return drops;
	}
}