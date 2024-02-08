package com.hexaware.entity;

public class SavingsAccount extends BankAccount {
	
	private double interestRate;
	
	private static double minBal = 1000;
	public SavingsAccount(String accountNumber, String customerName,double balance, double intersestRate) {
		super(accountNumber ,customerName ,balance);
		this.interestRate = intersestRate;
	}

	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance()+amount);
		
	}

	@Override
	public void withdraw(double amount) {
		if(getBalance()-amount >= minBal) {
			setBalance(getBalance()-amount);
		}
		else {
			System.out.println("Insufficient Balance");
		}
			
	}

	@Override
	public void calculate_interest() {
		
		double interest = getBalance()* (interestRate/100); 
		System.out.println("Interest for Savings Account:"+interest);
	}
	
}
