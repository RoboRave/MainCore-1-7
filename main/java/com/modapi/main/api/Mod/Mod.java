package com.modapi.main.api.Mod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public interface Mod {

	@EventHandler
	public abstract void PreInit(FMLPreInitializationEvent event);
	
	@EventHandler
	public abstract void Init(FMLInitializationEvent event);
	
	@EventHandler
	public abstract void PostInit(FMLPostInitializationEvent event);
}
