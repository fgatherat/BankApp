package business;


import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable {

    private Map<String, Account> accounts;
    private int number;
    private String firstName;
    private String lastName;

    /**
     * Constructeur paramétré pour la classe Customer. Obligatoire. Représente
     * un client de la banque
     *
     * @param number Le numéro unique d'identification du client
     * @param fn Le prénom du client
     * @param ln Le nom de famille du client
     */
    public Customer(Integer number, String fn, String ln) {
        this.number = number;
        this.firstName = fn;
        this.lastName = ln;
        accounts = new HashMap();
    }

    /**
     * Retourne le compte correspondant au numéro passé en paramètre, ou null si
     * aucun compte ne correspond.
     *
     * @param number Le numéro du compte à rechercher
     * @return Le compte recherché, ou null si aucun compte ne correspond
     */
    public Account getAccountByNumber(String number) {
        return accounts.get(number);
    }

    /**
     * Méthode qui ajoute un compte au client
     *
     * @param number Le numéro du compte
     * @param name Le libellé du compte
     * @param rate Le taux d'intérêt du compte
     * @return Le compte qui a été créé
     */
    public Account addAccount(String number, String name, double rate) {
        Account acc = new Account(number, name, rate, this);
        this.accounts.put(number, acc);
        return acc;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

}