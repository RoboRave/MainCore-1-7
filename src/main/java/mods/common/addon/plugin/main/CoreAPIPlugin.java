package mods.common.addon.plugin.main;

import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;
import mods.common.addon.plugin.common.Info.Init;
import mods.common.addon.plugin.common.Info.PostInit;
import mods.common.addon.plugin.common.Info.PreInit;
import mods.common.dedicated.DedicatedServerProxy;

/**
 * @author Zach
 *
 */
@Info(name = "Core-API", version = "0.1.1")
public class CoreAPIPlugin implements Plugin
{
    @Override
    public PluginMetadata meta()
    {
        return new PluginMetadata(this.getClass());
    }
    
    @PreInit()
    @Override
    public void preInit()
    {
    	DedicatedServerProxy.log("Test");
        
    }
    
    @Init()
    @Override
    public void init()
    {
        
    }
    
    @PostInit()
    @Override
    public void postInit()
    {
        
    }

	@Override
	public String desc() 
	{
		return  "Main Core-API Part for my MainCore Mod";
	}
  
    
   
 
}
