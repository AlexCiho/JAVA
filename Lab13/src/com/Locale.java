package com;

/**
 * this class contains the global locale instance
 */
public class Locale {
    private static java.util.Locale localeInstance = new java.util.Locale("en", "US");

    public static java.util.Locale getLocale() {
        return localeInstance;
    }

    /**
     * this function modified the global locale instance
     *
     * @param language
     * @param country
     */
    public static void changeLocale(String language, String country) {
        localeInstance = new java.util.Locale(language, country);
    }
}
