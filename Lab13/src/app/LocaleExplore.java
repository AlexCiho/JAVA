package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.ResourceBundle;


public class LocaleExplore {
    /**
     * this function reads the commands and executes the commands
     *
     * @param args
     */
    public static void main(String[] args) {
        Input input = new Input();
        String baseName = "res.Messages";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, com.Locale.getLocale());
        while (true) {
            String command = input.getCommand();
            String[] commandSplit = command.split(" ");
            switch (commandSplit[0]) {
                case "displaylocales":
                    DisplayLocales.exec();
                    break;
                case "setlocales":
                    if (commandSplit.length < 3) {
                        System.out.println(resourceBundle.getString("invalid"));
                    } else {
                        try {
                            SetLocale.exec(commandSplit[1], commandSplit[2]);
                        } catch (Exception e) {
                            System.out.println(resourceBundle.getString("invalid.args"));
                        }
                    }
                    break;
                case "info":
                    if (commandSplit.length < 3) {
                        Info.exec();
                    } else {
                        try {
                            Info.exec(commandSplit[1], commandSplit[2]);
                        } catch (Exception e) {
                            System.out.println(resourceBundle.getString("invalid.args"));
                        }
                    }
                    break;
                default:
                    System.out.println(resourceBundle.getString("invalid"));
            }
        }

    }
}
