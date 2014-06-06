 package mods.client.gui;

import mods.client.gui.slot.GuiSlotMod;
import mods.common.addon.plugin.Loader;
import mods.common.addon.plugin.Plugin;
import mods.common.core.MainCore;
import mods.common.helper.MinecraftHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.GuiModList;

public class ConfigScreen extends GuiScreen
{
    String             guiTitle;
    public GuiScreen   parent;
    private int        listWidth;
    private GuiSlotMod modList;
    private int        selected = -1;
    private Class<? extends Plugin>  selectedMod;
    private GuiButton  about, Done;
    
    public ConfigScreen(GuiScreen parent)
    {
        this.parent = parent;
        this.guiTitle = "test";
    }
    
    @Override
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        switch (par1GuiButton.id)
        {
            case 1:
                
                MinecraftHelper.displayGuiScreen(Minecraft.getMinecraft(), new GuiModList(new GuiMainMenu()));
                break;
            
            case 2:
                // this.mc.displayGuiScreen(new GuiAbout(this));
                this.updateScreen();
                MinecraftHelper.displayGuiScreen(Minecraft.getMinecraft(), new GuiAbout(this));
                
                break;
            default:
                break;
        }
    }
    
    public int drawLine(String line, int offset, int shifty)
    {
        this.fontRendererObj.drawString(line, offset, shifty, 0xd7edea);
        return shifty + 10;
    }
    
    @SuppressWarnings("static-access")
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	if(MainCore.instance.plugin==true)
    	{
	    
	        this.modList.drawScreen(par1, par2, par3);
	        this.drawCenteredString(this.fontRendererObj, "Plugin List", this.width / 2, 16, 0xFFFFFF);
	        int offset = this.listWidth + 20;
	        int shifty = 35;
	        GL11.glEnable(GL11.GL_BLEND);
        if(this.selectedMod != null)
        {
            try {
				this.fontRendererObj.drawStringWithShadow(this.selectedMod.newInstance().meta().name, offset, shifty, 0xFFFFFF);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            shifty += 12;
            try {
				shifty = drawLine(String.format("Version: %s (%s)", this.selectedMod.newInstance().meta().version, this.selectedMod.newInstance().meta().version), offset, shifty);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				shifty = drawLine(String.format("Mod ID: '%s' ", this.selectedMod.newInstance().meta().name), offset, shifty);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            int rightSide = this.width - offset - 20;
            	if (rightSide > 20)
            	{
            		try {
						this.getFontRenderer().drawSplitString(String.format("Descripton: '%s' ",this.selectedMod.newInstance().desc()), offset, shifty + 10, rightSide, 0xDDDDDD);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            		else
            	{
            		try {
						shifty = drawLine(String.format("Descripton: '%s' ", this.selectedMod.newInstance().desc()), offset, shifty + 10);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
        	}
    	}
       		else
       	{
       		
       		this.updateScreen();
       		this.drawDefaultBackground();
       		this.drawCenteredString(this.fontRendererObj, "Plugins not enabled", this.width / 2, 16, 0xFFFFFF);
       }
            
            // offset = ( this.listWidth + this.width ) / 2;
            // this.drawCenteredString(this.fontRendererObj, selectedMod.name(),
            // offset, 35, 0xFFFFFF);
            // this.drawCenteredString(this.fontRendererObj,
            // String.format("Version: %s",selectedMod.version()), offset, 45,
            // 0xFFFFFF);
            
            // this.drawCenteredString(this.fontRendererObj,
            // String.format("Mod State: %s",ModPlugin.getModState()), offset,
            // 55, 0xFFFFFF);
            // this.drawCenteredString(this.fontRendererObj,
            // "No mod information found", offset, 65, 0xDDDDDD);
            // this.drawCenteredString(this.fontRendererObj,
            // "Ask your mod author to provide a mod mcmod.info file", offset,
            // 75, 0xDDDDDD);
            
       
        GL11.glDisable(GL11.GL_BLEND);
        
        super.drawScreen(par1, par2, par3);
    }
    
    public FontRenderer getFontRenderer()
    {
        
        return this.fontRendererObj;
    }
    
    public Minecraft getMinecraftInstance()
    {
        
        return this.mc;
    }
    
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    
    @SuppressWarnings({ "static-access" })
    @Override
    public void initGui()
    {
        this.buttonList.clear();
        
        this.about = new GuiButton(2, this.width / 2 - 100, this.height - 38, 98, 20, "About");
        this.Done = new GuiButton(1, this.width / 2 + 2, this.height - 38, 98, 20, I18n.format("gui.done", new Object[0]));
        
        this.buttonList.add(this.about);
        this.buttonList.add(this.Done);
        
        if(MainCore.instance.plugin==true)
        {
        	for (Class<? extends Plugin> mod : Loader.instance().mods)
            {
                try {this.listWidth = Math.max(this.listWidth, getFontRenderer().getStringWidth(mod.newInstance().meta().name) + 10);
                } catch (InstantiationException e) {e.printStackTrace();} catch (IllegalAccessException e) {e.printStackTrace();}
                
                try {this.listWidth = Math.max(this.listWidth, getFontRenderer().getStringWidth(mod.newInstance().meta().version) + 10);
				} catch (InstantiationException e) {e.printStackTrace();} catch (IllegalAccessException e) {e.printStackTrace();}
            }
        }
        	else
        {
        	this.listWidth = Math.min(this.listWidth, 150);
           
        }
        
        this.modList = new GuiSlotMod(this, Loader.instance().mods, this.listWidth);
    }
    
    @Override
    protected void keyTyped(char c, int i)
    {
        
    }
    
    public boolean modIndexSelected(int var1)
    {
        return var1 == this.selected;
    }
    
    @Override
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        
    }
    
    public void selectModIndex(int var1)
    {
        this.selected = var1;
        if (var1 >= 0 && var1 <= Loader.instance().mods.size())
        {
            this.selectedMod = Loader.instance().mods.get(this.selected);
        }
        else
        {
            this.selectedMod = null;
        }
    }
    
    @Override
    public void updateScreen()
    {
        super.updateScreen();
        // updateTimeoutMillisecondsTextBox.updateCursorCounter();
    }
    
}