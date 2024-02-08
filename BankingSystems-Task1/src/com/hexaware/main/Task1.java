package com.hexaware.main;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Credit Score :");
		int creditScore = sc.nextInt();
		System.out.println("Enter annual Income");
		double annualIncome = sc.nextInt();
		if(creditScore > 700 && annualIncome >= 50000) {
			System.out.println("The customer is Eligible for loan");
		}
		else {
			System.out.println("The customer is not eligible");
		}
		sc.close();

	}

}
