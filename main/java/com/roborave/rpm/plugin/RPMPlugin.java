package com.roborave.rpm.plugin;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 *
 */
@Info(name = "RPM", version = "0.1.0")
public class RPMPlugin implements Plugin {

	
	private PluginMetadata meta;

	@Override
	public void preInit() 
	{
		
	}

	
	@Override
	public void init() 
	{
	
	}


	@Override
	public void postInit() 
	{
		
	}

	@Override
	public PluginMetadata meta() 
	{
		return new PluginMetadata(this.getClass());
	}

	@Override
	public String desc() {
		return null;
	}

}
