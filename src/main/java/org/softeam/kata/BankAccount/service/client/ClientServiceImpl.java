package org.softeam.kata.BankAccount.service.client;

import java.util.HashSet;

import org.softeam.kata.BankAccount.constant.AccountConstants;
import org.softeam.kata.BankAccount.exceptions.CustomAccountException;
import org.softeam.kata.BankAccount.models.Account;
import org.softeam.kata.BankAccount.models.Client;
import org.softeam.kata.BankAccount.models.Transaction;
import org.softeam.kata.BankAccount.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Client findClientById(Integer clientId) throws CustomAccountException {
		return clientRepository.findById(clientId).orElseThrow(() -> new CustomAccountException(AccountConstants.CLIENT_NOT_FOUND));
	}
	
	@Override
	public Client createClient(String firstName, String lastName) {
		Client client = new Client();
		client.setFirstName(firstName);
		client.setLastName(lastName);
		Account account = new Account();
		account.setBalance(0);
		account.setOperations(new HashSet<Transaction>());
		client.setAccount(account);
		return clientRepository.save(client);
	}

}
