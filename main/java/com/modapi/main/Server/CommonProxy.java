package com.modapi.main.Server;

import java.util.HashMap;

import org.apache.logging.log4j.Level;

import com.modapi.main.Mod_Api;
import com.modapi.main.helper.LogHandler;
import com.modapi.main.mod.FML;

import cpw.mods.fml.common.Loader;

public class CommonProxy 
{
	
	public static HashMap Mods = new HashMap();
	
	public void preInit()
	{
		findMods();
	}

	public void load() 
	{
	    
	}
	
	public void postInit()
	{
	   
	}
	@SuppressWarnings("static-access")
	public boolean findMod(String Mod,Boolean mod,String name){
		
		if(Loader.instance().isModLoaded(Mod)){
			return true;
		}
		if(mod==true)
		{
			Mod_Api.INSTANCE.logger.log(Level.INFO, Mod+" Is a mod");
			
		}else{
			Mod_Api.INSTANCE.logger.log(Level.INFO, "Lokking For Fake "+ Mod);
		}
		
		return mod;
		

	}
	public  void RegisterMods()
	{
		new FML().register("FML");
	}
	public void findMods()
	{
			RegisterMods();
			LogHandler.log(Level.INFO, "loaded:"+CommonProxy.Mods.toString());
			
		}
	}
