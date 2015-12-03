package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
public class Bank implements Serializable {

    private HashMap<Integer, Customer> customers;
    private HashMap<String, Account> accounts;
    private int number;
    private String name;

    
    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    
    public Account getAccountByNumber(String number) {
        return this.accounts.get(number);
    }

    
    public Customer getCustomerByNumber(int number) {
        return this.customers.get(number);
    }

    
    public Customer addCustomer(int number, String fn, String ln) throws Exception {
        Customer cust = null;

        if (!customers.containsKey(number)) {
            cust = new Customer(number, fn, ln);
            customers.put(number, cust);
        } else {
            throw new Exception("Erreur d'ajout");
        }

        return cust;
    }
    
    public Account addAccount(String number, String name, double rate, Customer customer) throws Exception {
        Account acc = null;

        if (!customers.containsValue(customer)) {
            throw new Exception("Erreur");
        }

        if (!accounts.containsKey(number)) {
            acc = customer.addAccount(number, name, rate);
            this.accounts.put(number, acc);
        } else {
            throw new Exception("Le compte existe déjà");
        }

        return acc;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

}
