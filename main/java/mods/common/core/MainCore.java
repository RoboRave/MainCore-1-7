package mods.common.core;

import java.io.File;
import java.util.Arrays;

import org.apache.logging.log4j.Level;

import mods.common.addon.plugin.Loader;
import mods.common.config.ConfigManager;
import mods.common.config.MCConfiguration;
import mods.common.dedicated.DedicatedServerProxy;
import mods.common.library.Library;
import mods.common.load.Load;
import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;
import mods.common.util.Const;
import mods.common.util.ModVersionChecker;
import net.minecraft.util.Session;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

	@Mod(modid = Library.modid,name=Library.name,version= Library.versions,guiFactory="mods.client.gui.GuiFactoryHandler")
	public class MainCore extends DummyModContainer {
		
		  
		
		@Metadata(value = "MainCore")
		public static ModMetadata   metadata;
		
		@Instance("MainCore")
		public static MainCore instance;
	
		@SidedProxy
		(
			clientSide="mods.common.client.CombinedClientProxy", 
			serverSide="mods.common.dedicated.DedicatedServerProxy"
		)
		public static CommonProxy proxy;
		
		public String actualMCVersion = Const.MCVERSION;
	
		private String Plugin="PluginLoader";
		public boolean plugin;

		  public final String         allowUpdateCheckDesc          = "Set to true to allow checking for updates for ALL of my mods, false to disable";
		    public boolean              allowUpdateCheck              = true;
		    public final String         allowDebugOutputDesc          = "";
		    public boolean              allowDebugOutput              = false;
		    public final String         updateTimeoutMillisecondsDesc = "The timeout in milliseconds for the version update check.";
		    public int                  updateTimeoutMilliseconds     = 3000;
		    public final String         generateUniqueNamesFileDesc   = "When true a file called UniqueNames.txt will be generated in the config folder for convenience. \n" +
		                                                                      "The names found in the file are the string representation of blocks and items in Minecraft.\n" +
		                                                                      "Mods such as Treecapitator and StartingInventory use them in their config files since IDs are gone.";
		    public boolean              generateUniqueNamesFile       = true;
		
		    protected ModVersionChecker versionChecker;
		    private final String        versionURL                    = Const.VERSION_URL + "/minecraft/" + "mods/MainCore/"+ Const.MCVERSION + "/"+Const.MCVERSION+".version";
		    private final String        mcfTopic                      = "http://www.minecraftforum.net/topic/1114612-";
		    
		    public MCConfiguration      config;

		public MainCore() 
		{
		
		}
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) 
		{
			metadata = event.getModMetadata();
			metadata.autogenerated = false;
			metadata.credits = "(C) Roborave, 2013-2014";
			metadata.authorList = Arrays.asList("Roborave");
			metadata.name = Library.name;
			metadata.version = Library.versions;
			metadata.description = "This the core for all my mods.";
			
			File file = new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "MainCore" + File.separator + metadata.name+ ".txt");
			
			config = new MCConfiguration(file);
			syncConfig();
			 ConfigManager.CreateConfig(event, "MainCore", metadata.name);
				plugin = ConfigManager.get(ConfigManager.config.CATEGORY_GENERAL, Plugin, true, "PluginLoader").getBoolean(true);
				ConfigManager.config.save();
				
				/**
		         * for the new PluginLoader
		         * TODO MAke Automatic
		         */
				if(plugin==true)
				{
					Loader.instance().loadPlugins();
					Load.Mods();
					Loader.instance().initializePlugins();
				}
	        
		}
		public void syncConfig()
	    {
	        String ctgyGen = MCConfiguration.CATEGORY_GENERAL;
	        config.load();
	        
	        allowUpdateCheck = config.getBoolean("allowUpdateCheck", ctgyGen, allowUpdateCheck, allowUpdateCheckDesc);
	        allowDebugOutput = config.getBoolean("allowDebugOutput", ctgyGen, allowDebugOutput, allowDebugOutputDesc);
	        updateTimeoutMilliseconds = config.getInt("updateTimeoutMilliseconds", ctgyGen, updateTimeoutMilliseconds, 100, 30000, updateTimeoutMillisecondsDesc);
	        generateUniqueNamesFile = config.getBoolean("generateUniqueNamesFile", ctgyGen, generateUniqueNamesFile, generateUniqueNamesFileDesc);
	        
	        config.save();
	        
	       
			
	
		}
		@Mod.EventHandler
		public void load(FMLInitializationEvent event)
		{
			CoreLogger.init();
			DedicatedServerProxy.init();
			
			if (allowUpdateCheck)
	        {
	            versionChecker = new ModVersionChecker(metadata.name, metadata.version, versionURL, mcfTopic);
	            versionChecker.checkVersionWithLogging();
	        }
		}
	
		@Override
		public String getModId() 
		{
			return Library.modid;
		}
	
		@Override
		public String getName() 
		{
			return Library.name;
		}
	
		public String getVersion() 
		{
			return Library.version;
		}
		public static void console(String s, boolean warning)
		{
		        StringBuilder sb = new StringBuilder();
		        CoreLogger.log(warning ? Level.WARN : Level.INFO, sb.append("[").append(Library.version).append("] ").append(s).toString());
		}
	
		    public static void console(String s)
		    {
		        console(s, false);
		    }
	
		    public static void console(int i)
		    {
		        console((new Integer(i)).toString());
		    }
	
		    public static void console(boolean b)
		    {
		        console((new Boolean(b)).toString());
		    }
	
		    public static void console(float f)
		    {
		        console((new Float(f)).toString());
		    }
	
		    public static void console(double d)
		    {
		        console((new Double(d)).toString());
		    }
	
		
	
	}
