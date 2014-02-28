package mods.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mods.common.logger.CoreLogger;
import mods.common.register.LangRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

import org.apache.logging.log4j.Level;


/**
 * Author: RoboRave
 */
public class Localizations {

    public static String langPath = null;

    public boolean errorShown;

    public Map<String, Properties> languageMapping = new HashMap<String, Properties>();

    @SuppressWarnings("static-access")
	public Localizations(String langPath) {

        this.langPath = langPath;
        loadLanguage("en_US");
    }

    public void loadLanguage(String lang) {

        Properties langFile = new Properties((Properties)this.languageMapping.get(lang));
        InputStreamReader reader = null;

        try {

            InputStream inStream = this.getClass().getResourceAsStream(langPath + lang + ".properties");

            if(inStream == null) {

                throw new IOException();
            }

            reader = new InputStreamReader(inStream, "UTF-8");
            langFile.load(reader);
        } catch(Exception e) {

           CoreLogger.log(Level.WARN,"Failed to load language: " + lang + " Reason: " + e.getLocalizedMessage());
        } finally {

            if(reader != null) {

                try {

                    reader.close();
                } catch(IOException e) {

                }
            }
        }

        this.languageMapping.put(lang, langFile);
       CoreLogger.log(Level.INFO,"Loaded language: " + lang);
    }

    public String translate(String key) {

        return translate(key, "en_US");
    }

    public String translate(String key, String lang) {

        if(languageMapping.containsKey(lang)) {

            try {

                return ((Properties)languageMapping.get(lang)).getProperty(key);
            } catch(Exception e) {

                printlangError(key, lang);
                return lang + ":" + key;
            }
        } else {

            CoreLogger.log(Level.WARN, "Missing lang file: " + lang);
            return lang + ":" + key;
        }
    }

    private void printlangError(String key, String lang) {

        CoreLogger.log(Level.WARN, "Failed to register " + lang + " localization for " + key);
    }

    public void registerItemStack(ItemStack stack, String unlocalized) {

        String currLang = "";

        for(String lang : languageMapping.keySet()) {

            try {

                currLang = lang;

                LangRegister.instance().addNameForObject(stack, lang, translate(unlocalized, currLang));
            } catch(Exception e) {

                printlangError(unlocalized, lang);
            }
        }
    }

    public void registerItem(Item item) {

        registerItemStack(new ItemStack(item), item.getUnlocalizedName());
    }

    public void registerBlock(Block block) {

        registerItemStack(new ItemStack(block), block.getUnlocalizedName());
    }

    public void registerPotion(Potion potion) {

        String currLang = "";

        for(String lang : languageMapping.keySet()) {

            try {

                currLang = lang;

                LangRegister.instance().addStringLocalization(potion.getName(), currLang, translate(potion.getName(), currLang));
            } catch(Exception e) {

                printlangError(potion.getName(), lang);
            }
        }
    }
}