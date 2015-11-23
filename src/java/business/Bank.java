package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
public class Bank {
    private int number;
    private String name;
    private ArrayList<Customer> listCustomer;
    private ArrayList<Account> listAccount;
    private Map<Integer, Customer> customers;
    
    public Bank(int number, String name){
        this.number = number;
        this.name = name;
        listAccount = new ArrayList<Account>();
        listCustomer = new ArrayList<Customer> ();
    }
    
    public Account getAccountByNumber(String number) {
        for(int i=0; i<listAccount.size();i++){
            if(listAccount.get(i).getNumber() == number) {
                return listAccount.get(i);
            }
        }
        return null;
    }
    
    public Customer getCustomerByNumber (int number) {
        Customer customer = listCustomer.get(number);
        
        return customer;
    }
    
    public Map<Integer, Customer> getCustomers () { 
        int number = 0;
        for(Customer cust : listCustomer){
            number = number +1; 
            customers.put(number, cust);
         }
        
        return customers;
    }
    
    public Customer addCustomer (int number, String fn, String ln){
        Customer customer = new Customer (number, fn, ln);
        
        listCustomer.add(customer);
        
        return customer;
    }
    
    public void addAccount (String number, String name, double rate, Customer customer) {
        Account account = new Account(customer, number, name, rate);
        
        listAccount.add(account);
    }
}
