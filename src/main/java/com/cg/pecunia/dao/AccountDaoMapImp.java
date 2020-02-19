package com.cg.pecunia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.exception.AccountExcepetion;


public class AccountDaoMapImp  implements AccountDao{
private Map<Integer,Account> map;
public AccountDaoMapImp()
{
	map=new HashMap<Integer,Account> ();
}
public int addAccount(Account account) throws AccountExcepetion {
	if(map.containsKey(account.getAccountNumber()))
		throw new AccountExcepetion("Id already exists");
	else
		map.put( account.getAccountNumber(), account);
	return account.getAccountNumber();



}

public Account updateAccountByNumber(int accountNumber,Account account) throws AccountExcepetion {
	Account updateaccount=map.get(accountNumber);
	System.out.println(updateaccount);
	if(map.containsKey(account.getAccountNumber()))
	{
		
		updateaccount.setAccountName(account.getAccountName());
		updateaccount.setContactNumber(account.getContactNumber());
		updateaccount.setAddress(account.getAddress());
		updateaccount.setAccountNumber(accountNumber);
		
	}
	updateaccount=map.replace(accountNumber, updateaccount);
	return updateaccount;
	
}

public int deleteAccountByNumber(int accountNumber) throws AccountExcepetion {
	if(!map.containsKey(accountNumber))
		map.remove(accountNumber);
	else
		throw new AccountExcepetion("Id not found");
	
	
	return accountNumber;




}
public List<Account> listAccounts() throws AccountExcepetion {
	
	Collection<Account> collection=map.values();
	List<Account> list=new ArrayList<Account>();
	for(Account a:collection)
		list.add(a);
	
	return list;
}
	
	
	}

	

	

	
	


