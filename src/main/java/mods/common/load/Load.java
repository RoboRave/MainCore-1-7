package mods.common.load;

import mods.common.addon.load.AddonPlugin;
import mods.common.addon.plugin.PluginLoader;
import mods.common.addon.plugin.main.CoreAPIPlugin;
import mods.common.addon.plugin.main.ModLoaderPlugin;
import mods.common.addon.plugin.main.RPMPlugin;
import mods.common.logger.CoreLogger;
import cpw.mods.fml.common.Loader;


public class Load {
	
	
	public static final String MainCore="MainCore";
	

	public static void Mods() throws InstantiationException, IllegalAccessException
	{
		if(Loader.isModLoaded("CoreAPI"))
		{
			PluginLoader.addPlugin(CoreAPIPlugin.class);
		}
		
		if(Loader.isModLoaded("Core-Addon"))
		{
			PluginLoader.addPlugin(AddonPlugin.class);
		}
		
		if(Loader.isModLoaded("RPM"))
		{
			PluginLoader.addPlugin(RPMPlugin.class);
		}
		
		PluginLoader.addPlugin(ModLoaderPlugin.class);
		
	}
	
}
