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
package mods.common.dedicated;


import org.apache.logging.log4j.Level;

import mods.common.core.MainCore;
import mods.common.library.Library;
import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;

/**
 * @author Zach
 *
 */
public class DedicatedServerProxy extends CommonProxy 
{

	@Override
	public void Load() 
	{
		
	}
	
	/**
	 *  the main part of the proxy
	 */
	public static void init()
	{
		MainCore.console("Loaded "+Library.name+" for Minecraft "+ MainCore.instance.actualMCVersion);
	}

	
	public static void log(String par1) 
	{
		CoreLogger.log(Level.INFO,"[MainCore-Server] "+par1);
		
	}

}
