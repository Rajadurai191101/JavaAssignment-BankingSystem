package com.hexaware.entity;

public class CurrentAccount extends BankAccount {
	
	private static final double ol = 500;
	
	public CurrentAccount(String accountNumber, String customerName,double balance) {
		super(accountNumber, customerName, balance);
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance()+amount);
		
	}

	@Override
	public void withdraw(double amount) {
		
		double availBalance = getBalance()+ol;
		if(amount <= availBalance) {
			setBalance(getBalance()-amount);
		}
		else {
			System.out.println("Failed!! Exceeds available Balance");
		}		
	}

	@Override
	public void calculate_interest() {
		System.out.println("No interest Calculate for current Account");
		
	}



}
