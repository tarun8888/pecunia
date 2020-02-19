package com.cg.pecunia.bean;

public class Account {
	
	private int accountNumber;
	private String accountName;
	private long conactNumber;
	private String address;
	private double balance;
	public Account(String accountName, long conactNumber, String address, double balance) {
		super();
		this.accountName = accountName;
		this.conactNumber = conactNumber;
		this.address = address;
		this.balance = balance;
	}
	public Account() {
		super();
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
	public long getConactNumber() {
		return conactNumber;
	}
	public void setConactNumber(long conactNumber) {
		this.conactNumber = conactNumber;
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
