package com.hexaware.entity;

public class Account {
	
	private int accountNumber;
	private String accountType;
	private double accountBalance;
	
	public int getAccountnumber() {
		return accountNumber;
	}
	public void setAccountnumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccounttype() {
		return accountType;
	}
	public void setAccounttype(String accountType) {
		this.accountType = accountType;
	}
	
	public double getAccountbalance() {
		return accountBalance;
	}
	public void setAccountbalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			accountBalance += amount;
			System.out.println("Amount deposited.CurrentBalance "+accountBalance);
		}else {
			System.out.println("Invalid amount");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= accountBalance) {
			accountBalance -= amount;
			System.out.println("Amount withdrawn. CurrentBalance "+accountBalance);
		}
		else {
			System.out.println("Insufficient amount");
		}
	}
	
	public void calInterest() {
		if("savings".equalsIgnoreCase(accountType)) {
			double intAmount = (4.5/100) * accountBalance;
			System.out.println("Interest "+intAmount);
		}
		else {
			System.out.println("Wrong accountType");
		}
		
	}
	
	public String toString() {
		return "[" + accountNumber +","+accountType+","+accountBalance+"]";
		
	}
}
