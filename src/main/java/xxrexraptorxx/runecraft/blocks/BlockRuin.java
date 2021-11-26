package xxrexraptorxx.runecraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import xxrexraptorxx.runecraft.utils.AltarHelper;
import xxrexraptorxx.runecraft.utils.RuneHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BlockRuin extends Block {

	public BlockRuin() {
		super(Properties.of(Material.STONE)
				.requiresCorrectToolForDrops()
				.strength(1.8F, 7.0F)
				.sound(SoundType.STONE)
				.color(MaterialColor.DEEPSLATE)
		);
	}


	@Override
	public void onBlockExploded(BlockState state, Level world, BlockPos pos, Explosion explosion) {
		Random rand = new Random();

		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 0.8F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);

		if(!world.isClientSide) {
			world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

		}
	}


	@Override
	public void playerDestroy(Level world, Player pPlayer, BlockPos pos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
		Random rand = new Random();

		double d0 = (double)((float)pos.getX() + rand.nextFloat());
		double d1 = (double)((float)pos.getY() + 0.8F);
		double d2 = (double)((float)pos.getZ() + rand.nextFloat());
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0 - 0.3F, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(ParticleTypes.ENCHANT, d0, d1, d2 + 0.3F, 0.0D, 0.0D, 0.0D);
	}


	@Override
	public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(RuneHelper.getRandomRune()));
		drops.add(new ItemStack(RuneHelper.getRandomRune()));
		drops.add(new ItemStack(RuneHelper.getRandomRune()));

		return drops;
	}
}