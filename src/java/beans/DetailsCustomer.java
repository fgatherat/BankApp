
import business.Account;
import business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import service.Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */

@Named(value="detailsClient")
@SessionScoped
public class DetailsCustomer implements Serializable {
    
    private Customer customer;
    
    private DataModel<Account> accountsDM;
    
    @Inject Services services;
    public DetailsCustomer() {
        
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String showCustomer(Customer cust){
        if(cust != null){
            customer = cust;
            return "show";
        }else{
            customer = null;
            return "error";
        }
    }
    
    public List<Account> getAccounts(){
        if(customer == null){
            return new ArrayList();
        }
        
        return new ArrayList(customer.getAccounts().values());
    }
}
