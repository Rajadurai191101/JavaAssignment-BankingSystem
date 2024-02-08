package com.hexaware.entity;

public class CurrentAccount extends Account{
	
	private double overdraftLimit = 100;
	public CurrentAccount(long accountNumber,double accountBalance, double overdraftLimit) {
		super(accountNumber, "Current", accountBalance);
		this.overdraftLimit = overdraftLimit;
	}
	
	public double getOverdraftLimit() {
		return overdraftLimit;
	}
	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	public void withdraw(float amount) {
		if(amount>(getAccountBalance()+ overdraftLimit)) {
			System.out.println("Withdraw exceeds");
		}
		else {
			setAccountBalance(getAccountBalance()-amount);
			System.out.println("Withdrawal Success.current Bal:"+getAccountBalance());
		}
	}

	@Override
	public String toString() {
		return "CurrentAccount [overdraftLimit=" + overdraftLimit + "]";
	}
}
