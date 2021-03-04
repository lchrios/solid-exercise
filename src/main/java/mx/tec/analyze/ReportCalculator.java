package mx.tec.analyze;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;

import mx.tec.entities.MonthReport;
import mx.tec.entities.Purchase;
import mx.tec.entities.Student;
import mx.tec.prefs.UserPrefences;
import mx.tec.utils.CurrencyConverter;
import mx.tec.utils.MXNtoBRL;
import mx.tec.utils.MXNtoMXN;
import mx.tec.utils.MXNtoUSD;

public class ReportCalculator {

    private Student stud;
    private String today_date_str;


    // @ Output data
    private LinkedList<Purchase> today_purch_list;
    private MonthReport[] months = new MonthReport[12];

    public ReportCalculator(Student stud) {
        
        for (int i = 0; i < 12; i++) {
            months[i] = new MonthReport();
        }

        this.today_purch_list = new LinkedList<Purchase>();
        this.stud = stud;

        String[] raw_date = LocalDate.now().toString().split("-");         
        this.today_date_str = raw_date[1] + "/" + raw_date[2] + "/" + raw_date[0];
        this.calculate();
    }

    public void calculate() {
        LinkedList<Purchase> purchases = stud.getPurchases();

        for (Purchase prod : purchases) {
            /*
                * 1 - Check if is today's purchase
                * 2 - Add it to its respective month
            */

            // * 1 - Check if is today's purchase
            if (prod.getDate().equals(this.today_date_str)) {
                today_purch_list.add(prod);
            }

            // * 2 - Add it to its respective month
            String month_str = prod.getDate().split("/")[1];
            this.months[Integer.valueOf(month_str) - 1].addPurchase(prod);   
        }

        for (int i = 0; i < 12; i++){
            this.months[i].finish();
        }
    }

    public String summarize(UserPrefences prefs) {
        // - Month's info
        MonthReport month = this.months[prefs.getMonth()];
        Purchase min = month.getMinPurch(), max = month.getMaxPurch();

        CurrencyConverter converter;

        if (prefs.getCurrency().equals("mxn")) {
            converter = new MXNtoMXN();
        } else if (prefs.getCurrency().equals("usd")) {
            converter = new MXNtoUSD();
        } else {
            converter = new MXNtoBRL();
        }
        String res = "";

        // - Today's purchases
        res = res.concat("Purchases of today " + this.today_date_str + ": " + this.today_purch_list.size() + "\n");
        for (Purchase prod : this.today_purch_list) {
            double price = converter.convert(prod.getPrice());
            res = res.concat(prod.getReceiver() + " with total of $" + price + " " + prefs.getCurrency() + "\n");
        }
        res = res.concat("\n");

        
        String minReceiver = min != null ? min.getReceiver() : "No purchase this month";
        String maxReceiver = max != null ? max.getReceiver() : "No purchase this month";
        double minPrice = converter.convert(min != null ? min.getPrice() : 0);
        double maxPrice = converter.convert(max != null ? max.getPrice() : 0);
        double average = converter.convert(month.getAverage());


        res = res.concat("Min purchase of the month: " + minReceiver + " $" + minPrice + " " + prefs.getCurrency() + "\n");
        res = res.concat("Max purchase of the month: " + maxReceiver + " $" + maxPrice + " " + prefs.getCurrency() + "\n");
        res = res.concat("Average purchases amount: $" + average + " " + prefs.getCurrency() + "\n");
        res = res.concat("Frequent receiver: ");
        Map<String, Integer> receivers = month.getReceivers();
        Object[] rec = receivers.keySet().toArray();
        boolean has_max_rec = false;

        for (int i = 0; i < rec.length; i++) {
            if (receivers.get(rec[i]).equals(month.getMaxRecNum()) && month.getMaxRecNum() > 0) {
                res = res.concat(rec[i].toString() + ", ");
                has_max_rec = true;
            }
        }

        return has_max_rec ? res.substring(0, res.length() - 2) : res.concat("No purchases this month.");
    }
}
