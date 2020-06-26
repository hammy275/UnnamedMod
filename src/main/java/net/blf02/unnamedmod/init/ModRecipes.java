package net.blf02.unnamedmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.fristBlock, new ItemStack(Items.DIAMOND, 2), 2.5f);
	}
}
