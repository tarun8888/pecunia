package com.cg.pecunia.service;

import java.util.ArrayList;

import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.exception.AccountExcepetion;

public interface AccountLoanService {
	public Loan loanRequest(long accountNumber ,double amount, int tenure,int creditScore) throws AccountExcepetion;
	public boolean loanApprovalStatus(Loan loan) throws AccountExcepetion;
	public double updateBalance(Loan loan) throws AccountExcepetion;
	public ArrayList<Loan> loanApprovalList(Loan loan) throws AccountExcepetion;
	public ArrayList<Loan> loanRejectList(Loan loan) throws AccountExcepetion;

}
