package org.softeam.kata.BankAccount.service.account;

import org.softeam.kata.BankAccount.exceptions.CustomAccountException;
import org.softeam.kata.BankAccount.models.Account;

public interface AccountService {

	public Account depositMoneyToAccount(Account account, float amount) throws CustomAccountException;

	public Account withdrawMoneyFromAccount(Account account, float amount) throws CustomAccountException;

	public String printStatement(Account account) throws CustomAccountException;

	public Account setBalance(Account account, float balance) throws CustomAccountException;
}
