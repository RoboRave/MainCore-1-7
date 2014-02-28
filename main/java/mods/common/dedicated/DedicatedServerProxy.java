package mods.common.dedicated;

import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraftforge.common.MinecraftForge;
import mods.common.core.MainCore;
import mods.common.library.Library;
import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;

public class DedicatedServerProxy extends CommonProxy 
{

	@Override
	public void Load() 
	{
		
	}
	public static void init()
	{
		MainCore.console("Loaded "+Library.name+" for Minecraft "+ MainCore.instance.actualMCVersion);
	}

	
	@Override
	public void log(String par1) 
	{
		System.out.print("MainCore-Server: "+par1);
		
	}

}
