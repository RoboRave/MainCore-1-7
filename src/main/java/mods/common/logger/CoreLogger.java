package mods.common.logger;

import mods.common.library.Library;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoreLogger {
	public static Logger log;

	private static boolean configured = false;

	public static void init(){
		log = LogManager.getLogger(Library.modid);
		configured = true;
		//log.setParent(LogManager.getLogger("FML"));
	}

	public static void log(Level level, String message,Object... params){
		if (!configured){
			init();
		}
		log.log(level, message, params);
	}

	public static void info(String message) {
		log(Level.INFO, message);
	}

	public static void log(Level level, String message){
		if (!configured){
			init();
		}
		log.log(level, message, new Object[0]);
	}

	public static void warning(String message) {
		log(Level.WARN, message);
	}
}