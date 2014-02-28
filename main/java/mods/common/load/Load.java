package mods.common.load;

import mods.common.logger.CoreLogger;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;

public class Load {
	private static final Class ecm = getECM();
	
	public static void Mods(){
		
		
		if(Loader.isModLoaded("Extra_Diamonds_Mod")){
			Load.EDM();
			}else{
			CoreLogger.log(Level.WARN, "EDM Not Loaded!! It's OK");
		}
	}
	public static void EDM(){
		CoreLogger.log(Level.INFO, "Loaded " + Load.GetEDMName() );
     }

	@SuppressWarnings("rawtypes")
	private static Class getECM()
    {
            try
            {
                    return Class.forName("EDM.edm.main.lib.Library");
            }
            catch(ClassNotFoundException e)
            {
                    return null;
            }
	}
	 private static String GetEDMName()
     {
             try
             {
                     ecm.getMethod("name");
             }
             catch(Exception e)
             {
                     e.printStackTrace();
             }
			return null;
     }
	 private static void GetEDMVersion()
     {
             try
             {
                     ecm.getMethod("version");
             }
             catch(Exception e)
             {
                     e.printStackTrace();
             }
     }
}
