package com.hexaware.entity;

public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String address;
	
	//constructor
	public Customer() {
		
	}
	
	public Customer(int customerId, String firstName, String lastName, String emailAddress, String phoneNumber,
			String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//getters and setters
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//toString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
		
}
