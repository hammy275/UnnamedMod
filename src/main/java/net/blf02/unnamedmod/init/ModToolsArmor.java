package net.blf02.unnamedmod.init;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.items.armor.ArmorBase;
import net.blf02.unnamedmod.items.tools.FristAxe;
import net.blf02.unnamedmod.items.tools.FristPickaxe;
import net.blf02.unnamedmod.items.tools.FristSword;
import net.blf02.unnamedmod.items.tools.ToolAxe;
import net.blf02.unnamedmod.items.tools.ToolHoe;
import net.blf02.unnamedmod.items.tools.ToolPickaxe;
import net.blf02.unnamedmod.items.tools.ToolSpade;
import net.blf02.unnamedmod.items.tools.ToolSword;
import net.blf02.unnamedmod.util.BasicFunctions;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolsArmor {
	
	//Materials
	public static final ToolMaterial fristMaterial = EnumHelper.addToolMaterial("frist_material", 6, 32768, 16.0F, 996.0F, 33);
	public static final ArmorMaterial fristArmorMaterial = EnumHelper.addArmorMaterial("frist_armor_material", UnnamedMod.MODID + ":" + "frist", 99, new int[]{8, 10, 12, 8}, 33, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 10.0F);
	
	
	//Initialize Extra Stuff (called before registering items)
	public static void init() {
		System.out.println("UnnamedMod out here adding some tools and armor");
		
		new FristSword("frist_sword", fristMaterial);
		new FristPickaxe("frist_pickaxe", fristMaterial);
		new FristAxe("frist_axe", fristMaterial, 2000.0F, -3.9F);
		
		addToolItems("frist", fristMaterial, 2000.0F, -3.9F, new String[] {"sword", "pickaxe", "axe"});
		addArmorItems("frist", fristArmorMaterial);
		
	}
		
	private static void addToolItems(String namePrefix, ToolMaterial material, float axeDamage, float axeSpeedModifier, String[] itemsToSkip) {
		if (!BasicFunctions.isStringInArray("sword", itemsToSkip)) {
			ModItems.Items.add(new ToolSword(namePrefix + "_" + "sword", material));
		}
		if (!BasicFunctions.isStringInArray("pickaxe", itemsToSkip)) {
			ModItems.Items.add(new ToolPickaxe(namePrefix + "_" + "pickaxe", material));
		}
		if (!BasicFunctions.isStringInArray("axe", itemsToSkip)) {
			ModItems.Items.add(new ToolAxe(namePrefix + "_" + "axe", material, axeDamage, axeSpeedModifier));
		}
		if (!BasicFunctions.isStringInArray("shovel", itemsToSkip)) {
			ModItems.Items.add(new ToolSpade(namePrefix + "_" + "shovel", material));
		}
		if (!BasicFunctions.isStringInArray("hoe", itemsToSkip)) {
			ModItems.Items.add(new ToolHoe(namePrefix + "_" + "hoe", material));
		}
		
	}
	
	private static void addArmorItems(String namePrefix, ArmorMaterial material) {
		ModItems.Items.add(new ArmorBase(namePrefix + "_" + "helmet", material, 1, EntityEquipmentSlot.HEAD));
		ModItems.Items.add(new ArmorBase(namePrefix + "_" + "chestplate", material, 1, EntityEquipmentSlot.CHEST));
		ModItems.Items.add(new ArmorBase(namePrefix + "_" + "leggings", material, 2, EntityEquipmentSlot.LEGS));
		ModItems.Items.add(new ArmorBase(namePrefix + "_" + "boots", material, 1, EntityEquipmentSlot.FEET));
	}

}
