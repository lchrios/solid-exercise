package mx.tec.main;

import mx.tec.analyze.ReportCalculator;
import mx.tec.entities.Student;
import mx.tec.input.CLIReceiver;
import mx.tec.input.CURLReceiver;
import mx.tec.input.DataReceiver;
import mx.tec.input.FileReceiver;
import mx.tec.output.CLIOutput;
import mx.tec.output.DataOutput;
import mx.tec.output.FileOutput;
import mx.tec.prefs.UserPrefences;

public class Main {

    private static DataReceiver input;
    private static DataOutput output;

    public static void main(String[] args) {

        /*
         *   1 - Ask user input form through console
         *   2 - Input data from user
         *   3 - Analyze data
         *   4 - Ask user month to report
         *   5 - Ask user output form through console
         *   6 - Output information
         */


        // * 1 - Ask user preferences
        UserPrefences prefs = new UserPrefences();
        prefs.fetchInputMode();
        

        Student stud = new Student();
        // * 2 - Fetch all data depending on the mode and save to student
        String in_mode = prefs.getInputMode();
        if (in_mode.equals("file")) {
            input = new FileReceiver(prefs);
        } else if (in_mode.equals("url")) {
            input = new CURLReceiver();

        } else if (in_mode.equals("console")) {
            input = new CLIReceiver();
        }

        stud.setName(input.getStudName());
        stud.setLname(input.getStudLastName());
        stud.setId(input.getStudId());
        stud.setEmail(input.getStudEmail());
        stud.setPurchases(input.getPurchases());

        // * 3 - Analyze data with report
        ReportCalculator report = new ReportCalculator(stud);

        // * 4 - Ask user month to report
        prefs.fetchMonth();

        // * 5 Ask user output form
        prefs.fetchOutputMode();
        prefs.fetchCurrency();

        // * 6 Output information
        String out_mode = prefs.getOutputMode();

        if (out_mode.equals("console")) {
            output = new CLIOutput();
            
        } else if (out_mode.equals("file")) {
            output = new FileOutput(prefs);
        }
        output.display(report, prefs);
        
    }
}
