package app;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Input {
    private String baseName = "res.Messages";

    public String getCommand() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        java.util.Locale available[] = java.util.Locale.getAvailableLocales();
        System.out.println(resourceBundle.getString("prompt"));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }
}
