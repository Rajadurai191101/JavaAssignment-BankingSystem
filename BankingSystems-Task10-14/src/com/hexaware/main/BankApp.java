package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.CustomerServiceProviderImpl;
import com.hexaware.controller.ICustomerServiceProvider;
import com.hexaware.exception.InputMismatchException;
import com.hexaware.exception.InsufficientFundException;
import com.hexaware.exception.InvalidAccountException;
import com.hexaware.exception.OverDraftLimitExceedException;
import com.hexaware.exception.OverDraftLimitExceededException;

public class BankApp {

	public static void main(String[] args) throws InputMismatchException, OverDraftLimitExceedException {
		ICustomerServiceProvider icust = new CustomerServiceProviderImpl();
		Scanner sc= new Scanner(System.in);
		String ch=null;
		do {
			System.out.println("1.Addcustomer\n2.ViewCustomer\n3.AddAccount\n4.ViewAccount\n5.Bankoperations");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				icust.addCustomer();
				break;
			case 2:
				icust.viewCustomer();
				break;
			case 3:
				icust.addAccount();
				break;
			case 4:
				icust.viewAccount();
				break;
			case 5:
				bankOperation(icust);
				break;
			default:
				System.out.println("Enter valid choice");
			}
			System.out.println("Do u wnt to continue ? Y or y");
			ch=sc.next();
		}while(ch.equals("y") || ch.equals("Y"));
		System.exit(0);
	}
	public static void bankOperation(ICustomerServiceProvider icust) throws OverDraftLimitExceedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter accId");
		long  accId = sc.nextLong();
		
		System.out.println("1.Deposit\n2.Withdraw\n3.CalculateInterest\n4.Transfer");
		
		int ch = sc.nextInt();
		
		try {
			switch(ch) {
			case 1:
				System.out.println("Enter amount");
				float depAmount = sc.nextFloat();
				icust.deposit(accId, depAmount);
				break;
			case 2:
				System.out.println("Enter Amount");
				float withAmount = sc.nextFloat();
				icust.withdraw(accId, withAmount);
			case 3:
				icust.calculateInterest(accId);
				break;
			case 4:
				System.out.println("Enter toAccId");
				long toAccId = sc.nextLong();
				System.out.println("Enter amount");
				float amount = sc.nextFloat();
				icust.transfer(accId, toAccId, amount);
				break;
			}
		}catch(InsufficientFundException | InvalidAccountException e){
			System.out.println("Failed"+e.getMessage());
		} catch (OverDraftLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



