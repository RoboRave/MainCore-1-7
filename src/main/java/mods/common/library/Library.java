package mods.common.library;

import mods.common.util.config.Configuration;
import net.minecraft.world.World;

public class Library {

	public final static String name="ROBO-Core";
	public static final String modid="MainCore";
	
	public static Configuration config = null;
	
	public static boolean isClient(World world) {
		return world.isRemote;
	}

	
	  	//This number is incremented every time I remove deprecated code/major API changes, never reset
	    public static final int majorVersion    = 1;
	    //This number is incremented every minecraft release, never reset
	    public static final int minorVersion    = 1;
	    //This number is incremented every time a interface changes or new major feature is added, and reset every Minecraft version
	    public static final int revisionVersion = 7;
	    //This number is incremented every time I builds the mod, and never reset.
	    public static final int buildVersion    = 130;

	    public static int getMajorVersion()
	    {
	        return majorVersion;
	    }

	    public static int getMinorVersion()
	    {
	        return minorVersion;
	    }

	    public static int getRevisionVersion()
	    {
	        return revisionVersion;
	    }

	    public static int getBuildVersion()
	    {
	        return buildVersion;
	    }
	    public final static String versions= majorVersion +"."+ revisionVersion;

	    public final static String version= majorVersion +"."+ minorVersion+"." + revisionVersion +"."+ buildVersion;
		public static final String MINECRAFT = "1.7.2";
	    
	}
	
	
	
	
	
