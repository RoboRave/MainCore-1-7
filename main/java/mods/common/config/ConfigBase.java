package mods.common.config;

import java.io.File;

import mods.common.exception.ConfigurationException;
import mods.common.implement.IObject;
import net.minecraftforge.common.config.Configuration;

public abstract class ConfigBase implements IObject {

    protected Configuration config = null;

    public ConfigBase(File file) {

        this.config = new Configuration(file);
    }

    @Override
    public void initialize() {

        try {

            this.config.load();

            loadItems();
            loadBlocks();
            loadOther();
        } catch(ConfigurationException e) {

            e.printStackTrace();
        } finally {

            this.config.save();
        }
    }

    protected abstract void loadOther() throws ConfigurationException;

    protected abstract void loadBlocks() throws ConfigurationException;

    protected abstract void loadItems() throws ConfigurationException;
}