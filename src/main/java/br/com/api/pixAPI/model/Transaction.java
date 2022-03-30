package br.com.api.pixAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double value;
	private Long sendPixKey;
	private Long receiverPixKey;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getSendPixKey() {
		return sendPixKey;
	}

	public void setSendPixKey(Long sendPixKey) {
		this.sendPixKey = sendPixKey;
	}

	public Long getReceiverPixKey() {
		return receiverPixKey;
	}

	public void setReceiverPixKey(Long receiverPixKey) {
		this.receiverPixKey = receiverPixKey;
	}
}
