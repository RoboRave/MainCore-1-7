package mods.common.addon.plugin;

import mods.common.addon.plugin.common.Info;

public class PluginMetadata
{
    public static String name;
    public String description;
	public static String version;
    
    public PluginMetadata(Class<? extends Plugin> clazz)
    {
        name = clazz.getAnnotation(Info.class).name();
        version = clazz.getAnnotation(Info.class).version();
    }
   
}
