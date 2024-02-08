package com.hexaware.entity;

public class Account {
	private int accountNumber;
	private String accountType;
	private double accountBalance;
	
	public Account(int accountNumber, double accountBalance) {
		this.accountNumber=accountNumber;
		this.accountBalance=accountBalance;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
	
	
	public void deposit(float amount) {
		deposit((double) amount);
	}
	public void deposit(int amount) {
		deposit((float) amount);
	}
	public void deposit(double amount) {
		if(amount > 0) {
			accountBalance += amount;
			System.out.println("Amount deposited.CurrentBalance "+accountBalance);
		}else {
			System.out.println("Invalid amount");
		}
	}
	
	
	public void withdraw(float amount) {
		withdraw((double) amount);
	}
	public void withdraw(int amount) {
		withdraw((float) amount);
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
	
	
	
	
	
	public class SavingsAccount extends Account{
		private double intRate;
		
		public SavingsAccount(int accountNumber, double accountBalance,double intRate) {
			super(accountNumber,accountBalance);
			this.intRate = intRate;
		}
		
		public void calInterest() {
			double interest = (intRate/100)*getAccountBalance();
			
			//setAccountBalance(interest + getAccountBalance());
			System.out.println(interest);
		}
	}
	
	public class CurrentAccount extends Account{
		
		private double overdraftLimit;
		private final double MAX_OL =1000.0;
		public CurrentAccount(int accountNumber, double accountBalance, double overdraftLimit) {
			super(accountNumber, accountBalance);
			this.overdraftLimit=Math.min(overdraftLimit, MAX_OL);
		}
		
		public void withdraw(double amount) {
			if(amount>0 && amount<(getAccountBalance()+overdraftLimit)) {
				setAccountBalance(getAccountBalance()-amount);
				System.out.println(accountBalance);
			}
			else {
				System.out.println("Invalid amount");
			}
		}
		
	}
}
