package com.cg.pecunia.bean;

public class Loan extends Account {
	private int tenure;
	private double amount;
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
	

}
