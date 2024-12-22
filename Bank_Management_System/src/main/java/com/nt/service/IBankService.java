package com.nt.service;

import com.nt.entity.BankDetails;

public interface IBankService {
	
	public String registerUser(BankDetails details);
    
	public Iterable<BankDetails> viewAllRecords();
	
	public String checkUser(Integer id, double withDrawAmount);
	
	public String Deposite(Integer id, double depositeAmount);
}
