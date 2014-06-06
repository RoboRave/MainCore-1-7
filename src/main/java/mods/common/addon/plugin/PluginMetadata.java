package mods.common.addon.plugin;

import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 *
 */
public class PluginMetadata
{
    /**
     * name of plugin
     */
    public static String name;
    /**
     * description of plugin
     */
    public String description;
	/**
	 * version of plugin
	 */
	public static String version;
    
    /**
     * @param clazz the class
     */
    public PluginMetadata(Class<? extends Plugin> clazz)
    {
        name = clazz.getAnnotation(Info.class).name();
        version = clazz.getAnnotation(Info.class).version();
    }
   
}
