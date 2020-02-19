package com.cg.pecunia.service;



import java.util.List;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountExcepetion;


public interface AccountService {
	
	public int addAccount(Account account) throws AccountExcepetion;
	
	public Account updateAccountByNumber(int accountNumber,Account account)throws AccountExcepetion;
	
	public int deleteAccountByNumber(int accountNumber)throws AccountExcepetion;

	public boolean validateName(String accountName)throws AccountExcepetion;
	
	public List<Account> listAccounts() throws AccountExcepetion; 
}
