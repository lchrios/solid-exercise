package mx.tec.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import mx.tec.entities.Purchase;
import mx.tec.prefs.UserPrefences;

public class FileReceiver implements DataReceiver {

    File file;
    FileReader fr;
    JSONObject json;
    LinkedList<Purchase> purchases;
    Object[] purches;
    int curr;

    public FileReceiver(UserPrefences prefs) {
        // * Ask user from where the file input is
        prefs.fetchSource();
        JSONParser parser = new JSONParser();
        this.file = new File(prefs.getSource());

        try {
            this.fr = new FileReader(this.file);
            this.json = (JSONObject) parser.parse(this.fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getStudName() {
        return json.get("name").toString();
    }

    public String getStudLastName() {
        return json.get("lastname").toString();
    }

    public String getStudId() {
        return json.get("id").toString();
    }

    public String getStudEmail() {
        return json.get("email").toString();
    }

    public String getPurchType() {
        return ((JSONObject) this.purches[this.curr]).get("type").toString();
    }

    public String getPurchName() {
        return ((JSONObject) this.purches[this.curr]).get("name").toString();
    }

    public String getPurchCurrency() {
        return ((JSONObject) this.purches[this.curr]).get("currency").toString();
    }

    public int getPurchNum() {
        return this.purches.length;
    }

    public double getPurchPrice() {
        return Double.valueOf(((JSONObject) this.purches[this.curr]).get("price").toString());
    }

    public String getPurchReceiver() {
        return ((JSONObject) this.purches[this.curr]).get("receiver").toString();
    }

    public String getPurchDate() {
        return ((JSONObject) this.purches[this.curr]).get("date").toString();
    }

    public LinkedList<Purchase> getPurchases() {
        JSONArray allpurch = (JSONArray) json.get("purchases");
        this.purches = allpurch.toArray();
        purchases = new LinkedList<Purchase>();
        for (this.curr = 0; curr < purches.length; curr++) {
            String type, name, currency, receiver, date;
            double price;

            type = getPurchType();
            name = getPurchName();
            currency = "mxn";
            price = getPurchPrice();
            receiver = getPurchReceiver();
            date = getPurchDate();

            Purchase purch = new Purchase(type, name, price, currency, receiver, date);

            this.purchases.add(purch);
        }
        return this.purchases;
    }

    public void finish() {
        try {
            this.fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        
}
