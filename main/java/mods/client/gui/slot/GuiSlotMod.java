package mods.client.gui.slot;

import java.util.List;

import mods.client.gui.GuiBSConfig;
import mods.common.addon.plugin.Loader;
import mods.common.addon.plugin.Plugin;
import mods.common.core.MainCore;
import net.minecraft.client.renderer.Tessellator;
import cpw.mods.fml.client.GuiScrollingList;

/**
 * @author RoboRave
 * 
 */
public class GuiSlotMod extends GuiScrollingList
{
    
    private final GuiBSConfig     parent;
    private final List<Plugin> mods;
    
    public GuiSlotMod(GuiBSConfig parent, List<Plugin> mods2, int listWidth)
    {
        super(parent.getMinecraftInstance(), listWidth, parent.height, 32, parent.height - 66 + 4, 10, 35);
        this.parent = parent;
        this.mods = mods2;
    }
    
    @Override
    protected void drawBackground()
    {
        this.parent.drawDefaultBackground();
    }
    
    @SuppressWarnings("static-access")
    @Override
    protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5)
    {
    	if(MainCore.instance.plugin==true)
    	{
    		  Plugin mc1 = Loader.instance().mods.get(listIndex);
    	       
              this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc1.meta().name, this.listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
              this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc1.meta().version, this.listWidth - 10), this.left + 3, var3 + 12, 0xCCCCCC);
    	}else{
    
    	}
     
    	
        /*
        	 this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getMeta().name, this.listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
             this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getMeta().version, this.listWidth - 10), this.left + 3, var3 + 12, 0xCCCCCC);
        */
       
        // this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getMetadata()
        // !=null ? mc.getMetadata().getChildModCountString() :
        // "Metadata not found", listWidth - 10), this.left + 3 , var3 + 22,
        // 0xCCCCCC);
        
    }
    
    @Override
    protected void elementClicked(int var1, boolean var2)
    {
        this.parent.selectModIndex(var1);
    }
    
    @Override
    protected int getContentHeight()
    {
        return (this.getSize()) * 35 + 1;
    }
    
    @Override
    protected int getSize()
    {
        return this.mods.size();
    }
    
    @Override
    protected boolean isSelected(int var1)
    {
        return this.parent.modIndexSelected(var1);
    }
}