package net.blf02.unnamedmod.items.armor;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.init.ModCreativeTabs;
import net.blf02.unnamedmod.init.ModItems;
import net.blf02.unnamedmod.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
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
