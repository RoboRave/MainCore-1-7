package mods.common.load;

import com.roborave.rpm.plugin.RPMPlugin;

import mods.common.addon.load.AddonPlugin;
import mods.common.addon.plugin.PluginLoader;
import mods.common.addon.plugin.main.CoreAPIPlugin;
import mods.common.addon.plugin.main.ModLoaderPlugin;
import mods.common.logger.CoreLogger;
import cpw.mods.fml.common.Loader;


public class Load {
	
	
	public static final String MainCore="MainCore";
	

	public static void Mods()
	{
		if(Loader.isModLoaded("CoreAPI"))
		{
			PluginLoader.addPlugin(new CoreAPIPlugin());
		}
		
		if(Loader.isModLoaded("Core-Addon"))
		{
			PluginLoader.addPlugin(new AddonPlugin());
		}
		
		if(Loader.isModLoaded("RPM"))
		{
			PluginLoader.addPlugin(new RPMPlugin());
		}
		
		PluginLoader.addPlugin(new ModLoaderPlugin());
		
	}
	
}
