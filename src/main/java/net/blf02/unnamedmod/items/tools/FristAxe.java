package net.blf02.unnamedmod.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FristAxe extends ToolAxe {

	public FristAxe(String name, ToolMaterial material, float damage, float speed) {
		super(name, material, damage, speed);		
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		boolean finalResult = super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
		if (finalResult) {
			int passes = 1;
			while (passes != 0) {
				passes = 0;
				for (double xMod = -3; xMod <= 3; xMod++) {
					for (double yMod = -5; yMod <= 5; yMod++) {
						for (double zMod = -3; zMod <= 3; zMod++) {
							BlockPos blockCheck = new BlockPos(pos.getX() + xMod, pos.getY() + yMod, pos.getZ() + zMod);
							if (worldIn.getBlockState(blockCheck).getBlock().equals(Blocks.LOG) || worldIn.getBlockState(blockCheck).getBlock().equals(Blocks.LOG2)) {
								passes++;
								worldIn.destroyBlock(blockCheck, true);
							}
						}
					}
				}
				
			}
		}
		return finalResult;
	}
}
