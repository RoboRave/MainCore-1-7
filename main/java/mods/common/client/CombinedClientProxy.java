package mods.common.client;

import org.apache.logging.log4j.Level;

import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;

public class CombinedClientProxy extends CommonProxy {

	@Override
	public void Load() 
	{
		
	}

	public static void logC(String par1) 
	{
		CoreLogger.log(Level.INFO, par1);
		
	}

	@Override
	public void log(String par1) {
		// TODO Auto-generated method stub
		
	}

	

}
