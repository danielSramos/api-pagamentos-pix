package br.com.api.pixAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.pixAPI.model.User;

public class UserDto {

	private String name;
	private String email;
	private String phone;

	public UserDto(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static List<UserDto> convert(List<User> user) {
		return user.stream().map(UserDto::new).collect(Collectors.toList());
	}
}
