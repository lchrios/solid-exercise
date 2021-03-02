package mx.tec.output;

import mx.tec.analyze.ReportCalculator;
import mx.tec.prefs.UserPrefences;

public class CLIOutput implements DataOutput {
    
    public void display(ReportCalculator report, UserPrefences prefs) {
        System.out.println(report.summarize(prefs));
    }
}
