package mods.common.api;
import java.util.HashMap;

import mods.common.implement.IObject;
import mods.common.logger.CoreLogger;

import org.apache.logging.log4j.Level;

public class RegistryManager
{
		
		public static HashMap<Class<?extends IObject>,String> APIClasses = new HashMap<Class<? extends IObject>, String>();
		
		public static void init()
		{
			CoreLogger.log(Level.INFO,"Registered %s API Classes",APIClasses.size());
		}
		/**
		 * 
		 * @param clazz the class that needs to initizied
		 */
		public static void registerAPIClass(Class<?extends IObject> clazz)
		{
			APIClasses.put(clazz,clazz.toString().toLowerCase());
			try {
				clazz.newInstance().initialize();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}