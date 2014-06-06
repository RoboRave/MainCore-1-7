package mods.common.addon.plugin;

import java.util.ArrayList;
import java.util.List;

import mods.common.logger.CoreLogger;

public class Loader
{
    /**
     * The singleton instance
     */
    private static Loader          instance;
	
    
    public static Loader instance()
    {
        if (instance == null)
        {
            instance = new Loader();
            
        }
        
        return instance;
    }
    /**
     * The sorted list of mods.
     */
    public List<Class<?extends Plugin>>  mods;
    public List<String> plugins;
    
    public static List<Class<? extends Plugin>> getModList()
    {
        return Loader.instance().mods;
    }
    
    /**
     * Query if we know of a mod named modname
     * 
     * @param modname
     * @return true or false
     * 
     */
    public static boolean isModLoaded(String modname)
    {
        return instance().mods.contains(modname);
    }
    
    public void initializePlugins()
    {
    	CoreLogger.info("Loaded: "+ this.plugins.toString());
    	
    	CoreLogger.info(String.format("Plugin Loader load complete, %d plugins loaded", this.mods.size()));
    }

  
    public void loadPlugins()
    {
        this.mods = new ArrayList<Class<?extends Plugin>>();
        this.plugins= new ArrayList<String>();
    }
}