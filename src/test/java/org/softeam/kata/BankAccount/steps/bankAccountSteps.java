package org.softeam.kata.BankAccount.steps;

import org.softeam.kata.BankAccount.BankAccountApplicationTests;
import org.softeam.kata.BankAccount.constant.AccountConstants;
import org.softeam.kata.BankAccount.exceptions.CustomAccountException;
import org.softeam.kata.BankAccount.models.Account;
import org.softeam.kata.BankAccount.models.Client;
import org.softeam.kata.BankAccount.service.account.AccountService;
import org.softeam.kata.BankAccount.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@CucumberContextConfiguration
public class bankAccountSteps extends BankAccountApplicationTests {

	@Autowired
	ClientService clientService;

	@Autowired
	AccountService accountService;

	Client client;
	Exception thrownException;

	@Given("A bank client {string} {string}")
	public void a_bank_client(String firstName, String lasttName) {
		client = clientService.createClient(firstName, lasttName);
	}

	@And("A bank account with {float}")
	public void a_bank_account_with(float balance) throws CustomAccountException {
		Account account = client.getAccount();
		account = accountService.setBalance(account, balance);
	}

	@When("A client deposits {float}")
	public void a_client_deposit(float deposit) {
		try {
			Account account = accountService.depositMoneyToAccount(client.getAccount(), deposit);
			client.setAccount(account);
		} catch (Exception e) {
			thrownException = e;
		}
	}

	@When("A client withraws {float}")
	public void a_client_withraws(float sum) {
		try {
			Account account = accountService.withdrawMoneyFromAccount(client.getAccount(), sum);
			client.setAccount(account);
		} catch (CustomAccountException e) {
			thrownException = e;
		}

	}

	@Then("The account balance should be at {float}")
	public void the_account_balance_should_be_at(float balance) {
		assertThat(client.getAccount().getBalance()).isEqualTo(balance);
	}

	@Then("It should throw NO_SUFFICIENT_CREDIT exception")
	public void it_should_throw_exception() {
		assertThat(AccountConstants.NO_SUFFICIENT_CREDIT).isEqualTo(thrownException.getMessage());
	}

	@Then("A client should see his operations and contains {string} and {string}")
	public void a_client_should_see_his_operations(String str1, String str2) throws CustomAccountException {
		String get = accountService.printStatement(client.getAccount());
		assertThat(get).isNotEmpty().contains(str1).contains(str2);
	}

}
