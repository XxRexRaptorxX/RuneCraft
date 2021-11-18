package xxrexraptorxx.runecraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


public class BlockRuneScriber extends Block {

	public BlockRuneScriber() {
		super(Properties.of(Material.STONE)
				.strength(3.5F)
				.sound(SoundType.STONE)
				.color(MaterialColor.COLOR_BLACK)
		);
	}

	//TODO

}