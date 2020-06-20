package net.blf02.unnamedmod.util;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class ClonedVanillaFunctions {
	//This mainly contains re-implementations of functions that are client-side only.
	
	@Nullable
	public static RayTraceResult rayTrace(Entity entity, double blockReachDistance, float partialTicks)
    {
        Vec3d vec3d = entity.getPositionEyes(partialTicks);
        Vec3d vec3d1 = entity.getLook(partialTicks);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return entity.world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

}
