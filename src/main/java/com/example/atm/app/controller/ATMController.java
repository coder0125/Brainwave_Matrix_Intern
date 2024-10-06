package com.example.atm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atm.app.service.ATMService;

@Controller 
public class ATMController {
	
	@Autowired
	private ATMService atmService;
	
	 @GetMapping("/")
	 public String home() {
		 return "atm";
	 }
	 @PostMapping("/deposite")
	 public String deposit(@RequestParam("accountHolder") String accountHolder,
			 @RequestParam("amount") double amount, Model model) {
		 atmService.deposit(accountHolder, amount);
		 model.addAttribute("balance",atmService.checkBalance(accountHolder));
		 
		 model.addAttribute("message","Deposite :" + amount + " successfully.");
		 return "atm";
	 }
	 

	 @PostMapping("/withdraw")
	 public String withdraw(@RequestParam("accountHolder") String accountHolder,
			 
			 @RequestParam("amount") double amount, Model model)
	 {
			 atmService.withdraw(accountHolder, amount);
			 model.addAttribute("balance",atmService.checkBalance(accountHolder));
			 model.addAttribute("message", "Withdrew :" + amount + " successfully.");
			 return "atm";
	 }
	 
	 @GetMapping("/balance")
	 public String checkBalance(@RequestParam("accountHolder") String 
			 accountHolder, Model model)
	   {
	      // model.addAttribute("balance",atmService.checkBalance(accountHolder));
		 double balance = atmService.checkBalance(accountHolder);
	        model.addAttribute("balance", balance);
	       return "atm";
	    }	
	 
	 
	 @GetMapping("/transactions")
	 public String transactionHistory(@RequestParam ("accountHolder") String
			 accountHolder, Model model) {
		 var transactions = atmService.getTransactionHistory(accountHolder);
	        model.addAttribute("transactions", transactions);
	// model.addAttribute("transactions", atmService.getTransactionHistory (accountHolder));
	 return "atm";
	 
	 }
}

