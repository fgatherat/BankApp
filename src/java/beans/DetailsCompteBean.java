/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import business.Account;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.Services;

/**
 *
 * @author Francois Gatherat <francois.gatherat@he-arc.ch>
 */
@Named(value="detailsCompte")
@SessionScoped
public class DetailsCompteBean implements Serializable{
    private Account account;

    @Inject Services services;
    public DetailsCompteBean(){}
    
  public String showAccount(Account account){
        if(account != null){
            this.account = account;
            return "show";
        }else{
            this.account = null;
            return "error";
        }
            
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }  
    
}
