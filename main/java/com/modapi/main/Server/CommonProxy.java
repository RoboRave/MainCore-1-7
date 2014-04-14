package com.modapi.main.Server;

import org.apache.logging.log4j.Level;

import com.modapi.main.Mod_Api;

import cpw.mods.fml.common.Loader;

public class CommonProxy 
{
	
	
	public void preInit()
	{
		//findMods();
	}

	public void load() 
	{
	    
	}
	
	public void postInit()
	{
	   
	}
	@SuppressWarnings("static-access")
	public boolean findMod(String Mod, Boolean mod,String name){
		
		if(Loader.instance().isModLoaded(Mod)){
			return true;
		}
		if(mod==true)
		{
			Mod_Api.INSTANCE.logger.log(Level.INFO, Mod+" Is a mod");
			
		}
			else
		{
			Mod_Api.INSTANCE.logger.log(Level.INFO, "Lokking For Fake "+ Mod);
		}
		
		return mod;
		

	}
	
}
