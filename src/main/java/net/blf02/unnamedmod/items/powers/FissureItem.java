package net.blf02.unnamedmod.items.powers;

import java.util.List;

import net.blf02.unnamedmod.items.ItemBase;
import net.blf02.unnamedmod.util.BasicFunctions;
import net.blf02.unnamedmod.util.ClonedVanillaFunctions;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FissureItem extends ItemBase {
	
	private static int fissureTime = -99;
	private static World world;
	private static double playerX;
	private static double playerY;
	private static double playerZ;
	private static EntityPlayer player;
	private static Vec3d lookVec;
	private static RayTraceResult result;
	private static double oldBlockX;
	private static double oldBlockZ;
	private static Block[] illegalBlocks = {Blocks.WATER, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_LAVA, Blocks.FIRE};
	private static Block[] breakThroughBlocks = {Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.TORCH, Blocks.REDSTONE_TORCH, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.TALLGRASS, Blocks.DEADBUSH, Blocks.REDSTONE_WIRE, Blocks.SAPLING, Blocks.SNOW_LAYER};
	
	public FissureItem(String name) {
		super(name);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack item = playerIn.getHeldItem(hand);
		world = worldIn;
		lookVec = playerIn.getLookVec();
		playerX = playerIn.posX;
		playerY = playerIn.posY;
		playerZ = playerIn.posZ;
		player = playerIn;
		result = ClonedVanillaFunctions.rayTrace(playerIn, 2.0D, 1);
		fissureTime = 0;		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
	
	private static void doFissureTick() {
		boolean xDirIsPositive, zDirIsPositive;
		xDirIsPositive = result.getBlockPos().getX() > playerX;
		zDirIsPositive = result.getBlockPos().getZ() > playerZ;
		
		int xSteps = Math.abs((int) (lookVec.x * 10));
		int zSteps = Math.abs((int) (lookVec.z * 10));
		double blockX, blockZ;
		int currentStep = fissureTime + 1;
		double xMod = (double) (xSteps) / 10 * currentStep;
		double zMod = (double) (zSteps) / 10 * currentStep;
		if (xDirIsPositive) {
			blockX = playerX + xMod;
		} else {
			blockX = playerX - xMod;
		}
		if (zDirIsPositive) {
			blockZ = playerZ + zMod;
		} else {
			blockZ = playerZ - zMod;
		}
		if (fissureTime > 0 && blockX == oldBlockX && blockZ == oldBlockZ) { //Guarantees never being on the same block twice
			if (xSteps > zSteps) {
				if (xDirIsPositive) {
					blockX++;
				} else {
					blockX--;
				}
			} else {
				if (zDirIsPositive) {
					blockZ++;
				} else {
					blockZ--;
				}
			}
		}
		if (BasicFunctions.blockInArray(world.getBlockState(new BlockPos(blockX, playerY, blockZ)).getBlock(), illegalBlocks)) {
			fissureTime = -99;
			return;
		}
		if (world.isAirBlock(new BlockPos(blockX, playerY-1, blockZ)) && world.isAirBlock(new BlockPos(blockX, playerY-2, blockZ))) {
			fissureTime = -99;
			return;
		}
		if (world.isAirBlock(new BlockPos(blockX, playerY-1, blockZ))) {
			playerY--;
		}
		if (!world.isAirBlock(new BlockPos(blockX, playerY, blockZ)) && !BasicFunctions.blockInArray(world.getBlockState(new BlockPos(blockX, playerY, blockZ)).getBlock(), breakThroughBlocks)) {
			playerY++;
		}
		fissureEffect(world, new BlockPos(blockX, playerY, blockZ), -1);
	}
	
	private static void fissureEffect(World world, BlockPos pos, int getYMod) {
		Block block;
		int getXMod, getZMod;
		if (pos.getZ() % 2 == 0) {
			getZMod = 2;
			if (pos.getX() % 2 == 0) {
				getXMod = 2;
			} else {
				getXMod = -2;
			}
		} else {
			getZMod = -2;
			if (pos.getX() % 2 == 0) {
				getXMod = -2;
			} else {
				getXMod = 2;
			}
		}
		block = Blocks.AIR;
		for (int i = 0; i <= 3; i++) {
			block = world.getBlockState(new BlockPos(pos.getX() + getXMod, pos.getY() + getYMod, pos.getZ() + getZMod)).getBlock();
			if (block == Blocks.AIR || BasicFunctions.blockInArray(block, breakThroughBlocks) || BasicFunctions.blockInArray(block, illegalBlocks)) {
				switch (i) {
				case 0:
					getZMod = getZMod * -1;
					break;
				case 1:
					getXMod = getXMod * -1;
					break;
				case 2:
					getZMod = getZMod * -1;
					break;
				case 3:
					if (getYMod == -1) {
						fissureEffect(world, pos, -2);
					} else {
						fissureTime = -99;
						break;
					}
				}
			} else {
				break;
			}
		}
		if (fissureTime < 0) {
			return;
		}
		BlockPos toDel = new BlockPos(pos.getX() + getXMod, pos.getY() + getYMod, pos.getZ() + getZMod);
		IBlockState blockState = world.getBlockState(toDel);
		world.destroyBlock(toDel, false);
		world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), blockState);
		AxisAlignedBB radiusOfEffect = new AxisAlignedBB(pos.getX() - 2, pos.getY() - 1, pos.getZ() - 2, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
		List<Entity> affectedEntities = world.getEntitiesWithinAABB(Entity.class, radiusOfEffect);
		for (Entity e: affectedEntities) {
			if (e != (player)) {
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 12.0F);
			}
		}
	}
	
	public static void attemptFissure() {
		if (fissureTime >= 0) {
			doFissureTick();
			fissureTime++;
			if (fissureTime > 9) {
				fissureTime = -99;
			}
		}
	}
}
