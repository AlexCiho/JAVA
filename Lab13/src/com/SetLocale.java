package com;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * this class implements the functionality of the setLocales command
 */
public class SetLocale {
    private static String baseName = "res.Messages";

    /**
     * this function sets the current locale as the one specified by the user
     *
     * @param language
     * @param country
     */
    public static void exec(String language, String country) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        Locale.changeLocale(language, country);
        String pattern = resourceBundle.getString("locale.set");
        Object[] arguments = {Locale.getLocale().toLanguageTag()};
        System.out.println(new MessageFormat(pattern).format(arguments));

    }
}
