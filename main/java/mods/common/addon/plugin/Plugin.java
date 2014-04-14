package mods.common.addon.plugin;

import java.io.File;
import java.util.List;

/**
 * @author RoboRAve
 * 
 **/

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