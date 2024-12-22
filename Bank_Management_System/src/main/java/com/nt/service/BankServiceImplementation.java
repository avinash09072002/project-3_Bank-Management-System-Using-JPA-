package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankDetails;
import com.nt.repository.IBankRepository;

@Service
public class BankServiceImplementation implements IBankService {

	@Autowired
	private IBankRepository repository;
@Override
	public String registerUser(BankDetails details) {
	
		return repository.save(details)==null?"no reocrd found ":"record inserted ";
	}
@Override
public Iterable<BankDetails> viewAllRecords() {
   Iterable<BankDetails> details=repository.findAll();
	return details;
}

@Override
public String checkUser(Integer id, double withDrawAmount) {
    Optional<BankDetails> details = repository.findById(id);
    
    // Check if the record exists
    if (details.isEmpty()) {
        return "Record not found";
    } else {
        BankDetails details2 = details.get();
        
        // Check if there is sufficient balance
        if (details2.getBankBalance() >= withDrawAmount) {
            details2.setBankBalance(details2.getBankBalance() - withDrawAmount);
            repository.save(details2);
            return "Withdrawal successful! Remaining balance: " + details2.getBankBalance();
        } else {
            return "Insufficient balance!";
        }
    }
}
@Override
public String Deposite(Integer id, double depositeAmount) {
 Optional<BankDetails> account=repository.findById(id);
 BankDetails details=  account.get();
 if(details==null) {
	 return "record not found **or incorrect account no";
	
 }else {
	details.setBankBalance(details.getBankBalance()+depositeAmount);
	repository.save(details);
	
	return +depositeAmount +" RS depositeed "+"total balance "+details.getBankBalance();
	
	
}
        
}
}
