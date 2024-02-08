package com.hexaware.main;

import java.util.Scanner;

public class PasswordValidation {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Password: ");
		
		String pwd = sc.next();
		
		String result = ValidatePassword(pwd);
		
		System.out.println(result);
		
		sc.close();
	}


	private static String ValidatePassword(String pwd) {

		if(pwd.length() < 8 || !pwd.matches(".*[A-Z].*") || !pwd.matches(".*[0-9].*")) {
			return "Invalid password";
		}
		
		return "Valid password";
	}

}
