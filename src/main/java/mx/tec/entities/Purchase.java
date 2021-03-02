package mx.tec.entities;

public class Purchase {

    private double price;
    private String 
        type, 
        name, 
        currency, 
        receiver, 
        date;
    
    public Purchase(String type, String name, double price, String currency, String receiver, String date) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.receiver = receiver;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
}
