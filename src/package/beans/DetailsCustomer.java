
import business.Customer;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class DetailsCustomer implements Serializable {
    
    private int number;
    private String lastName;
    private String firstName;
    
    //private DataModel<Customer> customerDM;

    Customer cust;
    
    @Inject Services services;
    public DetailsCustomer() {
        
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String detailCust () {
        cust = new Customer(getNumber(), getFirstName(), getLastName());
        return "detailsDuClient";
    }
        
   /* public DataModel<Customer> getCustomer (){
        customerDM = new ListDataModel<>();
        customerDM.setWrappedData(services.getCustomer());
        return customerDM;
    }*/
}
