package com.cg.pecunia.dao;

import java.util.List;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountExcepetion;

public interface AccountDao {
	
	public int addAccount(Account account) throws AccountExcepetion;
	public Account updateAccountByNumber(int accountNumber,Account account)throws AccountExcepetion;
	public int deleteAccountByNumber(int accountNumber)throws AccountExcepetion;
	public List<Account> listAccounts() throws AccountExcepetion; 
}
