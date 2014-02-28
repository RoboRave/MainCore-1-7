package com.modapi.main.api.Methods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public interface AddItemsAPI {
	
	void AddComplexItem(String InGameName,Item item,int MaxDamage,
			int MaxStackSize,CreativeTabs creativetab, String UnlocalizedName,String ModName);

	void AddSimpleItem(String InGameName,Item item,String UnlocalizedName,String ModName );
	
	void AddTestItem(String InGameName,String UnlocalizedName,String ModName);
}
