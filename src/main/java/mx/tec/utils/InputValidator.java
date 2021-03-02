package mx.tec.utils;

public class InputValidator {    

    public static boolean validInputMode(String mode) {
        if (mode == "file" || mode == "url" || mode == "console") {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validCurrency(String currency) {
        if (currency == "mxn" || currency == "usd" || currency == "brl") {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validOutputMode(String mode) {
        if (mode == "file" || mode == "console") {
            return true;
        } else {
            return false;
        }
    }


}
