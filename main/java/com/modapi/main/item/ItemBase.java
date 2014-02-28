package com.modapi.main.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBase extends Item
{
	public String ingamename="";
	
	public ItemBase()
	{
		super();
	}
	
	public ItemBase setInGameName(String name)
	{
		this.ingamename=name;
		return this;
	}
	
	public ItemBase setTextureFile(String texture)
	{
		this.registerIcons(null, texture);
		return this;
	}
	  @SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister par1IconRegister, String Name)
	    {
	        this.itemIcon = par1IconRegister.registerIcon( Name + ":" + (this.getUnlocalizedName().substring(5)));
	    }
}
