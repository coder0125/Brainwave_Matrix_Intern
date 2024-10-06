package com.example.atm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atm.app.entity.Account;
import com.example.atm.app.repository.AccountRepository;
//import com.example.atm.app.repository.AccountRepository;

@Service
public class ATMService {
	
	@Autowired
	public AccountRepository accountRepository;
	public Account getAccountByHolder(String accountHolder) {
		return
		accountRepository.findByAccountHolder(accountHolder);
	}
	 
	public void deposit(String accountHolder,double amount)
	{
		Account account = getAccountByHolder(accountHolder);
		
		if(account != null) {
			account.setBalance(account.getBalance()+ amount);
			account.addtransaction("Deposites: ₹" + amount);
			accountRepository.save(account);
		 }
	}
	
	public void withdraw(String accountHolder, double amount) 
	{
		Account account = getAccountByHolder(accountHolder);
		
		if (account != null && account.getBalance() >= amount)
		{
		 account.setBalance(account.getBalance() - amount);
		 
		 account.addtransaction("Withdrew : ₹" + amount);
		 
		 accountRepository.save(account);
		}
	}
		public double checkBalance(String accountHolder) {
			 Account account = getAccountByHolder(accountHolder);
		     return account != null ? account.getBalance(): 0;
		}
	
		public String getTransactionHistory(String accountHolder)
		{
			Account account = getAccountByHolder(accountHolder);
		
				 return account != null ? String.join(",", account.getTransaction()) : 
					 "No transactions available.";
	
		}
}
