/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
@Named(value="createCustomerBean")
@RequestScoped
public class CustomerCreateBean implements Serializable {
    
}
