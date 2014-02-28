package com.modapi.main.Client;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.modapi.main.api.Block.BlockBase;
import com.modapi.main.api.Methods.AddBlocksAPI;

import cpw.mods.fml.common.registry.GameRegistry;

public class ClientBlock implements AddBlocksAPI {
	private static final ClientBlock INSTANCE = new ClientBlock();
	//private Block block;
	public static ClientBlock instance()
	{
		return INSTANCE;
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	//---------------------------------------------------------------------------------------//
	//-------------------------------------BLOCK MANAGER-------------------------------------//
	//---------------------------------------------------------------------------------------//
	///////////////////////////////////////////////////////////////////////////////////////////
	public static Material getMaterial(int id)
	{
		if (id == 0)
			return Material.air;
		if (id == 1)
			return Material.ground;
		if (id == 2)
			return Material.rock;
		if (id == 3)
			return Material.grass;
		if (id == 4)
			return Material.wood;
		if (id == 5)
			return Material.cloth;
		if (id == 6)
			return Material.iron;
		return Material.rock;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void AddCustomBlock(String name ,String InGameName, int ID ,Block block,
			int material ,int Hardness, int Resistance,int Lightvalue,
			String modname, CreativeTabs creative){
		 block = new BlockBase(getMaterial(material))
		 .setHardness(Hardness)
		 .setResistance(Resistance)
		 .setBlockTextureName(modname+":" + name)
		 .setBlockName(name)
		 .setCreativeTab(CreativeTabs.tabBlock)
		 .setLightOpacity(Lightvalue);
		Registry(block, InGameName, name);
	}
	@Override
	public void AddComplexBlock(String InGameName, int ID ,Material material,Block block,
			int Hardness, int Resistance, CreativeTabs creativetab, String Unlocalizedname, String modname){

		 block = new BlockBase(Material.rock)
		 .setHardness(Hardness)
		 .setResistance(Resistance)
		 .setBlockTextureName(modname+":"+Unlocalizedname)
		 .setBlockName(InGameName)
		 .setCreativeTab(creativetab);
		Registry(block, InGameName, Unlocalizedname);
		
	}
	@Override
	public void AddSimpleBlock(String InGameName, int ID ,String Unlocalizedname,String TextureName){
         final Block block;
		 block = new BlockBase(Material.rock)
		 .setHardness(10)
		 .setResistance(10)
		 .setBlockTextureName(TextureName)
		 .setBlockName(Unlocalizedname)
		 .setCreativeTab(CreativeTabs.tabBlock);
		 Registry(block, InGameName, Unlocalizedname);
		
	}
	public ClientBlock Registry(Block block, String name, String UnlocalizedName){
		
		GameRegistry.registerBlock(block, "tile."+UnlocalizedName+".name");

		return this;
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////
	//---------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------//
	//---------------------------------------------------------------------------------------//
	///////////////////////////////////////////////////////////////////////////////////////////
}
