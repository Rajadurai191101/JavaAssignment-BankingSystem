package com.hexaware.entity;

public class SavingsAccount extends Account {
	
	private double interestRate;
	private static final float MinBalance = 500;
	
	public SavingsAccount(long accountNumber,double accountBalance,double interestRate) {
		super(accountNumber,"Savings",accountBalance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	public void calculateInterest() {
		
		double interest = this.getAccountBalance()* (interestRate/100);
		this.setAccountBalance(this.getAccountBalance()+interest);
		System.out.println("Interest for Savings Account:"+interest);
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
		
}
