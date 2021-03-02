package mx.tec.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MonthReport {
    
    private LinkedList<Purchase> purchases;
    private Map<String, Integer> receivers;
    private Purchase maxPurch, minPurch;
    private double average;

    public MonthReport() {
        this.purchases = new LinkedList<Purchase>();
        this.receivers = new HashMap<String, Integer>();
    }

    public void finish() {
        double cnt = 0;
        for (Purchase prod : this.purchases) {
            cnt += prod.getPrice();
        }
        this.average = cnt / this.purchases.size();
    }

    public void addPurchase(Purchase purch) {
        // * check for max purchase
        if (this.purchases.size() == 0 || maxPurch.getPrice() < purch.getPrice()) {
            maxPurch = purch;
        }
        
        // * check for min purchase
        if (this.purchases.size() == 0 || purch.getPrice() < minPurch.getPrice()) {
            minPurch = purch;
        }

        // * update receiver info
        if (this.receivers.containsKey(purch.getReceiver())) {
            this.receivers.put(purch.getReceiver(), this.receivers.get(purch.getReceiver()) + 1);
        } else {
            this.receivers.put(purch.getReceiver(), 0);
        }

        this.purchases.add(purch);
    }

    public Purchase getMaxPurch() {
        return maxPurch;
    }

    public Purchase getMinPurch() {
        return minPurch;
    }

    public double getAverage() {
        return average;
    }

    public Map<String, Integer> getReceivers() {
        return receivers;
    }

    public LinkedList<Purchase> getPurchases() {
        return purchases;
    }

}
