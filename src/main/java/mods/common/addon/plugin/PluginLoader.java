package mods.common.addon.plugin;

import mods.common.core.MainCore;
import mods.common.logger.CoreLogger;
import mods.common.util.CommonUtils;

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
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
	@SuppressWarnings("static-access")
	public static void addPlugin(Class<?extends Plugin> plugin) throws InstantiationException, IllegalAccessException
    {

		//if(plugin.getClass().getAnnotation(PreInit.class) != null)
		//{
			plugin.newInstance().preInit();
			if(MainCore.instance.dev==true&&CommonUtils.isObfuscatedEnv())	CoreLogger.info("Loaded Preinit for " + plugin.newInstance().meta().name);
		//}
        
        
        //if(plugin.getClass().isAnnotationPresent(Init.class)) 
		//{
			plugin.newInstance().init();
        	if(MainCore.instance.dev==true&&CommonUtils.isObfuscatedEnv())	CoreLogger.info("Loaded Init for " + plugin.newInstance().meta().name);
        //}
       
        
       // if(plugin.getClass().isAnnotationPresent(PostInit.class))
       // {
        	plugin.newInstance().postInit();
        	if(MainCore.instance.dev==true&&CommonUtils.isObfuscatedEnv())CoreLogger.info("Loaded Postinit for " + plugin.newInstance().meta().name);
       // }
                
        Loader.instance().mods.add(plugin);
        
        Loader.instance().plugins.add(plugin.newInstance().meta().name);
    }
}