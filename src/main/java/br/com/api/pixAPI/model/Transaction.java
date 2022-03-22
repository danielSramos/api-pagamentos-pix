package br.com.api.pixAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double value;
	
	@OneToOne
	private User user;

	@OneToOne
	private PixKey pixKey;
	
	public Transaction() {

	}

	public Transaction(Double value, User user, PixKey pixKey) {
		this.value = value;
		this.user = user;
		this.pixKey = pixKey;
	}
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PixKey getPixKey() {
		return pixKey;
	}

	public void setPixKey(PixKey pixKey) {
		this.pixKey = pixKey;
	}

}
