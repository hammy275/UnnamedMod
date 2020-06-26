package net.blf02.unnamedmod.items.powers;

import java.util.List;

import net.blf02.unnamedmod.items.ItemBase;
import net.blf02.unnamedmod.util.BasicFunctions;
import net.blf02.unnamedmod.util.ClonedVanillaFunctions;
import net.minecraft.block.Block;
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
		if (!world.isAirBlock(new BlockPos(playerX, playerY - 1, playerZ))) {
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
			if (world.isAirBlock(new BlockPos(blockX, playerY-1, blockZ))) {
				fissureTime = -99;
			}
			fissureEffect(world, new BlockPos(blockX, playerY, blockZ));
		} else {
			fissureTime = -99;
		}
	}
	
	private static void fissureEffect(World world, BlockPos pos) {
		Block block;
		Block[] legalCloneBlocks = {Blocks.STONE, Blocks.DIRT, Blocks.COBBLESTONE, Blocks.LEAVES, Blocks.LEAVES2, Blocks.GRAVEL, Blocks.SAND, Blocks.SANDSTONE};
		Block[] legalBreakBlocks = {Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.TORCH, Blocks.REDSTONE_TORCH, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.TALLGRASS, Blocks.DEADBUSH, Blocks.REDSTONE_WIRE, Blocks.SAPLING};
		Block blockCheckBelow = world.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ())).getBlock();
		Block blockCheck = world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock();
		if (BasicFunctions.blockInArray(blockCheck, legalBreakBlocks)) {
			world.destroyBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), true);
		}
		else {
			if (!BasicFunctions.blockInArray(blockCheck, legalCloneBlocks) && !world.isAirBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ()))) {
				return;
			}
		}
		if (BasicFunctions.blockInArray(blockCheckBelow, legalCloneBlocks)) {
			block = blockCheckBelow;
		}
		else if (pos.getY() > 60) {
			block = Blocks.DIRT;
		} else {
			block = Blocks.STONE;
		}
		world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), block.getDefaultState());
		AxisAlignedBB radiusOfEffect = new AxisAlignedBB(pos.getX() - 2, pos.getY() - 1, pos.getZ() - 2, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
		List<Entity> affectedEntities = world.getEntitiesWithinAABB(Entity.class, radiusOfEffect);
		for (Entity e: affectedEntities) {
			if (e != (player)) {
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 999.0F);
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
