package com.roborave.rpm.init;

import net.minecraft.item.Item;

import com.modapi.main.Client.ClientItem;

public class Items {

	private static Item Item;

	public static void init()
	{
		ClientItem.instance().AddSimpleItem("Test", Item, "Test1","EDM");
	}
}
