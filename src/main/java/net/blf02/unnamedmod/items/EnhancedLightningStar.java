package net.blf02.unnamedmod.items;

import net.blf02.unnamedmod.util.ClonedVanillaFunctions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EnhancedLightningStar extends LightningStar {

	public EnhancedLightningStar(String name) {
		super(name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		super.onItemRightClick(world, player, hand);
		ItemStack item = player.getHeldItem(hand);
		RayTraceResult result = ClonedVanillaFunctions.rayTrace(player, 100.0D, 1);
		
		world.newExplosion(player, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), 2.0F, true, true);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}

}
