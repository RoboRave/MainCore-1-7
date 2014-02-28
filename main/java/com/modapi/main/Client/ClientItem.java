package com.modapi.main.Client;

import com.modapi.main.api.Item.ItemBase;
import com.modapi.main.api.Methods.AddItemsAPI;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientItem implements AddItemsAPI{
	
	private static final ClientItem INSTANCE = new ClientItem();
	public Item Item2;
	public static ClientItem instance()
	{
		return INSTANCE;
	}
public void AddComplexItem(String InGameName,Item item,int MaxDamage,int MaxStackSize,CreativeTabs creativetab, String UnlocalizedName,String ModName){
		 item = new Item()
		.setFull3D()
		.setMaxDamage(MaxDamage)
		.setMaxStackSize(MaxStackSize)
		.setTextureName(ModName+":"+"Item_"+UnlocalizedName)
		.setUnlocalizedName("Item_"+InGameName+".name")
		.setCreativeTab(creativetab);
		
	}

public void AddSimpleItem(String InGameName, Item item,String UnlocalizedName,String ModName ){
		 item= new Item()
		.setFull3D()
		.setTextureName(ModName+":"+"UnlocalizedName")
		.setUnlocalizedName(UnlocalizedName)
		.setCreativeTab(CreativeTabs.tabMaterials);
		Registry(item, InGameName, UnlocalizedName, ModName);
		
	}
public void AddTestItem(String InGameName, String UnlocalizedName,String ModName){
	Item item = new Item()
	.setFull3D()
	.setTextureName(ModName+":"+UnlocalizedName)
	.setUnlocalizedName("item."+UnlocalizedName+".name")
	.setCreativeTab(CreativeTabs.tabMaterials);
	Registry(item, InGameName, UnlocalizedName, ModName);
	
}

public ClientItem Registry(Item item, String name, String UnlocalizedName,String ModName){
	
	GameRegistry.registerItem(item, "item."+UnlocalizedName.replace(" ", "_")+".name",ModName);
	return this;
	
}
//////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------------------------------------------------------//
//-------------------------------------ITEM MANAGER-------------------------------------//
//--------------------------------------------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////

}
