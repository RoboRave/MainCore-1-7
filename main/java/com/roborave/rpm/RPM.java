package com.roborave.rpm;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

import com.modapi.main.api.Mod.Mod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@cpw.mods.fml.common.Mod(modid = "RPM",name="RPM",version="0.1.0")
@Info(name = "RPM", version = "0.1.0")
public class RPM implements Mod, Plugin {

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

	@Override
	public void preInit() 
	{

	}

	@Override
	public void init() 
	{
		
	}

	@Override
	public void postInit() 
	{
	
	}

	@Override
	public PluginMetadata meta() 
	{
		return new PluginMetadata(this.getClass());
	}

	@Override
	public String desc() 
	{
		return "there is no Description!!";
	}

}
