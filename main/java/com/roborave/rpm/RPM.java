package com.roborave.rpm;

import com.modapi.main.api.Mod.Mod;
import com.modapi.main.mod.MOD;
import com.roborave.rpm.helper.MainLogger;

import cpw.mods.fml.common.API;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

//@cpw.mods.fml.common.Mod(modid = "RPM",name="RPM",version="0.1.0")
public class RPM implements Mod/*, /*MOD*/ {

	/*
	@Override
	public String name(String name) 
	{
		return "RPM";
	}
	@Override
	public int ID(int id) 
	{
		return 1;
	}
*/
	@cpw.mods.fml.common.Mod.Metadata()
	public ModMetadata meta;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) 
	{
		meta = event.getModMetadata();
		meta.modId="RPM";
		meta.name="RoboRaves Placer's Mod";
		meta.version="0.1.0";
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) 
	{

	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) 
	{
	
	}

}
