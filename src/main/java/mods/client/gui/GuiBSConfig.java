 package mods.client.gui;

import mods.common.config.ConfigManager;
import mods.common.library.Library;
import mods.common.util.config.ConfigProperty;
import mods.common.util.config.Configuration;
import mods.common.util.config.gui.GuiConfig;
import net.minecraft.client.gui.GuiScreen;

public class GuiBSConfig extends GuiConfig
{
	public GuiBSConfig(GuiScreen parent) throws NoSuchMethodException, SecurityException
    {
        super(parent, (new ConfigProperty(ConfigManager.config.getCategory(Configuration.CATEGORY_GENERAL))).getConfigPropertiesList(true),
                true, Library.modid, true, GuiConfig.getAbridgedConfigPath(ConfigManager.config.toString()));
    }
}