package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.entity.Account;

public class Bank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account myAccount = new Account();
		
		System.out.println("Enter Account Number: ");
		myAccount.setAccountnumber(sc.nextInt());
		System.out.println("Enter Account Type: ");
		myAccount.setAccounttype(sc.next());
		System.out.println("Enter Account Balance: ");
		myAccount.setAccountbalance(sc.nextDouble());
		System.out.println("Enter Deposit amount: ");
		myAccount.deposit(sc.nextDouble());
		System.out.println("Enter Withdraw amount: ");
		myAccount.withdraw(sc.nextDouble());
		myAccount.calInterest();
		
		sc.close();
	}

}
