package mods.common.addon.plugin;

/**
 * Handles detecting and loading Plugins.
 * @author RoboRave
 */
public class PluginLoader
{
    public static long i = 110;
    /**
     * @author Zach
     * @param e
     */
    public static void addPlugin(Plugin e)
    {
        e.preInit();
        
        e.init();
        
        e.postInit();
 
        Loader.instance().mods.add(e);
    }
}