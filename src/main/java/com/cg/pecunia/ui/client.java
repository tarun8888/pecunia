package com.cg.pecunia.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.pecunia.bean.Loan;
import com.cg.pecunia.exception.AccountExcepetion;
import com.cg.pecunia.service.AccountLoanService;
import com.cg.pecunia.service.AccountLoanServiceImpl;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Loan loan = null;
		ArrayList<Loan> list;
		AccountLoanService accountLoanService = new AccountLoanServiceImpl();
		while(true) {
			System.out.println("1. request Loan");
			System.out.println("2. loan status");
			System.out.println("3. update balance");
			System.out.println("4. loan approval list");
			System.out.println("5. loan rejected list");
			System.out.println("6. exit");
			
			System.out.println("\nenter choice");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1: 
				try {
					System.out.println("enter account number");
					long accountNumber = scanner.nextLong();
					System.out.println("enter loan amount");
					double amount = scanner.nextDouble();
					System.out.println("enter tenure");
					int tenure = scanner.nextInt();
					System.out.println("enter credit score");
					int creditScore = scanner.nextInt();
					loan = accountLoanService.loanRequest(accountNumber, amount, tenure, creditScore);
					System.out.println(loan.getAccountNumber()+" requested loan of "+loan.getAmount()+" for "+loan.getTenure()+" years");
				}
				catch(AccountExcepetion ae) {
					ae.printStackTrace();
				}break;
			
			case 2: 
				try {
					if(accountLoanService.loanApprovalStatus(loan))
						System.out.println("loan approved");
					else
						System.out.println("loan not approved");
					
				}
				catch(AccountExcepetion ae) {
					ae.printStackTrace();
				}break;
			
			case 3: 
				try {
					double balance = accountLoanService.updateBalance(loan);
					System.out.println("updated balance = "+balance);
	
				}
				catch(AccountExcepetion ae) {
					ae.printStackTrace();
				}break;
			
			case 4: 
				try {
					list = new ArrayList<Loan>();
					list = accountLoanService.loanApprovalList(loan);
					list.stream().forEach(l -> System.out.print(l.getAccountName()+" "+l.getAccountNumber()+" "+l.getBalance()));
					
				}
				catch(AccountExcepetion ae) {
					ae.printStackTrace();
				}break;
			
			case 5: 
				try {
					list = new ArrayList<Loan>();
					list = accountLoanService.loanRejectList(loan);
					list.stream().forEach(l -> System.out.print(l.getAccountName()+" "+l.getAccountNumber()+" "+l.getBalance()+" "+l.getAmount()+"\n "));

					
				}
				catch(AccountExcepetion ae) {
					ae.printStackTrace();
				}break;
			
			case 6:
				System.out.println("thank you! :)");
				return;
			
			default:
				System.out.println("enter vaild choice");
			}
		

		}

	}
}
