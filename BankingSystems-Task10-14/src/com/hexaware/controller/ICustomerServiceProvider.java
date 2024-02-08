package com.hexaware.controller;

import com.hexaware.exception.InsufficientFundException;
import com.hexaware.exception.InvalidAccountException;
import com.hexaware.exception.OverDraftLimitExceededException;

public interface ICustomerServiceProvider {
	
	public void deposit(long accountNumber, float amount);

    void withdraw(long accountNumber, float amount);

    void transfer(long fromAccountNumber, long toAccountNumber, float amount) throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException;
    
    void calculateInterest(long accountId);

	void addCustomer();
	void viewCustomer();
	void addAccount();
	void viewAccount();
}
