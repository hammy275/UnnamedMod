package net.blf02.unnamedmod.items.tools;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.init.ModItems;
import net.blf02.unnamedmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		ModItems.Items.add(this);
	}
	
	@Override
	public void registerModels() {
		UnnamedMod.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
