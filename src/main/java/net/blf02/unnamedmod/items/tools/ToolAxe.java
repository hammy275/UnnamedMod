package net.blf02.unnamedmod.items.tools;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.init.ModCreativeTabs;
import net.blf02.unnamedmod.init.ModItems;
import net.blf02.unnamedmod.util.IHasModel;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {
	public ToolAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
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
