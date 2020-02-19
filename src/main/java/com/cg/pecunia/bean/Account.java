package com.cg.pecunia.bean;

public class Account {
	
	private int accountNumber;
	private String accountName;
	private long contactNumber;
	private String address;
	private double balance;
	public Account() {
		super();
		
	}
	public Account(String accountName, long contactNumber, String address, double balance) {
		super();
		this.accountName = accountName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}
