package mx.tec.output;

import mx.tec.analyze.ReportCalculator;
import mx.tec.prefs.UserPrefences;

public interface DataOutput {
    void display(ReportCalculator report, UserPrefences prefs);
}
