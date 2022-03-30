package br.com.api.pixAPI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pixKeys")
public class PixKey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pixKey;

	@OneToOne
	@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPixKey() {
		return pixKey;
	}

	public void setPixKey(Long pixKey) {
		this.pixKey = pixKey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Chave pix criada: [id de usuario: " + user.getId() + ", Chave Pix: " + pixKey + ", usuário: " + user.getName() + ", email: " + user.getEmail() + "]";
	}

}
