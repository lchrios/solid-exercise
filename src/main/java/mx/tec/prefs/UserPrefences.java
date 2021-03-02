package mx.tec.prefs;

import java.util.Scanner;

import mx.tec.utils.InputValidator;

public class UserPrefences {

    private int month;
    private Scanner sc;
    private String 
        inputMode, 
        outputMode,
        currency,
        source,
        file_name;
    

    public UserPrefences() {
        this.sc = new Scanner(System.in);
    }


    public void fetchCurrency () {
        System.out.print("Which currency to display output? [ mxn | usd | brl ]: ");
        String curr = sc.nextLine();
        if (InputValidator.validCurrency(curr)) {
            setCurrency(curr);
        } else {
            System.out.println("Invalid currency type\nValid currencies: [mxn, usd, brl]");
            fetchCurrency();
        }
    }

    public String getCurrency () {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void fetchInputMode () {
        System.out.print("How do you want to import the data? [ file | url | console ]: ");
        String mode = sc.nextLine();
        if (InputValidator.validInputMode(mode)) {
            setInputMode(mode);
        } else {
            System.out.println("Invalid input form\nValid inputs : [ file | url | console ]");
            fetchInputMode();
        }
    }

    public String getInputMode () {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }

    public void fetchOutputMode () {
        System.out.print("How do you want to export the report? [ file | console ]: ");
        String mode = sc.nextLine();
        if (InputValidator.validInputMode(mode)) {
            setOutputMode(mode);
        } else {
            System.out.println("Invalid output form\nValid outputs : [ file | console ]");
            fetchOutputMode();
        }
    }

    public String getOutputMode() {
        return outputMode;
    }

    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }

    public void fetchSource () {
        System.out.print("From where do we fetch your data?: ");
        setSource(sc.nextLine());
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void fetchFileName () {
        System.out.print("How do you want to name the report?: ");
        setFileName(sc.nextLine());
    }

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    public void fetchMonth () {
        System.out.print("Months:\n[ 0 - Jan | 1 - Feb | 2 - Mar | 3 - Apr ]\n[ 4 - May | 5 - Jun | 6 - Jul | 7 - Aug ]\n[ 8 - Sep | 9 - Oct | 10 - Nov | 11 - Dec ]\nSelect month to analyze (number): ");
        int month = Integer.valueOf(sc.nextLine());
        if (0 <= month && month <= 11) {
            setMonth(month);
        } else {
            System.out.print("Invalid month\nValid ");
            fetchMonth();
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
