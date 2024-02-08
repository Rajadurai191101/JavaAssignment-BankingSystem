package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.entity.BankAccount;
import com.hexaware.entity.CurrentAccount;
import com.hexaware.entity.SavingsAccount;

public class BankOperation {
	public void operation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Savings Account\n2.Current Account");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			BankAccount sa = createSavings();
			subOp(sa);
			break;
		case 2:
			BankAccount ca = createCurrent();
			subOp(ca);
			break;
		default:
			System.out.println("choose the correct choice");
			sc.close();
		}
	}

	public BankAccount createSavings() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter AccountNumber:");
		String accountNumber = sc.next();
		System.out.println("Enter customer Name:");
		String customerName = sc.next();
		System.out.println("Enter Initial Balance");
		double initBalance = sc.nextDouble();
		System.out.println("Enter the interest Rate");
		double intRate = sc.nextDouble();
		sc.close();
		return new SavingsAccount(accountNumber,customerName,initBalance,intRate);
		
	}
	

	public BankAccount createCurrent() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter AccountNumber:");
		String accountNumber = sc.next();
		System.out.println("Enter customer Name:");
		String customerName = sc.next();
		System.out.println("Enter Initial Balance");
		double initBalance = sc.nextDouble();
		
		return new CurrentAccount(accountNumber,customerName,initBalance);
	}
	
	public void subOp(BankAccount ba) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Deposit\n2.Withdraw\n3.Display\n4.Cal Interest\n5.Exit");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				ba.deposit(sc.nextDouble());
				break;
			case 2:
				ba.withdraw(sc.nextDouble());
				break;
			case 3:
				ba.displayInfo();
				break;
			case 4:
				if(ba instanceof SavingsAccount) {
					ba.calculate_interest();
				}else {
					System.out.println("interest only for savings Account");
				}
				break;
			case 5:
				System.out.println("Exit");
				sc.close();
				System.exit(0);
			}
		}while(true);
	}
	
}
