package mx.tec.utils;

public class InputValidator {    

    public static boolean validInputMode(String mode) {
        if (mode.equals("file") || mode.equals("url") || mode.equals("console")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validCurrency(String currency) {
        if (currency.equals("mxn") || currency.equals("usd") || currency.equals("brl")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validOutputMode(String mode) {
        if (mode.equals("file") || mode.equals("console")) {
            return true;
        } else {
            return false;
        }
    }


}
