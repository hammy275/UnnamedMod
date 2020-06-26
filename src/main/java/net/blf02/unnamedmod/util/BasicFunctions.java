package net.blf02.unnamedmod.util;

import net.minecraft.block.Block;

public class BasicFunctions {
	
	public static boolean isStringInArray(String item, String[] array) {
		for (String i : array) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean blockInArray (Block block, Block[] array) {
		for (Block b : array) {
			if (b.equals(block)) {
				return true;
			}
		}
		return false;
	}
}
