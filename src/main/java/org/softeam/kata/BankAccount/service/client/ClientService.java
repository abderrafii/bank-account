package org.softeam.kata.BankAccount.service.client;

import org.softeam.kata.BankAccount.exceptions.CustomAccountException;
import org.softeam.kata.BankAccount.models.Client;

public interface ClientService {

	public Client findClientById(Integer clientId) throws CustomAccountException;

	public Client createClient(String firstName, String lastName);

}
