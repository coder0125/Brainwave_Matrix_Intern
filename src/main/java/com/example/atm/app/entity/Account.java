package com.example.atm.app.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.ElementCollection;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	//import jakarta.persistence.Table;


	import java.util.ArrayList;
	import java.util.List;

	  @Entity
	 //@Table(name = "atm")
	  public class Account {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String accountHolder;
	 private double balance;
	 
	 @ElementCollection
	 private List<String> transaction = new ArrayList<>();


	 public Long getId(){
	    return id;
	 }

	  public void setId(Long id){
	    this.id = id;
	 }

	 public String getAccountHolder() {
	     return accountHolder;
	 }

	 public void setAccountHolder(String accountHolder) {
	     this.accountHolder = accountHolder;
	 }

	  public double getBalance() {
	      return balance;
	  }
	  public void setBalance(double balance) {
	      this.balance = balance;
	  }
	  public List<String> getTransaction() {
	      return transaction;
	  }
	  public void setTransaction(List<String> transaction) {
	      this.transaction = transaction;
	  }
	  
	  public void addtransaction(String transaction) {
	    this.transaction.add(transaction);
	  }
	  }


