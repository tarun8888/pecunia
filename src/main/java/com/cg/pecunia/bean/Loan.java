package com.cg.pecunia.bean;

public class Loan extends Account {
	private int id;
	
	private int tenure;
	private double amount;
	private double emi;
	private boolean loanStatus;
	private int creditScore;
	
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(boolean loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
