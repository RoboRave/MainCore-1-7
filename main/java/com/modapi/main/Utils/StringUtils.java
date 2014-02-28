package com.modapi.main.Utils;

public class StringUtils {

        public static String localize(String key) {
                return Localization.get(key);
        }
}