package net.blf02.unnamedmod.items;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.init.ModCreativeTabs;
import net.blf02.unnamedmod.init.ModItems;
import net.blf02.unnamedmod.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTabs.fristTab);
		
		ModItems.Items.add(this);
	}
	
	@Override
	public void registerModels() {
		UnnamedMod.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
