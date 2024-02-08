package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.AccountDao;
import com.hexaware.dao.CustomerDao;
import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
import com.hexaware.exception.InsufficientFundException;
import com.hexaware.exception.InvalidAccountException;
import com.hexaware.exception.OverDraftLimitExceededException;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
		
		CustomerDao cdao = new CustomerDao();
		AccountDao adao = new AccountDao();
	 	List<Customer> customerList = new ArrayList<>();
	    List<Account> accountList = new ArrayList<>();
	    Customer customer;
	    Account account;
	    Scanner sc = new Scanner(System.in);

	    @Override
	    public void addCustomer() {
	        customer = new Customer();
	        System.out.println("Enter Customer ID:");
	        int customerId = sc.nextInt();
	        customer.setCustomerId(customerId);
	        System.out.println("Enter First Name:");
	        String firstName = sc.next();
	        customer.setFirstName(firstName);
	        System.out.println("Enter Last Name:");
	        String lastName = sc.next();
	        customer.setLastName(lastName);
	        System.out.println("Enter Email Address:");
	        String emailAddress = sc.next();
	        customer.setEmailAddress(emailAddress);
	        System.out.println("Enter Phone Number:");
	        String phoneNumber = sc.next();
	        customer.setPhoneNumber(phoneNumber);
	        System.out.println("Enter Address:");
	        String address = sc.next();
	        customer.setAddress(address);

	        customerList.add(customer);
	        cdao.createCustomer(customer);
	        System.out.println("Customer " + customerId + " added Successfully !!!");
	    }

	    public void viewCustomer() {
	        System.out.println("*** Customer List ****");
	        customerList.forEach((customer) -> System.out.println(customer));
	        cdao.viewCustomerDetails();
	    }

	    public void addAccount() {
	        System.out.println("Enter Customer ID to add an account:");
	        int customerId = sc.nextInt();

	        if (isCustomerPresent(customerId)) {
	            account = new Account();
	            account.setCustomerId(customerId);
	            System.out.println("Enter Account Number:");
	            long accountNumber = sc.nextLong();
	            account.setAccountNumber(accountNumber);
	            System.out.println("Enter Account Type (e.g., Savings, Current):");
	            String accountType = sc.next();
	            account.setAccountType(accountType);
	            System.out.println("Enter Initial Account Balance:");
	            float balance = sc.nextFloat();
	            account.setAccountBalance(balance);

	            accountList.add(account);
	            adao.createAccount(account);
	            System.out.println("Account added Successfully !!!");
	        } else {
	            System.out.println("Customer ID not found.");
	        }
	    }

	    private boolean isCustomerPresent(int customerId) {
	    	for (Customer c : customerList) {
	            if (c.getCustomerId() == customerId) {
	                return true;
	            }
	        }
	        return false;
		}

		public void viewAccount() {
	        System.out.println("*** Account List ****");
	        accountList.forEach((account) -> System.out.println(account));
	    }

	    public void deposit(long accountNumber, float amount) {
	        for (Account acc : accountList) {
	            if (acc.getAccountNumber() == accountNumber) {
	                acc.deposit(amount);
	                System.out.println("Deposit successful. Current balance: " + acc.getAccountBalance());
	                
	            }
	        }
	        System.out.println("Account ID not found.");
	    }

	    public void withdraw(long accountNumber, float amount) {
	        for (Account acc : accountList) {
	            if (acc.getAccountNumber() == accountNumber) {
	                acc.withdraw(amount);
					System.out.println("Withdrawal successful. New balance: " + acc.getAccountBalance());
	                return;
	            }
	        }
	        System.out.println("Account ID not found.");
	    }


	    public void calculateInterest(long accountNumber) {
	        for (Account acc : accountList) {
	            if (acc.getAccountNumber() == accountNumber && acc.getAccountType().equalsIgnoreCase("Savings")) {
	                acc.calculateInterest();
	                System.out.println("Interest calculated and added. New balance: " + acc.getAccountBalance());
	                return;
	            }
	        }
	        System.out.println("Calculated only for savings account");
	    }

	    public void transfer(long fromAccountId, long toAccountId, float amount)
	            throws InsufficientFundException, InvalidAccountException, OverDraftLimitExceededException {
	        Account fromAccount = null;
	        Account toAccount = null;

	        for (Account acc : accountList) {
	            if (acc.getAccountNumber() == fromAccountId) {
	                fromAccount = acc;
	            } else if (acc.getAccountNumber() == toAccountId) {
	                toAccount = acc;
	            }
	            
	            if (fromAccount != null && toAccount != null) {
	                break;
	            }
	        }

	        if (fromAccount == null || toAccount == null) {
	            throw new InvalidAccountException("One or both accounts not found.");
	        }

	        
	        if (fromAccount.getAccountType().equalsIgnoreCase("Current")) {
	            float overdraftLimit = 1000; 
	            if (amount > fromAccount.getAccountBalance() + overdraftLimit) {
	                throw new OverDraftLimitExceededException("Overdraft limit exceeded. Cannot transfer.");
	            }
	        } else if (amount > fromAccount.getAccountBalance()) {
	            throw new InsufficientFundException("Insufficient funds. Cannot transfer.");
	        }

	        fromAccount.withdraw(amount);
	        System.out.println("Transfer successful");

	        toAccount.deposit(amount);
	        System.out.println("Transfer successful.");
	    }


		

}
