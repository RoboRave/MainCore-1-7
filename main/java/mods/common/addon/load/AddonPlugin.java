package mods.common.addon.load;

import org.apache.logging.log4j.Level;

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
		Addons.LoadGG();
    	LogHelper.log(Level.INFO, "Core-Addon"+ " "+ "Loaded!! for minecraft 1.7.2");
    	
    	
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
