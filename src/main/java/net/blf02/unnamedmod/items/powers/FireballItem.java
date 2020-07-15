package net.blf02.unnamedmod.items.powers;

import net.blf02.unnamedmod.entities.CustomFireball;
import net.blf02.unnamedmod.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballItem extends ItemBase {

	public FireballItem(String name) {
		super(name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		ItemStack item = player.getHeldItem(hand);
		Vec3d aim = player.getLookVec();
		CustomFireball fireball = new CustomFireball(world, player, 1, 1, 1);
		
		fireball.setPosition(player.posX + aim.x * 1.5D, player.posY + aim.y * 1.5D, player.posZ + aim.z * 1.5D);
		fireball.accelerationX = aim.x * 0.1;
		fireball.accelerationY = aim.y * 0.1;
		fireball.accelerationZ = aim.z * 0.1;
		world.spawnEntity(fireball);
		
		item.damageItem(1, player);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}
