package com.cg.pecunia.service;

import java.util.List;
import java.util.Random;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.dao.AccountDao;
import com.cg.pecunia.dao.AccountDaoMapImp;
import com.cg.pecunia.exception.AccountExcepetion;

public class AccountServiceImp implements AccountService {

	private AccountDao accountdao;

	public AccountServiceImp() {
		accountdao = new AccountDaoMapImp();
	}

	public int addAccount(Account account) throws AccountExcepetion {
		if (validateName(account.getAccountName()))
			throw new AccountExcepetion("Name should have alphabets");
		Random random = new Random();

		int accnumber = random.nextInt(100000000) + 1000000000;
		account.setAccountNumber(accnumber);
		return accnumber;
	}

	public Account updateAccountByNumber(int accountNumber, Account account) throws AccountExcepetion {

		return accountdao.updateAccountByNumber(accountNumber, account);
	}

	public int deleteAccountByNumber(int accountNumber) throws AccountExcepetion {
		//String accnum = String.valueOf(accountNumber);
		//if (accnum.matches("[0-9]{10}"))
			//throw new AccountException("Id should be of 10 digit");
		return accountdao.deleteAccountByNumber(accountNumber);
	}

	public boolean validateName(String accountName) throws AccountExcepetion {
		return accountName.matches("[A-Za-z]+");

	}

	public List<Account> listAccounts() throws AccountExcepetion {
		
		return accountdao.listAccounts();
	}

}
