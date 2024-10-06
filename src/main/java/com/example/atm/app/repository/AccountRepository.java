package com.example.atm.app.repository;

import com.example.atm.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Repository;


@Repository
 public interface AccountRepository extends 
 JpaRepository<Account, Long> {
	 Account 
	 findByAccountHolder(String accountHolder);
	
}
