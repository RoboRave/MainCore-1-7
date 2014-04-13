package mods.common.addon.mod;

import java.util.Arrays;

import org.apache.logging.log4j.Level;

import mods.common.addon.lib.LogHelper;
import mods.common.addon.load.Addons;
import mods.common.library.Library;
import mods.common.load.Load;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

//@Mod(modid = "Core-Addon",version="0.4.1 Patch",name="Core Addon",dependencies="required-after:MainCore@[1.1.5.5,)")

public class CoreAddon {

		@EventHandler
		public void preInit(FMLPreInitializationEvent event) {
			ModMetadata meta = event.getModMetadata();
			meta.autogenerated = false;
			meta.credits = "(C) Roborave, 2014";
			meta.authorList = Arrays.asList("Roborave");
			meta.name = "Core-Addon";
			meta.version = "0.4.1 Patch";
			//meta.description = "This the core for all my mods.";
			meta.parent ="MainCore";
			
			LogHelper.init();
		}
		
	    @EventHandler
		public static void init(FMLInitializationEvent event)
		{
	    	Addons.LoadGG();
	    	LogHelper.log(Level.INFO, "Core-Addon"+ " "+ "Loaded!! for minecraft 1.7.2");
		}
		
}
