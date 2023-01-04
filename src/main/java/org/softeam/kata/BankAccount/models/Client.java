package org.softeam.kata.BankAccount.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer clientId;

	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	private Account account;

	@EqualsAndHashCode.Include
	private String firstName;
	@EqualsAndHashCode.Include
	private String lastName;

}
