package org.softeam.kata.BankAccount.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@ManyToOne
	private Account account;
	

	@NotNull
	private float amount;
	
	@NotNull
	private float balance;

	@NotNull
	@EqualsAndHashCode.Include
	private LocalDate date;
	
	@NotNull
	@EqualsAndHashCode.Include
	private TransactionType operation;

	@Override
	public String toString() {
		return operation.name() + " | " + date +" | "+amount+" | " + balance ;
	}
}
