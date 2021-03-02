package mx.tec.entities;

import java.util.LinkedList;

public class Student {

    private LinkedList<Purchase> purchases;
    private String name, lname, id, email;

    public Student() {
        this.purchases = new LinkedList<Purchase>();
    }


    public Student(String name, String lname, String id, String email, LinkedList<Purchase> purchases) {
        this.name = name;
        this.lname = lname;
        this.id = id;
        this.email = email;
        this.purchases = purchases;
    }

    public LinkedList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(LinkedList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
