package com.hexaware.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class BankTrans {
	List<BankTrans> transHis = new ArrayList();
	BankTrans bt;

	private String transType;
	private double amount;
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String toString() {
		return transType + " : " + amount ;
	}
	
	public void add() {
		
		Scanner sc = new Scanner(System.in);
		bt = new BankTrans();
		System.out.println("Enter amount");
		double dAmount = sc.nextInt();
		bt.setAmount(dAmount);
		System.out.println("Enter type");
		String transType = sc.next();
		bt.setTransType(transType);
		transHis.add(bt);
	}
	
	public void display() {
		for(BankTrans bt:transHis) {
			System.out.println(transHis);
		}
	}
	
}


public class ListBankTrans {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//List<BankTrans> transHis = new ArrayList();
		
		BankTrans bt = new BankTrans();;
		while(true) {
			System.out.println("1. Deposit / Withdraw");
			System.out.println("2. Display history");
			System.out.println("3. Exit");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				bt.add();
				break;
			case 2:
				bt.display();
				//System.out.println("Thank You");
				break;
			case 3:
				System.out.println("Thank You");
				System.exit(0);
			}
			
		}
		
	}

}
