/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;


import business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import service.*;
/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */

@Named(value="customerLISBean")
@RequestScoped
public class CustomerLISBean implements Serializable {
   
    private DataModel<Customer> customersDM;

    @Inject Services services;
    public CustomerLISBean() {
        
    }
    
    public DataModel<Customer> getCustomersDM() {
        customersDM = new ListDataModel<>();
        customersDM.setWrappedData(services.getCustomersList());
        return customersDM;
    }
}
