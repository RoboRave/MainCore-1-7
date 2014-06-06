/***
 *                                                                                 
 *     _|      _|            _|              _|_|_|                                
 *     _|_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _|_|    
 *     _|  _|  _|  _|    _|  _|  _|    _|  _|        _|    _|  _|_|      _|_|_|_|  
 *     _|      _|  _|    _|  _|  _|    _|  _|        _|    _|  _|        _|        
 *     _|      _|    _|_|_|  _|  _|    _|    _|_|_|    _|_|    _|          _|_|_|  
 *                                                                                 
 *                                                                                 
 */
package mods.common.core;

import java.io.File;
import java.util.Arrays;

import mods.common.addon.plugin.Loader;
import mods.common.client.CombinedClientProxy;
import mods.common.config.ConfigManager;
import mods.common.config.MCConfiguration;
import mods.common.dedicated.DedicatedServerProxy;
import mods.common.library.Library;
import mods.common.load.Load;
import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;
import mods.common.util.CommonUtils;
import mods.common.util.Const;
import mods.common.util.ModVersionChecker;
import mods.common.util.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

	/**
	 * @author Zach
	 *
	 */
	@Mod(modid = Library.modid,name=Library.name,version= Library.versions,guiFactory="mods.client.gui.GuiFactoryHandler")
	public class MainCore extends DummyModContainer {
		
		  
		
		/**
		 * Instance for mod
		 */
		@Instance("MainCore")
		public static MainCore instance;
	
		/**
		 *  the proxy for MainCore
		 */
		@SidedProxy
		(
			clientSide="mods.common.client.CombinedClientProxy", 
			serverSide="mods.common.dedicated.DedicatedServerProxy"
		)
		public static CommonProxy proxy;
		
		/**
		 * Minecraft's version
		 */
		public String actualMCVersion = Const.MCVERSION;
	
		private String Plugin= "PluginLoader";
		
		private String Dev= "Developer Mode";
		
		/**
		 * 
		 */
		public boolean plugin;

		  /**
		 * 
		 */
		public final String         allowUpdateCheckDesc          = "Set to true to allow checking for updates for ALL of my mods, false to disable";
		    /**
		     *  i we want the update check.
		     */
		    public boolean              allowUpdateCheck              = true;
		    /**
		     * 
		     */
		    public final String         allowDebugOutputDesc          = "";
		    /**
		     * 
		     */
		    public boolean              allowDebugOutput              = false;
		    /**
		     * The timeout in milliseconds for the version update check.
		     */
		    public final String         updateTimeoutMillisecondsDesc = "The timeout in milliseconds for the version update check.";
		    /**
		     * updateTimeoutMilliseconds
		     */
		    public int                  updateTimeoutMilliseconds     = 3000;
		    /**
		     * 
		     */
		    public final String         generateUniqueNamesFileDesc   = "When true a file called UniqueNames.txt will be generated in the config folder for convenience. \n" +
		                                                                      "The names found in the file are the string representation of blocks and items in Minecraft.\n" +
		                                                                      "Mods such as Treecapitator and StartingInventory use them in their config files since IDs are gone.";
		    /**
		     * I we want list of items
		     */
		    public boolean              generateUniqueNamesFile       = true;
		
		    protected ModVersionChecker versionChecker;
		    private final String        versionURL                    = Const.VERSION_URL + "/minecraft/" + "mods/MainCore/"+ Const.MCVERSION + "/"+Const.MCVERSION+".version";
		    private final String        mcfTopic                      = "http://www.minecraftforum.net/topic/1114612-";
		    
		    /**
		     * the config file
		     */
		    public static MCConfiguration      config;

			private String descriptionPlugin						="When true a new config screen will become useable.\n" 
			                                                        + "and you will be able to see loaded plugins in the new screen. "
			                                                        + "Warning: this is WIP feature";
			/**
			 *  core name
			 */
			public String core;
			/**
			 * boolean for dev mod
			 */
			public boolean dev;
			
			private String descriptionDEV= 	                        "this is Developer mode for MainCore."+"\n"
																	+"It may print random info in the console,"
																	+ "which could make loading minecraft slower."+"\n"
																	+" Enable at your own risk";
			
                    

		/**
		 * @param event the helping part
		 */
		@SuppressWarnings("static-access")
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) 
		{
			ModMetadata metadata = event.getModMetadata();
			metadata.autogenerated = false;
			metadata.credits = "(C) Roborave, 2013-2014";
			metadata.authorList = Arrays.asList("Roborave");
			metadata.name = Library.name;
			metadata.version = Library.version;
			metadata.description = "This the core for all my mods. ";
			
			
	        if (!CommonUtils.isObfuscatedEnv())
	        { // debug settings for deobfuscated execution
	          //            if (file.exists())
	          //                file.delete();
	        }
	        
	        File file2 = new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "MainCore" + File.separator + metadata.name+ ".config");
			
	        this.config = new MCConfiguration(file2);
			syncConfig();
			
			ConfigManager.CreateConfig(event, "MainCore", metadata.name);
			this.plugin = ConfigManager.get(ConfigManager.config.CATEGORY_GENERAL, this.Plugin, true, this.descriptionPlugin).getBoolean(true);
			this.dev = ConfigManager.get(ConfigManager.config.CATEGORY_GENERAL, this.Dev, false, this.descriptionDEV).getBoolean(false);
			ConfigManager.config.save();
			
			//FMLInterModComms.sendMessage("IGWMod", "mods.common.api.IGWHandler", "init");
				/**
		         * for the new PluginLoader
		         * TODO Make Automatic
		         */
				if(this.plugin==true)
				{
					this.core = Load.MainCore;
					CoreLogger.info("===================================================================");
					CoreLogger.info("========= PluginLoader has been enabled for your game. ============");
					CoreLogger.info("this means that you will be able to load plugins for "+ this.core+".");
					CoreLogger.info("Please note that this feature is very WIP. It may crash your game.");
					CoreLogger.info("===================================================================");
					
					Loader.instance().loadPlugins();
					try {
						Load.Mods();
					} 
						catch (InstantiationException e) 
					{
						e.printStackTrace();
					} 
						catch (IllegalAccessException e) 
					{
						e.printStackTrace();
					}
					
					Loader.instance().initializePlugins();
				}
				
				if(this.dev==true&&CommonUtils.isObfuscatedEnv())
				{
					DedicatedServerProxy.log("Loaded!!");
					CombinedClientProxy.log("Loaded!!");
					CommonProxy.log("Loaded!!");
					MainCore.console("Loaded!!");
					CoreLogger.info("   _|      _|            _|              _|_|_|                                ");
					CoreLogger.info("  _ |_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _|_|    ");
					CoreLogger.info("   _|_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _|_|    ");
					CoreLogger.info("   _|  _|  _|  _|    _|  _|  _|   _|   _|        _|    _|  _|_|      _|_|_|_|  ");
					CoreLogger.info("   _|      _|  _|    _|  _|  _|   _|   _|        _|    _|  _|        _|        ");
					CoreLogger.info("   _|      _|    _|_|_|  _|  _|   _|     _|_|_|    _|_|    _|          _|_|_|  ");
				}
				
				
	        
		}
		/**
		 * helps with the config
		 */
		public void syncConfig()
	    {
	        String ctgyGen = Configuration.CATEGORY_GENERAL;
	        this.config.load();
	        
	        this.allowUpdateCheck = this.config.getBoolean("allowUpdateCheck", ctgyGen, this.allowUpdateCheck, this.allowUpdateCheckDesc);
	        this.allowDebugOutput = this.config.getBoolean("allowDebugOutput", ctgyGen, this.allowDebugOutput, this.allowDebugOutputDesc);
	        this.updateTimeoutMilliseconds = this.config.getInt("updateTimeoutMilliseconds", ctgyGen, this.updateTimeoutMilliseconds, 100, 30000, this.updateTimeoutMillisecondsDesc);
	        this.generateUniqueNamesFile = this.config.getBoolean("generateUniqueNamesFile", ctgyGen, this.generateUniqueNamesFile, this.generateUniqueNamesFileDesc);
	        
	        this.config.save();
		}
		/**
		 * @param event main event loader
		 */
		@EventHandler
		public void load(FMLInitializationEvent event)
		{
			CoreLogger.init();
			DedicatedServerProxy.init();
			
			if (this.allowUpdateCheck)
	        {
	            this.versionChecker = new ModVersionChecker(Library.name, Library.version, this.versionURL, this.mcfTopic);
	            this.versionChecker.checkVersionWithLogging();
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
	
		@Override
		public String getVersion() 
		{
			return Library.version;
		}
		/**
		 * @param s the message
		 * @param warning is it a warning
		 */
		public static void console(String s, boolean warning)
		{
		        StringBuilder sb = new StringBuilder();
		        CoreLogger.log(warning ? Level.WARN : Level.INFO,"[MainCore] " + sb.append("[").append(Library.version).append("] ").append(s).toString());
		}
	
		    @SuppressWarnings("javadoc")
			public static void console(String s)
		    {
		        console(s, false);
		    }
	
		    @SuppressWarnings("javadoc")
			public static void console(int i)
		    {
		        console((new Integer(i)).toString());
		    }
	
		    @SuppressWarnings("javadoc")
			public static void console(boolean b)
		    {
		        console((new Boolean(b)).toString());
		    }
	
		    @SuppressWarnings("javadoc")
			public static void console(float f)
		    {
		        console((new Float(f)).toString());
		    }
	
		    @SuppressWarnings("javadoc")
			public static void console(double d)
		    {
		        console((new Double(d)).toString());
		    }
	
		
	
	}
