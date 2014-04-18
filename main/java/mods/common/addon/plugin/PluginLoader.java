package mods.common.addon.plugin;

import mods.common.core.MainCore;
import mods.common.logger.CoreLogger;

/**
 * Handles detecting and loading Plugins.
 * 
 * @author RoboRave
 */
public class PluginLoader
{   
    /**
     * the Main way to add plugin to the PluginLoader
     * 
     * @author RoboRave
     * 
     * @param plugin the class of the plugin
     */
	public static void addPlugin(Plugin plugin)
    {

        plugin.preInit();
        if(MainCore.instance.dev==true)CoreLogger.info("Loaded Preinit for " + plugin.meta().name);
        
        plugin.init();
        if(MainCore.instance.dev==true)CoreLogger.info("Loaded Init for " + plugin.meta().name);
        
        plugin.postInit();
        if(MainCore.instance.dev==true)CoreLogger.info("Loaded Postinit for " + plugin.meta().name);
        
        Loader.instance().mods.add(plugin);
        
        Loader.instance().plugins.add(plugin.meta().name);
    }
}