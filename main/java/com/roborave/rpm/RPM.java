package com.roborave.rpm;

import com.roborave.rpm.init.Items;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@cpw.mods.fml.common.Mod(modid = "RPM",name="RPM",version="0.1.0")
public class RPM {

	@Instance
	public RPM instance;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) 
	{
		ModMetadata meta = event.getModMetadata();
		meta.modId="RPM";
		meta.name="RoboRaves Placer's Mod";
		meta.version="0.1.0";
		Items.init();
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
