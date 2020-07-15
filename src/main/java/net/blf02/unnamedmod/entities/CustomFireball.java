package net.blf02.unnamedmod.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomFireball extends EntityLargeFireball {
	
	public CustomFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
	}
	
	public CustomFireball(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			 if (result.entityHit != null) {
				 result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F);
                 this.applyEnchantments(this.shootingEntity, result.entityHit);
			 }
		}
		super.onImpact(result);
	}
	
	@Override
	protected boolean isFireballFiery() {
		return true;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}
	

}
