package com.hexaware.entity;

public abstract class BankAccount {
	
	private String accountNumber;
	private String customerName;
	private double balance;
	
	public BankAccount() {
		
	}
	
	public BankAccount(String accountNumber, String customerName, double balance) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void deposit(double amount);
	
	public abstract void withdraw(double amount);

	public abstract void calculate_interest();

	public void displayInfo() {
		System.out.println("acc number:"+accountNumber);
		System.out.println("cust name:"+customerName);
		System.out.println("balance:"+balance);
	}

	
	
	
}
