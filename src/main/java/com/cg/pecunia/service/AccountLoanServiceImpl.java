package com.cg.pecunia.service;

import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.login.AccountException;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.dao.AccountLoanDao;
import com.cg.pecunia.dao.AccountLoanDaoMapImpl;
import com.cg.pecunia.exception.AccountExcepetion;

public class AccountLoanServiceImpl implements AccountLoanService {
	private AccountLoanDao accountLoanDao;
	
	public AccountLoanServiceImpl() {
		accountLoanDao = new AccountLoanDaoMapImpl();
	}
	
	@Override
	/*public int addAccount(Account account) throws AccountExcepetion {
		// TODO Auto-generated method stub
		if(validateName(account.getAccountName()))
			throw new AccountExcepetion("Name should have alphabets");
		Random random=new Random();
		int accnumber=random.nextInt(100000000)+1000000000;
		account.setAccountNumber(accnumber);
		
		return accountLoanDao.addAccount(account);
	}*/
	
	public boolean validateName(String accountName) throws AccountExcepetion {
		return accountName.matches("[A-Za-z]+");
		
	}
	


	public Loan loanRequest(int accountNumber, double amount, int tenure, int creditScore) throws AccountExcepetion {
		
		String number = String.valueOf(accountNumber);
		if(!number.matches("[0-9]{10}"))
				throw new  AccountExcepetion("id should be 10 digit");
		return accountLoanDao.loanRequest(accountNumber, amount, tenure, creditScore);
		
	}
	
	

	public boolean loanApprovalStatus(Loan loan) throws AccountExcepetion {
		
		return accountLoanDao.loanApprovalStatus(loan);
	}
	

	public double updateBalance(Loan loan) throws AccountExcepetion {
		
		return accountLoanDao.updateBalance(loan);
	}

	public ArrayList<Loan> loanApprovalList(Loan loan) throws AccountExcepetion {
		
		return accountLoanDao.loanApprovalList(loan);
	}

	public ArrayList<Loan> loanRejectList(Loan loan) throws AccountExcepetion {
		
		return accountLoanDao.loanRejectList(loan);
	}

	@Override
	public double calculateEmi(Loan loan) throws AccountExcepetion {
	
		return accountLoanDao.calculateEmi(loan);
	}


	
}
