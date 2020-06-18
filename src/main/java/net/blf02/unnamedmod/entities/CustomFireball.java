package net.blf02.unnamedmod.entities;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomFireball extends EntityLargeFireball {
	
	EnumParticleTypes[] particles = new EnumParticleTypes[] {EnumParticleTypes.ENCHANTMENT_TABLE, EnumParticleTypes.CRIT_MAGIC};
	
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
				 result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 2000.0F);
                 this.applyEnchantments(this.shootingEntity, result.entityHit);
			 }
		}
		super.onImpact(result);
	}
	
	@Override
	protected boolean isFireballFiery() {
		return false;
	}
	
	@Override
	protected EnumParticleTypes getParticleType()
    {
        return particles[new Random().nextInt(particles.length)];
    }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return false;
	}
	

}
