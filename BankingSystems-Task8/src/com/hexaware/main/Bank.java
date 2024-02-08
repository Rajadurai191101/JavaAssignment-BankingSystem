package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.entity.Account;
import com.hexaware.entity.Account.CurrentAccount;
import com.hexaware.entity.Account.SavingsAccount;


public class Bank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account ma = new Account();
		
		while(true) {
			System.out.println("1.Savings ACcount");
			System.out.println("2.Current ACcount");
			System.out.println("3.Exit");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				System.out.println("Enter Account Number:");
				int accountNumber = sc.nextInt();
				System.out.println("Enter Account Balance:");
				double accountBalance = sc.nextDouble();
				System.out.println("Enter Interest Rate:");
				double intRate = sc.nextDouble();
				
				SavingsAccount sa = ma.new SavingsAccount(accountNumber, accountBalance, intRate);
				System.out.println("1.Deposit\n2.Withdraw\n3.CalInterest");
				int c = sc.nextInt();
				if(1==c) {
				sa.deposit(sc.nextDouble());}
				if(2==c){
				sa.withdraw(sc.nextDouble());}
				if(3==c) {
				sa.calInterest();}
				break;
				}
			case 2:{
				System.out.println("Enter Account Number:");
				int accountNumber = sc.nextInt();
				System.out.println("Enter Account Balance:");
				double accountBalance = sc.nextDouble();
				System.out.println("Enter OverdraftLimit:");
				double overdraftLimit = sc.nextDouble();
				
				CurrentAccount ca = ma.new CurrentAccount(accountNumber, accountBalance, overdraftLimit);
				System.out.println("1.Deposit\n2.Withdraw");
				
				int c = sc.nextInt();
				if(1==c) {
				ca.deposit(sc.nextDouble());}
				if(2==c) {
				ca.withdraw(sc.nextDouble());}
				break;
			}
			case 3:{
				System.out.println("Thankyou");
				System.exit(0);
			}
			}
			//sc.close();
		}
	}
}