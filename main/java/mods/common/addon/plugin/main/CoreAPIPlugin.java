package mods.common.addon.plugin.main;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

@Info(name = "Core-API", version = "0.1.1")
public class CoreAPIPlugin implements Plugin
{
    @Override
    public PluginMetadata meta()
    {
        return new PluginMetadata(this.getClass());
    }
    
    @Override
    public void preInit()
    {
        meta().description = "Main Core-API Part for my MainCore Mod";
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
		return "Core-API Plugin for MainCore";
	}
  
    
   
 
}
