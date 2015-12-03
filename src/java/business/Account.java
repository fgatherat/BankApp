package business;

import java.io.Serializable;

public class Account implements Serializable{

	private String number;
	private String name;
	private double balance = 0;
	private double rate = 0.001;
	private Customer customer;

	
	public Account(String number, String name, double rate, Customer customer) {
            this.number = number;
            this.name = name;
            this.rate = rate;
            this.customer = customer;        
	}

	public void credit(double amount) throws Exception {
            if(amount > 0){
                this.balance += amount;
            }else{
                throw new Exception("Erreur");
            }
	}

	
	public void debit(double amount) throws Exception{
            if(this.balance - amount < 0){
                throw new Exception("Erreur");
            }else if(amount < 0){
                throw new Exception("Erreur");
            }else{
                this.balance -= amount;
            }
	}

	
	public static void transfer(double amount, Account source, Account target) throws Exception{
            if(amount <= 0){
                throw new Exception("Erreur, il faut augmenter de 0 au moins");
            }
            
            source.debit(amount);
            target.credit(amount);
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

}