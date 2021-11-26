package xxrexraptorxx.runecraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import xxrexraptorxx.runecraft.main.RuneCraft;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber() {
		super(Properties.of(Material.STONE)
				.strength(3.5F)
				.sound(SoundType.STONE)
				.color(MaterialColor.COLOR_BLACK)
		);
	}
/**

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityRuneScriber) {
				playerIn.openGui(RuneCraft.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
				playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
			}

			return true;
		}
	}


	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityRuneScriber();
	}


	@Override
	public boolean hasTileEntity(IBlockState state){
		return true;
	}


	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}

**/
}