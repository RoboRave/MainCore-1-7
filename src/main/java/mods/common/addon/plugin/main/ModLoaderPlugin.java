package mods.common.addon.plugin.main;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 *
 */
@Info(name = "PluginLoader", version = "0.0.2")
public class ModLoaderPlugin implements Plugin
{
	@Override
	public PluginMetadata meta()
	{
		return new PluginMetadata(this.getClass());
	}
	    
    @Override
    public void preInit()
    {
       this.meta().description="Test";
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
	public String desc() {
		return "//TODO Description";
	}

   
    
}
