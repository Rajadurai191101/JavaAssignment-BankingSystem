package com.hexaware.main;

import java.util.Scanner;

public class AtmTransaction {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the InitialBalance");
		double currentBal = sc.nextDouble();
		
		System.out.println("ATM TRANSACTION");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:{
			System.out.println("Current Balance is "+currentBal);
			break;
		}
		case 2:{
			System.out.println("Enter the amount");
			double withAmount = sc.nextDouble();
			if(withAmount > currentBal) {
				System.out.println("Amount is insufficient");
			}
			else if(withAmount % 100 !=0 && withAmount % 500 !=0) {
				System.out.println("withdrawal amount should be multiples of 100 or 500");
			} 
			else {
				currentBal -= withAmount;
				System.out.println("Withdraw Successfull");
				System.out.println("Remaining Balance is "+currentBal);
			}
			break;
		}
		case 3:{
			System.out.println("Enter the amount");
			double depAmount = sc.nextDouble();
			if(depAmount > 0) {
				currentBal += depAmount;
				System.out.println("The amount "+depAmount+" is deposited");
				System.out.println("Current Balance is "+currentBal);
			}
			else {
				System.out.println("Invalid amount. Transaction Failed");
			}
			break;
		}
		default:{
			System.out.println("Choose the correct choice");
			break;
		}
		}
		sc.close();
	}

}
