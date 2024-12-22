package com.nt.runner;

import java.util.Scanner;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankDetails;
import com.nt.repository.IBankRepository;
import com.nt.service.IBankService;

@Component
public class BankTestRunner implements CommandLineRunner {
	Scanner scanner= new Scanner(System.in);
	
	@Autowired
	private IBankService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Welcome to bank of india ");
		
        while(true) {
        	 System.out.println("\n--- Bank Management System ---");
             System.out.println("1. Add Bank Details");
             System.out.println("2. View All Bank Details");
             System.out.println("3. Withdraw the Money");
             System.out.println("4.deposite the money");
             System.out.println("3. Exit");
             System.out.print("Enter your choice: ");
             
             
             int choice=scanner.nextInt();
             switch (choice) {
			case 1:
				System.out.println("enter the account holder name ");
				String name=scanner.next();
				scanner.nextLine();
				System.out.println("Enter the balance ");
				double balance=scanner.nextDouble();
				
				BankDetails details= new BankDetails();
				details.setName(name);
				details.setBankBalance(1999D);
				
				String msgString=service.registerUser(details);
				System.out.println(msgString);
				break;
			case 2:
				Iterable<BankDetails> AllRecorddetails=service.viewAllRecords();
				AllRecorddetails.forEach(record->{
					System.out.println(record);
				});
				break;
				
			case 3:
				System.out.println("Enter the account number for withdraw");
			  
				Integer accNO=scanner.nextInt();
				
				System.out.println("Enter the withdraw amount ");
				
				double withDrawAmount=scanner.nextDouble();
				String mString=service.checkUser(accNO, withDrawAmount);
				System.out.println(mString);
				
				break;
				
			case 4:
				System.out.println("Enter the account no");
				Integer accNO1=scanner.nextInt();
				
				System.out.println("Enter the amount to be deposited ");
				double depositeAmount =scanner.nextDouble();
				
				String msg=service.Deposite(accNO1, depositeAmount);
				System.out.println(msg);
				break;
				
			case 5:
				System.out.println("thank You");
				System.exit(0);
				
				

			default:
				System.out.println("invalid choice ");
				
			}
			
        }
	}

}
