package mods.common.addon.lib;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
	public static Logger log;

	private static boolean configured = false;

	public static void init(){
		log = LogManager.getLogger("CoreAddon");
		configured = true;
		//log.setParent(LogManager.getLogger("FML"));
	}

	public static void log(Level level, String message){
		if (!configured){
			init();
		}
		log.log(level, "[" + "1.0.0" + "] " + message, new Object[0]);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

}