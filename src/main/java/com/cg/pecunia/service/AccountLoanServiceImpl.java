package com.cg.pecunia.service;

import java.util.ArrayList;

import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.dao.AccountLoanDao;
import com.cg.pecunia.dao.AccountLoanDaoMapImpl;
import com.cg.pecunia.exception.AccountExcepetion;

public class AccountLoanServiceImpl implements AccountLoanService {
	private AccountLoanDao accountLoanDao;
	
	public AccountLoanServiceImpl() {
		accountLoanDao = new AccountLoanDaoMapImpl();
	}
	

	public Loan loanRequest(long accountNumber, double amount, int tenure, int creditScore) throws AccountExcepetion {
		// TODO Auto-generated method stub
		
		return accountLoanDao.loanRequest(accountNumber, amount, tenure, creditScore);
		
	}

	public boolean loanApprovalStatus(Loan loan) throws AccountExcepetion {
		// TODO Auto-generated method stub
		return accountLoanDao.loanApprovalStatus(loan);
	}

	public double updateBalance(Loan loan) throws AccountExcepetion {
		// TODO Auto-generated method stub
		return accountLoanDao.updateBalance(loan);
	}

	public ArrayList<Loan> loanApprovalList(Loan loan) throws AccountExcepetion {
		// TODO Auto-generated method stub
		return accountLoanDao.loanApprovalList(loan);
	}

	public ArrayList<Loan> loanRejectList(Loan loan) throws AccountExcepetion {
		// TODO Auto-generated method stub
		return accountLoanDao.loanRejectList(loan);
	}

}
