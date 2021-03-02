package mx.tec.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import mx.tec.analyze.ReportCalculator;
import mx.tec.prefs.UserPrefences;

public class FileOutput implements DataOutput {

    File file;

    public FileOutput(UserPrefences prefs) {
        prefs.fetchFileName();
        this.file = new File(prefs.getFileName());
        try {
            while (!this.file.createNewFile()) {
                System.out.println("File already exists!\nSelect another name.");
                prefs.fetchFileName();
                this.file = new File(prefs.getFileName());
            }

        } catch (IOException e) {
            System.out.println("An error occurred creating and/or writing your report file.");
            e.printStackTrace();
        }
    
    }

    public void display(ReportCalculator report, UserPrefences prefs) {
        // Writing report summary to file
        FileWriter fw;
        try {
            fw = new FileWriter(this.file);
            fw.write(report.summarize(prefs));
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
