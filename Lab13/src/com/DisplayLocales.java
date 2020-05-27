package com;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * this class implements the functionality of the displayLocales command
 */
public class DisplayLocales {
    private static String baseName = "res.Messages";

    /**
     * this function displays the country and the language for every available locale
     */
    public static void exec() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        java.util.Locale available[] = java.util.Locale.getAvailableLocales();
        System.out.println(resourceBundle.getString("locales"));
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry() + "=>" + locale.getDisplayLanguage(locale));
        }
    }
}
