package org.softeam.kata.BankAccount;

import org.junit.jupiter.api.Test;
import org.softeam.kata.BankAccount.service.account.AccountService;
import org.softeam.kata.BankAccount.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankAccountApplicationTests {
	@Autowired
	ClientService clientService;

	@Autowired
	AccountService accountService;
	
	@Test
	void contextLoads() {
	}
}
