package mods.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Some forge config utilities
 */
public class ConfigManager
{
    
    /**
     * The configuration instance
     */
    public static Configuration config = new Configuration();
    
    /**
     * Creates the config file itself
     * 
     * @param event
     *            The event used to get the directory
     * @param dir
     *            The sub-directory
     * @param modidName
     *            The mod id to name the config
     */
    public static void CreateConfig(FMLPreInitializationEvent event, String dir, String modidName)
    {
        config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + dir + File.separator + modidName + ".cfg"));
    }
    
    /**
     * 
     * @param category category of config
     * 
     * @param key String for What it is called in the file
     * 
     * @param b string for default
     * 
     * @param comment 
     */
    @SuppressWarnings("javadoc")
	public static Property get(String category, String key, boolean b, String comment)
    {
        return config.get(category, key, b, comment);
    }
   /**
    * 
    * @param category category of config
    * 
    * @param key String for What it is called in the file
    * 
    * @param defaultValue string for default
    * 
    * @param comment 
    */
    @SuppressWarnings("javadoc")
    public static Property get(String category, String key, String defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment);
    }
}
