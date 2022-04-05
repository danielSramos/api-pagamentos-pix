package br.com.api.pixAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double value;

	@ManyToOne
	@JoinColumn(name = "sendUser_id")
	@JsonIgnore
	private User sendUsers;

	@ManyToOne
	@JoinColumn(name = "receiverUser_id")
	@JsonIgnore
	private User receiverUsers;

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

	public User getSendUsers() {
		return sendUsers;
	}

	public void setSendUsers(User sendUsers) {
		this.sendUsers = sendUsers;
	}

	public User getReceiverUsers() {
		return receiverUsers;
	}

	public void setReceiverUsers(User receiverUsers) {
		this.receiverUsers = receiverUsers;
	}
}
