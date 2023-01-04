package org.softeam.kata.BankAccount.service.account;

import org.softeam.kata.BankAccount.exceptions.CustomAccountException;
import org.softeam.kata.BankAccount.models.Account;
import org.softeam.kata.BankAccount.models.Transaction;
import org.softeam.kata.BankAccount.models.TransactionType;
import org.softeam.kata.BankAccount.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.softeam.kata.BankAccount.constant.AccountConstants.*;

import java.time.LocalDate;;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	public AccountRepository accountRepository;

	@Override
	public Account depositMoneyToAccount(Account account, float amount) throws CustomAccountException {
		Account resultAccount = accountRepository.findById(account.getId()).orElseThrow(()-> new CustomAccountException(ACCOUNT_NOT_FOUND));
		if (resultAccount != null) {
			float newBalance = amount + resultAccount.getBalance();
			addTransactionToAccount(amount, resultAccount, newBalance, TransactionType.DEPOSIT);
			return accountRepository.save(resultAccount);
		} else {
			throw new CustomAccountException(CLIENT_NOT_FOUND);
		}

	}

	@Override
	public Account withdrawMoneyFromAccount(Account account, float amount) throws CustomAccountException {
		Account resultAccount = accountRepository.findById(account.getId()).orElseThrow(()-> new CustomAccountException(ACCOUNT_NOT_FOUND));
		if (resultAccount != null) {
			float newBalance = resultAccount.getBalance() - amount;
			if (newBalance < 0) {
				throw new CustomAccountException(NO_SUFFICIENT_CREDIT);
			}
			addTransactionToAccount(amount, resultAccount, newBalance, TransactionType.WITHDRAWL);
			return accountRepository.save(resultAccount);
		} else {
			throw new CustomAccountException(CLIENT_NOT_FOUND);
		}

	}

	private void addTransactionToAccount(float amount, Account account, float balance, TransactionType transactionType) {
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setDate(LocalDate.now());
		transaction.setBalance(balance);
		transaction.setOperation(transactionType);
		account.setBalance(balance);
		account.getOperations().add(transaction);
		account.setBalance(balance);
	}

	@Override
	public String printStatement(Account account) throws CustomAccountException {
		Account resultAccount = accountRepository.findById(account.getId()).orElseThrow(()-> new CustomAccountException(ACCOUNT_NOT_FOUND));
		return resultAccount.toString();
	}

	@Override
	public Account setBalance(Account account, float balance) throws CustomAccountException {
		account.setBalance(balance);
		return accountRepository.save(account);
	}

}
