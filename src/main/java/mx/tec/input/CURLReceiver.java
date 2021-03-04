package mx.tec.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import mx.tec.entities.Purchase;
import mx.tec.prefs.UserPrefences;

public class CURLReceiver implements DataReceiver {
    
    private InputStream is;
    private JSONObject json;
    private LinkedList<Purchase> purchases;
    private Object[] purches;
    private int curr;

    public CURLReceiver(UserPrefences prefs) {
        prefs.fetchSource();
        try {
            is = new URL(prefs.getSource()).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String json_str = readAllJSON(rd);
            JSONParser parser = new JSONParser();
            this.json = (JSONObject) parser.parse(json_str);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String readAllJSON(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
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
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

  
}
