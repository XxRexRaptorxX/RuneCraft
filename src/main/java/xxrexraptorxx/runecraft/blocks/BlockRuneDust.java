package xxrexraptorxx.runecraft.blocks;

import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


public class BlockRuneDust extends FallingBlock {

	public BlockRuneDust() {
		super(Properties.of(Material.SAND)
				.strength(0.2F, 0.0F)
				.sound(SoundType.SOUL_SAND)
				.color(MaterialColor.NETHER)
		);
	}
}