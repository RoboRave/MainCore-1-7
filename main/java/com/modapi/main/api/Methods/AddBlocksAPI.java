package com.modapi.main.api.Methods;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public interface AddBlocksAPI {

	void AddSimpleBlock(String InGameName, int ID ,String Unlocalizedname,String TextureName);
	
	void AddCustomBlock(String name ,String InGameName, int ID ,Block block, 
			int material ,int Hardness, int Resistance,int Lightvalue,
			String modname, CreativeTabs creative);
	
	void AddComplexBlock(String InGameName, int ID ,Material material,Block block,
			int Hardness, int Resistance, CreativeTabs creativetab, String Unlocalizedname,String modname);
}
