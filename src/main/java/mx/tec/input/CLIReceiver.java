package mx.tec.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import mx.tec.entities.Purchase;
public class CLIReceiver implements DataReceiver {

    private Scanner sc;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public CLIReceiver() {
        System.out.println("Input requested data as follows:");
        sc = new Scanner(System.in);
    }

    public String getStudName() {
        System.out.print("Name: ");
        return sc.nextLine();

    }

    public String getStudLastName() {
        System.out.print("Last name: ");
        return sc.nextLine();
    }

    public String getStudId() {
        System.out.print("ID: ");
        return sc.nextLine();
    }

    public String getStudEmail() {
        System.out.print("Email: ");
        return sc.nextLine();
    }

    public String getPurchType() {
        System.out.print("type [G - General (default) | F - Fixed]: ");
        String type = sc.nextLine();
        if (type.equals("G") || type.equals("General") || type.equals("")) {
            return "General";
        } else if (type.equals("F") || type.equals("Fixed")) {
            return "Fixed";
        } else {
            System.out.println("Invalid purchase type!");
            return getPurchType();
        }
    }

    public String getPurchName() {
        System.out.print("name: ");
        return sc.nextLine();
    }

    public String getPurchCurrency() {
        System.out.print("currency [ m - mxn (default) | u - usd | b - brl]: ");
        String type = sc.nextLine();
        if (type.equals("mxn") || type.equals("m") || type.equals("")) {
            return "mxn";
        } else if (type.equals("usd") || type.equals("u")) {
            return "usd";
        } else if (type.equals("brl") || type.equals("")) {
            return "brl";
        } else {
            System.out.println("Invalid currency type.");
            return getPurchCurrency();
        }
    }

    public int getPurchNum() {
        System.out.print("How many products are there to input? (default: 1): ");
        String num_prod_str = sc.nextLine();
        
        if (num_prod_str.equals("")) {
            return 1;
        } else {
            try {
                return Integer.valueOf(num_prod_str);   
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
                return getPurchNum();
            }
        }    
    }

    public double getPurchPrice() {
        System.out.print("price: ");
        String price = sc.nextLine();
        
        try {
            return Double.valueOf(price);   
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return getPurchPrice();
        } 
    }

    public String getPurchReceiver() {
        System.out.print("receiver: ");
        return sc.nextLine();
    }
    
    
    public String getPurchDate() {
        System.out.print("date (dd/MM/yyyy) (default: today's date): ");
        String date = sc.nextLine();
        if (date.equals("")) {
            String[] raw_date = LocalDate.now().toString().split("-");
            return raw_date[1] + "/" + raw_date[2] + "/" + raw_date[0];
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
            return date;
        } catch (ParseException pe) {
            System.out.println("Invalid date format");
            return getPurchDate();
        }
    }


    int num_prod;
    public LinkedList<Purchase> getPurchases() {
        System.out.println("Input the purchases data as follows.");
        
        LinkedList<Purchase> purchases = new LinkedList<Purchase>();

        num_prod = getPurchNum();

        for (int i = 0; i < num_prod; i++) {
            String type, name, currency, receiver, date;
            double price;

            System.out.printf("====== Purchase %d ======\n", i+1);

            type = getPurchType();
            name = getPurchName();
            currency = "mxn";
            price = getPurchPrice();
            receiver = getPurchReceiver();
            date = getPurchDate();
            
            purchases.add(new Purchase(type, name, price, currency, receiver, date));
        }

        return purchases;
    }

    public void finish() {
        System.out.println("Total de compras capturadas: " + this.num_prod);
    }
}
