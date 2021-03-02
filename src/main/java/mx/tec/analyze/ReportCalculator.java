package mx.tec.analyze;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import mx.tec.entities.Purchase;
import mx.tec.entities.Student;

public class ReportCalculator {


    private int today_purchases;
    private LinkedList<Purchase> purchByMonth, today_purch_list;
    private Map<String, Integer> receivers;
    private Student stud;
    private String today_date_str;


    public ReportCalculator(Student stud) {
        this.purchByMonth = new LinkedList<Purchase>();
        this.today_purch_list = new LinkedList<Purchase>();
        this.receivers = new HashMap<String, Integer>();
        
        this.stud = stud;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        this.today_date_str = formatter.format(new Date());
    }

    public String calculate() {
        Purchase[] purchases = (Purchase[]) stud.getPurchases().toArray();


        return "";
    }
}
