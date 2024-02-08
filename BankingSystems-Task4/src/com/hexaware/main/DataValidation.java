package com.hexaware.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataValidation {

	public static void main(String[] args) {
		Map<String, Double> accounts = new HashMap<>();
        accounts.put("1357908642", 5000.0);
        accounts.put("1234567890", 10500.0);
        accounts.put("8905671234", 2000.0);
        accounts.put("3214658709", 3500.0);
        
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.println("Enter the accountNumber: ");
        	String accountNumber = sc.next();
        	if(accounts.containsKey(accountNumber)) {
        		double balance = accounts.get(accountNumber);
        		System.out.println("Current Balance is "+balance);
        	}
        	else {
        		System.out.println("Invalid Account Number. Try again later...");
        	}
        	sc.close();
        	System.exit(0);
        }
	}

}
