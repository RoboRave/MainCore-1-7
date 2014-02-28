package com.modapi.main.api.Mod;

import java.util.HashMap;

public class ModName {
	private static HashMap<String, ModVersion> instances = new HashMap<String, ModVersion>();

	public static String toVersionString(String modId) {
		if (modId == null || !instances.containsKey(modId))
			return "1.0";
		return modId;
}
}
