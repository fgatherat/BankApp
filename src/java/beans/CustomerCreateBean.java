/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import business.Customer;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import service.Services;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
@Named(value="customerBean")
@RequestScoped
public class CustomerCreateBean implements Serializable {
    
    private Integer number;
    private String lastName;
    private String firstName;
    
    @Inject Services services;
    public CustomerCreateBean(){
    
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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
    
    public String add(){
        try {
           services.saveCustomer(number, firstName, lastName);
        
            return "success"; 
        }catch (Exception e ) {
            return "error";
        }
        
    }
    
}
