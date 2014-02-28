package mods.common.implement;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public interface IMod {
    
    void preInit(FMLPreInitializationEvent evt);
    
    void init(FMLInitializationEvent evt);
    
    void postInit(FMLPostInitializationEvent evt);
}