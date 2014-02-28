package com.modapi.main.mod;

import java.util.ArrayList;

import com.modapi.main.Server.CommonProxy;


public class MODClass implements MOD {
	public static ArrayList[] IDArray = new ArrayList[40];
	
	public int ID;
	private String name;
	
	@Override
	public String name(String name) 
	{
		name=this.name;
		return name;
	}
	
	@Override
	public int ID(int id) 
	{
		return id = this.ID;
	}
	
	public MODClass register(Object Class)
	{
		CommonProxy.Mods.put(Class,this.ID);
		return this;
	}

	

}
