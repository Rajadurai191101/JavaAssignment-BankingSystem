package com.hexaware.entity;

public class Account {
	
	private static long lastAccNo = 1000;
	private long accountNumber;
	private String accountType;
	private double accountBalance;
	private int customerId;
	
	public Account(long accountNumber, String accountType, double accountBalance) {
		this.accountNumber = ++lastAccNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", customerid=" + customerId + "]";
	}
	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
	public void deposit(double nextDouble) {
		// TODO Auto-generated method stub
		
	}
	public void withdraw(double nextDouble) {
		// TODO Auto-generated method stub
		
	}
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
