package org.softeam.kata.BankAccount.repository.account;

import org.softeam.kata.BankAccount.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Integer>{
	
	/*@Query("SELECT a FROM Account a WHERE a.client =?1")
	public Account findByClientId(Integer clientId);*/
	
}