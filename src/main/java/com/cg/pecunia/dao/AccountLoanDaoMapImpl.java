package com.cg.pecunia.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.exception.AccountExcepetion;

public class AccountLoanDaoMapImpl implements AccountLoanDao{
	
	
	
	HashMap<Integer,Loan> map;

	public AccountLoanDaoMapImpl() {
		//map1 = new HashMap<Integer, Account>();
		map = new HashMap<Integer, Loan>();
	}
	
	
	public Loan loanRequest(int accountNumber, double amount, int tenure,int creditScore) throws AccountExcepetion {
		Loan loan;
		if(!map.containsKey(accountNumber)) {
		loan= new Loan();
		loan.setTenure(tenure);
		loan.setAmount(amount);
		loan.setLoanStatus(false);
		loan.setCreditScore(creditScore);
		loan.setAccountNumber(accountNumber);
		map.put(accountNumber, loan);
		}
		
		else
			throw new AccountExcepetion(); 
		
		
		return loan;
		
	}

	public boolean loanApprovalStatus(Loan loan) throws AccountExcepetion {
		if(loan.getCreditScore()>=700 && loan.getCreditScore()<=900) {
			loan.setLoanStatus(true);
			map.put(loan.getId(), loan);
		}
		else
			throw new AccountExcepetion("loan processing ");
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
		if(loan.isLoanStatus()==true) {
			for(Loan l : map.values())
				list.add(l);
		}
			
		return list;
	}

	public ArrayList<Loan> loanRejectList(Loan loan) throws AccountExcepetion {
		
		ArrayList<Loan> list = new ArrayList<Loan>();
		if(!loan.isLoanStatus()) {
			for(Loan l : map.values())
				list.add(l);
		}
		return list;
	}

	@Override
	public double calculateEmi(Loan loan) throws AccountExcepetion {
		if(loan.isLoanStatus()) {
			double d = loan.getAmount()/(loan.getTenure()*12);
			loan.setEmi(d);
			return loan.getEmi();
		}
		else
			throw new AccountExcepetion("loan not granted"); 
		
	}
	

}
