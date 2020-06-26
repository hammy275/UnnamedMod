package net.blf02.unnamedmod.init;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.entities.CustomFireball;
import net.blf02.unnamedmod.entities.MiningBall;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	private static int id = 783;
	
	public static void init() {
		registerEntityNoEgg("magic_fireball", CustomFireball.class);
		registerEntityNoEgg("mining_ball", MiningBall.class);
	}
	
	private static void registerEntityNoEgg(String name, Class<? extends Entity> entityClass) {
		EntityRegistry.registerModEntity(new ResourceLocation(UnnamedMod.MODID + ":" + name), entityClass, name, ++id, UnnamedMod.instance, 50, 1, true);
	}

}
