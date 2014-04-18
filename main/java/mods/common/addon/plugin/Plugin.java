package mods.common.addon.plugin;


/**
 * @author RoboRave
 * 
 */

public interface Plugin
{

    /**
     * Called when pre-initialization occurs.
     */
    void preInit();
    
    /**
     * Called when main initialization occurs.
     */
    void init();
    
    /**
     * Called when post-initialization occurs.
     */
    void postInit();
    
    PluginMetadata meta();

	String desc();
    
}