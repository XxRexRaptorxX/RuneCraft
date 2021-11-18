package xxrexraptorxx.runecraft.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;


public class BlockAshe extends FallingBlock {

	protected static final AABB CUSTOM_AABB = new AABB (0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);


	public BlockAshe() {
		super(Properties.of(Material.SAND)
				.strength(0.2F, 0.0F)
				.sound(SoundType.SOUL_SAND)
				.color(MaterialColor.COLOR_BLACK)
		);
	}


	public static AABB getCustomAabb() {
		return CUSTOM_AABB;
	}
}