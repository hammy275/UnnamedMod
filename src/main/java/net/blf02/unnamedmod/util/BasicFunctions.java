package net.blf02.unnamedmod.util;

public class BasicFunctions {
	
	public static boolean isStringInArray(String item, String[] array) {
		for (String i : array) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}

}
