package mods.common.client;

import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;

/**
 * @author Zach
 *
 */
public class CombinedClientProxy extends CommonProxy {

	@Override
	public void Load() 
	{
		
	}
	
	public static void log(String par1) 
	{
		CoreLogger.info("[MainCore-Client] "+ par1);
	}

	

}
