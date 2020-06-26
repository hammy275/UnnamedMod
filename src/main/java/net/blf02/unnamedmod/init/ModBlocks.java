package net.blf02.unnamedmod.init;

import java.util.ArrayList;
import java.util.List;

import net.blf02.unnamedmod.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> Blocks = new ArrayList<Block>();
	
	public static final Block fristBlock = new BlockBase("frist_block", Material.IRON);
}
