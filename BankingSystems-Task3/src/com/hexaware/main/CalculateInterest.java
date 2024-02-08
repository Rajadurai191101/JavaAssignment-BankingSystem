package com.hexaware.main;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfCust = sc.nextInt();
		
		for(int cust=1; cust<=noOfCust;cust++) {
			
			System.out.println("Customer "+cust);
			
			double initBal = sc.nextDouble();
			double anIntRate = sc.nextDouble();
			int noOfYears = sc.nextInt();
			
			double futureBalance = initBal * Math.pow((1 + anIntRate/100), noOfYears);
			
			System.out.println("Future Balance for Customer "+cust+" is "+futureBalance);
		}
		sc.close();
	}

}
