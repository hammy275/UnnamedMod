package net.blf02.unnamedmod.util.handlers;

import net.blf02.unnamedmod.init.ModBlocks;
import net.blf02.unnamedmod.init.ModItems;
import net.blf02.unnamedmod.init.ModToolsArmor;
import net.blf02.unnamedmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModToolsArmor.init();
		event.getRegistry().registerAll(ModItems.Items.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.Blocks.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ModItems.Items) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for (Block block : ModBlocks.Blocks) {
			if (block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
}
