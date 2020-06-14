package net.blf02.unnamedmod.init;

import java.util.ArrayList;
import java.util.List;

import net.blf02.unnamedmod.UnnamedMod;
import net.blf02.unnamedmod.items.ItemBase;
import net.blf02.unnamedmod.items.armor.ArmorBase;
import net.blf02.unnamedmod.items.tools.ToolAxe;
import net.blf02.unnamedmod.items.tools.ToolHoe;
import net.blf02.unnamedmod.items.tools.ToolPickaxe;
import net.blf02.unnamedmod.items.tools.ToolSpade;
import net.blf02.unnamedmod.items.tools.ToolSword;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> Items = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial fristMaterial = EnumHelper.addToolMaterial("frist_material", 3, 32768, 16.0F, 996.0F, 33);
	public static final ArmorMaterial fristArmorMaterial = EnumHelper.addArmorMaterial("frist_armor_material", UnnamedMod.MODID + ":" + "frist", 99, new int[]{8, 10, 12, 8}, 33, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 10.0F);
	
	//Regular Items
	public static final Item fristItem = new ItemBase("frist_item");
	
	//Initialize Extra Stuff (called before registering items)
	public static void init() {
		System.out.println("UnnamedMod out here adding some tools and armor");
		addToolItems("frist", fristMaterial, 2000.0F, -3.9F);
		addArmorItems("frist", fristArmorMaterial);
		
	}
	
	private static void addToolItems(String namePrefix, ToolMaterial material, float axeDamage, float axeSpeedModifier) {
		Items.add(new ToolSword(namePrefix + "_" + "sword", material));
		Items.add(new ToolPickaxe(namePrefix + "_" + "pickaxe", material));
		Items.add(new ToolAxe(namePrefix + "_" + "axe", material, axeDamage, axeSpeedModifier));
		Items.add(new ToolSpade(namePrefix + "_" + "shovel", material));
		Items.add(new ToolHoe(namePrefix + "_" + "hoe", material));
	}
	
	private static void addArmorItems(String namePrefix, ArmorMaterial material) {
		Items.add(new ArmorBase(namePrefix + "_" + "helmet", material, 1, EntityEquipmentSlot.HEAD));
		Items.add(new ArmorBase(namePrefix + "_" + "chestplate", material, 1, EntityEquipmentSlot.CHEST));
		Items.add(new ArmorBase(namePrefix + "_" + "leggings", material, 2, EntityEquipmentSlot.LEGS));
		Items.add(new ArmorBase(namePrefix + "_" + "boots", material, 1, EntityEquipmentSlot.FEET));
	}
	
	//Tools
	//public static final ItemSword fristSword = new ToolSword("frist_sword", fristMaterial);
	//public static final ItemPickaxe fristPickaxe = new ToolPickaxe("frist_pickaxe", fristMaterial);
	//public static final ItemSpade fristSpade = new ToolSpade("frist_shovel", fristMaterial);
	//public static final ItemHoe fristHoe = new ToolHoe("frist_hoe", fristMaterial);
	//public static final ItemAxe fristAxe = new ToolAxe("frist_axe", fristMaterial, 2000.0F, -3.9F);
	
	//Armor
	//public static final Item fristHelmet = new ArmorBase("frist_helmet", fristArmorMaterial, 1, EntityEquipmentSlot.HEAD);
	//public static final Item fristChestplate= new ArmorBase("frist_chestplate", fristArmorMaterial, 1, EntityEquipmentSlot.CHEST);
	//public static final Item fristLeggings = new ArmorBase("frist_leggings", fristArmorMaterial, 2, EntityEquipmentSlot.LEGS);
	//public static final Item fristBoots = new ArmorBase("frist_boots", fristArmorMaterial, 1, EntityEquipmentSlot.FEET);

}
