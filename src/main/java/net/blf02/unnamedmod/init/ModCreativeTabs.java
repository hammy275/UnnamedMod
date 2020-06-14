package net.blf02.unnamedmod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs {
	
	public static final CreativeTabs fristTab = (new CreativeTabs("frist_tab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.fristItem);
		}
		
	});

}
