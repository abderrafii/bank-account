package org.softeam.kata.BankAccount.repository.client;

import org.softeam.kata.BankAccount.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
