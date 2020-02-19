package com.cg.pecunia.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pecunia.bean.Account;
import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.exception.AccountExcepetion;
import com.cg.pecunia.service.AccountLoanService;
import com.cg.pecunia.service.AccountLoanServiceImpl;
import com.cg.pecunia.service.AccountService;
import com.cg.pecunia.service.AccountServiceImp;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();
		Loan loan = null;
		ArrayList<Loan> list;
		AccountLoanService accountLoanService = new AccountLoanServiceImpl();
		AccountService accountService = new AccountServiceImp();
		while(true) {
			System.out.println("\n1. Add Account");
			System.out.println("2. Update Account");
			System.out.println("3. Delete Account");
			System.out.println("4. request Loan");
			System.out.println("5. loan status");
			System.out.println("6. update balance");
			System.out.println("7. calculate EMI");
			System.out.println("8. loan approval list");
			System.out.println("9. loan rejected list");
			System.out.println("10. exit");
			
			
			System.out.println("\nenter choice");
			int choice = scanner.nextInt();
			switch(choice) {
			
			case 1:
				try
				{
					
					System.out.println(account);
					System.out.println("Please Enter account Name");
					String name = scanner.nextLine();
					account.setAccountName(name);
					scanner.nextLine();
					System.out.println("Please Enter Address");
					String address = scanner.nextLine();
					account.setAddress(address);
					System.out.println("Please Enter Contact");
					long contact=scanner.nextLong();
					account.setContactNumber(contact);
	          	
					
				
					int accnumber = accountService.addAccount(account); 
					
					System.out.println("accountNumber = "+accnumber);
					
					
				
				}
				catch(AccountExcepetion e)
				{
					System.err.println(e.getMessage());
				}
				break;
			
			case 2:
				try
				{
					System.out.println(account);
					System.out.println("Please Enter account Number");
					int accountNumber=scanner.nextInt();
					scanner.nextLine();
				
					System.out.println("Please Enter account Name");
					String name = scanner.nextLine();
				      account.setAccountName(name);
					System.out.println("Please Enter Address");
					String address = scanner.nextLine();
					account.setAddress(address);
					System.out.println("Please Enter Contact");
					long contact=scanner.nextLong();
					account.setContactNumber(contact);
					account=accountService.updateAccountByNumber(accountNumber,account);
					System.out.println("updated details");
					System.out.println("name = "+name);
					System.out.println("contact = "+contact);
					System.out.println("address = "+address);
				}
				catch(AccountExcepetion e)
				{
					System.err.println(e.getMessage());
				}
				break;
		
			case 3:
				try
				{
					System.out.println("Please Enter account number");
					int accountNumber=scanner.nextInt();
					
					System.out.println("deleted account sucessfully! "+accountService.deleteAccountByNumber(accountNumber));
					
					
				}
				catch(AccountExcepetion e)
				{
					System.err.println(e.getMessage());
				}break;
				
			case 4: 
				try {
					loan = new Loan();
					System.out.println("enter account number");
					int accountNumber = scanner.nextInt();
					loan.setAccountNumber(accountNumber);
					System.out.println("enter loan amount");
					double amount = scanner.nextDouble();
					loan.setAmount(amount);
					System.out.println("enter tenure");
					int tenure = scanner.nextInt();
					loan.setTenure(tenure);
					System.out.println("enter credit score");
					int creditScore = scanner.nextInt();
					loan.setTenure(tenure);
					loan = accountLoanService.loanRequest(accountNumber, amount, tenure, creditScore);
					System.out.println("requested loan of "+loan.getAmount()+" for "+loan.getTenure()+" years");
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
			
			case 5: 
				try {
					if(accountLoanService.loanApprovalStatus(loan))
						System.out.println("loan approved");
					else
						System.out.println("loan not approved");
					
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
			
			case 6: 
				try {
					double balance = accountLoanService.updateBalance(loan);
					System.out.println("updated balance = "+balance);
	
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
			
			case 7:
				try {
					double emi = accountLoanService.calculateEmi(loan);
					System.out.println("emi = "+emi);
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
				
			case 8: 
				try {
					list = new ArrayList<Loan>();
					list = accountLoanService.loanApprovalList(loan);
					list.stream().forEach(l -> System.out.print(l.getAccountNumber()+" "+l.getAmount()+" "+l.isLoanStatus()+"\n"));
					
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
			
			case 9: 
				try {
					list = new ArrayList<Loan>();
					list = accountLoanService.loanRejectList(loan);
					//list.stream().forEach(l -> System.out.print(l.getTenure()+" "+l.getAccountNumber()+" "+l.getBalance()+" "+l.getAmount()+"\n "));

					
				}
				catch(AccountExcepetion ae) {
					//ae.printStackTrace();
					System.err.println(ae.getMessage());
				}break;
			
			case 10:
				System.out.println("thank you! :)");
				return;
				
			/*case 6:
				try
				{
					account = new Account();
					System.out.println("Please Enter account Name");
					String name = scanner.nextLine();
					scanner.nextLine();
					account.setAccountName(name);
					System.out.println("Please Enter Address");
					String address = scanner.nextLine();
					account.setAddress(address);
					System.out.println("Please Enter Contact");
					long contact=scanner.nextLong();
					account.setConactNumber(contact);
					account.setBalance(0);
					
					int accnumber = accountLoanService.addAccount(account); 
					System.out.println("accountNumber = "+accnumber);
					
					
				
				}
				catch(AccountExcepetion ae)
				{
					System.err.println(ae.getMessage());
				}
				break;
			*/
			default:
				System.out.println("enter vaild choice");
			}
		

		}

	}
}
