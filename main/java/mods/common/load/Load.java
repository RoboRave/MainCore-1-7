package mods.common.load;

import mods.common.addon.load.AddonPlugin;
import mods.common.addon.plugin.PluginLoader;
import mods.common.addon.plugin.main.CoreAPIPlugin;
import mods.common.addon.plugin.main.ModLoaderPlugin;
import mods.common.logger.CoreLogger;
import cpw.mods.fml.common.Loader;


public class Load {
	
	
	public static void Mods()
	{
		if(Loader.isModLoaded("CoreAPI"))
		{
			PluginLoader.addPlugin(new CoreAPIPlugin());
			CoreLogger.info("Loaded: "+"Core-API");
		}
		
		if(Loader.isModLoaded("Core-Addon"))
		{
			PluginLoader.addPlugin(new AddonPlugin());
			CoreLogger.info("Loaded: "+"Core-Addon");
		}
		PluginLoader.addPlugin(new ModLoaderPlugin());
		
	}
	
}
