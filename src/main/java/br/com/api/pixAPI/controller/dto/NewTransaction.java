package br.com.api.pixAPI.controller.dto;

public class NewTransaction {

	private Long transactionId;
	private Long userId;
	private Long pixKey;
	private Double value;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPixKey() {
		return pixKey;
	}

	public void setPixKey(Long pixKey) {
		this.pixKey = pixKey;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
