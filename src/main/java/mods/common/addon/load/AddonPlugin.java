package mods.common.addon.load;

import mods.common.addon.lib.LogHelper;
import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;
@Info(name = "Core-Addon", version = "0.4.1")
public class AddonPlugin implements Plugin {

	@Override
	public PluginMetadata meta() 
	{
		return new PluginMetadata(AddonPlugin.class);
	}

	@Override
	public void preInit() 
	{
		LogHelper.init();
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
	public String desc() 
	{
		return "Small Plugin for MainCore";
	}

	
}
