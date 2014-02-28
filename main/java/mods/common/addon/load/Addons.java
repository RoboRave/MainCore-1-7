package mods.common.addon.load;


import org.apache.logging.log4j.Level;

import mods.common.addon.lib.LogHelper;
import cpw.mods.fml.common.Loader;

public class Addons 
{
	
	public static void LoadGG()
	{
		if(Loader.isModLoaded("GraviGun"))
		{
			GGAPI();
			
		}else{
			
			LogHelper.log(Level.INFO, "GraviGun not found: Not enableing GraviGun Plugin.");
		}
	}
	public static void LoadCM(){
		
	}
	public static void GGAPI()
	{
		LogHelper.log(Level.INFO, "Found GraviGun Mod: Loading Addons");
		GGAPI.addBlockIDToGrabList(57);
		GGAPI.addBlockIDToGrabList(4050);
		GGAPI.addBlockIDToGrabList(4051);
		GGAPI.addBlockIDToGrabList(4052);
		GGAPI.addBlockIDToGrabList(4053);
		GGAPI.addBlockIDToGrabList(4054);
		GGAPI.addBlockIDToGrabList(4055);
		GGAPI.addBlockIDToGrabList(4056);
		GGAPI.addBlockIDToGrabList(4057);
		GGAPI.addBlockIDToGrabList(4058);
		GGAPI.addBlockIDToGrabList(4059);
		GGAPI.addBlockIDToGrabList(4060);
	}
}
