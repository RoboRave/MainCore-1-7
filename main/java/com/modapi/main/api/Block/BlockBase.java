package com.modapi.main.api.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockBase extends Block
{
	public String ingamename = "";
	
	@SuppressWarnings("static-access")
	int IDDropped = this.getIdFromBlock(this);
	
	int amountdropped=1;
	
	int xpdropped=0;
	
	public String harvesttool="";
	
	public int harvestlevel = 0;
	
	boolean opaquecube = true;
	
	public BlockBase(Material material)
	{
		super(material);
	}
	
	
	public BlockBase setNonOpaqueCube()
	{
		this.opaquecube=false;
		return this;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return this.opaquecube;
	}
	
	public BlockBase setXpDropped(int amount)
	{
		this.xpdropped=amount;
		return this;
	}
	
	public BlockBase setInGameName(String name)
	{
		this.ingamename=name;
		return this;
	}
	
	public void setHarvestLevel(String tool, int level)
	{
		this.harvesttool=tool;
		this.harvestlevel=level;
	}
	
	public BlockBase setIdDropped(int id)
	{
		this.IDDropped=id;
		return this;
	}
	
	public BlockBase setQuantityDropped(int amount)
	{
		this.amountdropped=amount;
		return this;
	}
	
	@Override
	public int quantityDropped(Random par1Random)
    {
        return this.amountdropped;
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5)
	{
		dropXpOnBlockBreak(world, x, y, z, this.xpdropped);
	}
}