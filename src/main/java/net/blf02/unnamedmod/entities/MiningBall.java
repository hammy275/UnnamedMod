package net.blf02.unnamedmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class MiningBall extends EntityLargeFireball {

	public MiningBall(World worldIn) {
		super(worldIn);
	}
	
	public MiningBall(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
	}
	
	@Override
	protected boolean isFireballFiery() {
		return false;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			for (double xMod = -1; xMod <= 1; xMod++) {
				for (double yMod = 0; yMod <= 2; yMod++) {
					for (double zMod = -1; zMod <=1; zMod++) {
						this.world.destroyBlock(new BlockPos(this.posX + xMod, this.posY + yMod, this.posZ + zMod), true);
					}
				}
			}
			this.setDead();
		}
	}

}
