package mx.tec.input;

import java.util.LinkedList;

import mx.tec.entities.Purchase;

public interface DataReceiver {
    String getStudName();

    String getStudLastName();
    
    String getStudId();

    String getStudEmail();

    LinkedList<Purchase> getPurchases();

    void finish();

}
