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
    private String number;
    private String name;
    private double balance;
    private double rate;

    @Inject Services services;
    public DetailsCompteBean(){}
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    @PostConstruct
    public void detailCompte () {
        Account compte = services.returnCompteEdit();
        setNumber(compte.getNumber());
        setName(compte.getName());
        setBalance(compte.getBalance());
        setRate(compte.getRate());
    }
    
}
