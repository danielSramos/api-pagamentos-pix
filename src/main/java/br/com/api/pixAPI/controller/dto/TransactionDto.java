package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.Transaction;

public class TransactionDto {

	private Long transaction_id;
	private Long user_id;
	private Long pixKey;
	private Double value;
	
	public TransactionDto() {
		
	}

	public TransactionDto(Transaction transaction, Double value) {
		this.transaction_id = transaction.getId();
		this.user_id = transaction.getUser().getId();
		this.pixKey = transaction.getPixKey().getPixKey();
		this.value = value;
		
	}

	public Long getTransaction_id() {
		return transaction_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public Long getPixKey() {
		return pixKey;
	}

	public Double getValue() {
		return value;
	}
	
}
