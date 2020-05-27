package com;

import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.ResourceBundle;

/**
 * This class implements the functionality of the Info command
 */
public class Info {
    private static String baseName = "res.Messages";

    /**
     * this function displays the info for the current locale
     */
    public static void exec() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        String pattern = resourceBundle.getString("info");
        Object[] arguments = {Locale.getLocale().toLanguageTag()};
        System.out.println(new MessageFormat(pattern).format(arguments));

        System.out.println(resourceBundle.getString("country") + Locale.getLocale().getDisplayCountry() +
                " ( " + Locale.getLocale().getDisplayCountry(Locale.getLocale()) + " ) ");
        System.out.println(resourceBundle.getString("language") + Locale.getLocale().getDisplayLanguage() +
                " ( " + Locale.getLocale().getDisplayLanguage(Locale.getLocale()) + " ) ");
        Currency currency = Currency.getInstance(Locale.getLocale());
        System.out.println(resourceBundle.getString("currency") + currency.getSymbol() + " ( " + currency.getDisplayName() + ")");
        System.out.println(resourceBundle.getString("weekDays"));
        Arrays.stream(DayOfWeek.values()).forEach(day -> {
            System.out.print(day.getDisplayName(TextStyle.FULL, Locale.getLocale()) + " ");
        });
        System.out.println();
        System.out.println(resourceBundle.getString("months"));
        Arrays.stream(Month.values()).forEach(month -> {
            System.out.print(month.getDisplayName(TextStyle.FULL, Locale.getLocale()) + " ");
        });
        System.out.println();
        System.out.println(resourceBundle.getString("today") + LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", Locale.getLocale())));

    }

    /**
     * this function displays the info for a specified locale
     *
     * @param language
     * @param country
     */
    public static void exec(String language, String country) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        String pattern = resourceBundle.getString("info");
        Object[] arguments = {language + "-" + country};
        System.out.println(new MessageFormat(pattern).format(arguments));
        java.util.Locale locale = new java.util.Locale(language, country);
        System.out.println(resourceBundle.getString("country") + locale.getDisplayCountry() +
                " ( " + Locale.getLocale().getDisplayCountry(locale) + " ) ");
        System.out.println(resourceBundle.getString("language") + locale.getDisplayLanguage() +
                " ( " + Locale.getLocale().getDisplayLanguage(locale) + " ) ");
        Currency currency = Currency.getInstance(locale);
        System.out.println(resourceBundle.getString("currency") + currency.getSymbol() + " ( " + currency.getDisplayName() + ")");
        System.out.println(resourceBundle.getString("weekDays"));
        Arrays.stream(DayOfWeek.values()).forEach(day -> {
            System.out.print(day.getDisplayName(TextStyle.FULL, locale) + " ");
        });
        System.out.println();
        System.out.println(resourceBundle.getString("months"));
        Arrays.stream(Month.values()).forEach(month -> {
            System.out.print(month.getDisplayName(TextStyle.FULL, locale) + " ");
        });
        System.out.println();
        System.out.println(resourceBundle.getString("today") + LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", locale)));

    }
}
