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
	
	//Regular Items
	public static final Item fristItem = new ItemBase("frist_item");
	
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