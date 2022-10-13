package br.com.api.pixAPI.model;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	private String email;
	private Double value = 0.0;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PixKey> pixKey;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sendUsers", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> sendTransactions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receiverUsers", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> receiverTransactions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<PixKey> getPixKey() {
		return pixKey;
	}

	public void setPixKey(List<PixKey> pixKey) {
		this.pixKey = pixKey;
	}

	public List<Transaction> getSendTransactions() {
		return sendTransactions;
	}

	public void setSendTransactions(List<Transaction> sendTransactions) {
		this.sendTransactions = sendTransactions;
	}

	public List<Transaction> getReceiverTransactions() {
		return receiverTransactions;
	}

	public void setReceiverTransactions(List<Transaction> receiverTransactions) {
		this.receiverTransactions = receiverTransactions;
	}
}
