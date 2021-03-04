package mx.tec.input;

import java.util.LinkedList;

import mx.tec.entities.Purchase;

public interface DataReceiver {
    public String getStudName();

    public String getStudLastName();
    
    public String getStudId();

    public String getStudEmail();

    public String getPurchType();

    public String getPurchName();

    public String getPurchCurrency();

    public int getPurchNum();

    public double getPurchPrice();

    public String getPurchReceiver();
    
    public String getPurchDate();

    public LinkedList<Purchase> getPurchases();

    public void finish();

}
