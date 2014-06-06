package mods.client.gui.slot;

import java.util.List;

import mods.client.gui.ConfigScreen;
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
    
   private final ConfigScreen     parent;
   private final List<Class<? extends Plugin>> mods;
    
    /**
     * @param parent
     * @param mods2
     * @param listWidth
     */

    @SuppressWarnings("javadoc")
	public GuiSlotMod(ConfigScreen parent, List<Class<? extends Plugin>> mods2, int listWidth)
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
    		  Class<? extends Plugin> mc1 = Loader.instance().mods.get(listIndex);
    	       
              try{this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc1.newInstance().meta().name, this.listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
			 }catch(InstantiationException e){e.printStackTrace();} catch(IllegalAccessException e){e.printStackTrace();}
              
              try{this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc1.newInstance().meta().version, this.listWidth - 10), this.left + 3, var3 + 12, 0xCCCCCC);
              }catch(InstantiationException e){e.printStackTrace();}catch(IllegalAccessException e){e.printStackTrace();}
    	}
        
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