package com.cg.pecunia.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.exception.AccountExcepetion;

public class AccountLoanDaoMapImpl implements AccountLoanDao{
	
	
	//HashMap<Integer, Account> map1;
	HashMap<Integer,Loan> map2;

	public AccountLoanDaoMapImpl() {
		//map1 = new HashMap<Integer, Account>();
		map2 = new HashMap<Integer, Loan>();
	}
	
	/*public int addAccount(Account account) throws AccountExcepetion {
		if(map1.containsKey(account.getAccountNumber()))
			throw new AccountExcepetion("Id already exists");
		else
			map1.put( account.getAccountNumber(), account);
		return account.getAccountNumber();

	}*/
	
	public Loan loanRequest(int accountNumber, double amount, int tenure,int creditScore) throws AccountExcepetion {
		Loan loan;
		if(!map2.containsKey(accountNumber)) {
		loan= new Loan();
		loan.setTenure(tenure);
		loan.setAmount(amount);
		loan.setLoanStatus(false);
		loan.setCreditScore(creditScore);
		map2.put(accountNumber, loan);
		}
		
		else
			throw new AccountExcepetion(); 
		
		
		return loan;
		
	}

	public boolean loanApprovalStatus(Loan loan) throws AccountExcepetion {
		if(loan.getCreditScore()>=700 && loan.getCreditScore()<=900) {
			loan.setLoanStatus(true);
			map2.replace(loan.getAccountNumber(), loan);
		}
		else
			throw new AccountExcepetion("loan is processing ");
		return loan.isLoanStatus();
	}

	public double updateBalance(Loan loan) throws AccountExcepetion {
		
		if(loan.isLoanStatus())
			loan.setBalance(loan.getAmount()+loan.getBalance());
		else
			throw new AccountExcepetion("loan is under process");
		return loan.getBalance();
	}

	public ArrayList<Loan> loanApprovalList(Loan loan) throws AccountExcepetion {
		
		ArrayList<Loan> list = new ArrayList<Loan>();
		if(loan.isLoanStatus()) {
			for(Loan l : map2.values())
				list.add(l);
		}
			
		return list;
	}

	public ArrayList<Loan> loanRejectList(Loan loan) throws AccountExcepetion {
		
		ArrayList<Loan> list = new ArrayList<Loan>();
		if(!loan.isLoanStatus()) {
			for(Loan l : map2.values())
				list.add(l);
		}
		return list;
		
	}

	@Override
	public double calculateEmi(Loan loan) throws AccountExcepetion {
		// TODO Auto-generated method stub
		if(loan.isLoanStatus())
			return loan.getAmount()/(loan.getTenure()*12);
		else
			throw new AccountExcepetion("loan not granted"); 
		
	}
	

}
