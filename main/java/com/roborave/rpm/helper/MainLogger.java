package com.roborave.rpm.helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLogger {
	public static Logger log;

	private static boolean configured = false;

	public static void init(){
		log = LogManager.getLogger("RPM");
		configured = true;
	}

	public static void log(Level level, String message,Object... params)
	{
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
}