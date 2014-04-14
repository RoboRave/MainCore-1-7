package mods.common.addon.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mods.common.logger.CoreLogger;

public class Loader
{
    /**
     * The state enum used to help track state progression for the loader
     * 
     * @author cpw
     * 
     */
    private enum State
    {
        NOINIT, LOADING, PREINIT, INIT, POSTINIT, UP, ERRORED
    }
    
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
     * The {@link State} of the loader
     */
    private State                  state;
    /**
     * The class loader we load the mods into.
     */
    /**
     * The sorted list of mods.
     */
    public List<Plugin>  mods;
    
    public static List<Plugin> getModList()
    {
        return Loader.instance().mods;
    }
    
    /**
     * Query if we know of a mod named modname
     * 
     * @param modname
     * @return true
     * 
     */
    public static boolean isModLoaded(String modname)
    {
        return instance().mods.contains(modname);
    }
    
    public void initializePlugins()
    {
    	CoreLogger.info("Loaded: "+ mods.toString());
    	
    	CoreLogger.info(String.format("Main-Core Loader load complete, %d plugins loaded", mods.size()));
    }

  
    public void loadPlugins()
    {
        mods = new ArrayList<Plugin>();

        // Make mod list immutable
      //  mods = Collections.unmodifiableList(mods);
    }
}