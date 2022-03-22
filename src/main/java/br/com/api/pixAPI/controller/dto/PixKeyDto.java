package br.com.api.pixAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.pixAPI.model.PixKey;

public class PixKeyDto {

	private Long id;
	private Long key;
	private Long userId;

	public PixKeyDto() {
	}

	public PixKeyDto(PixKey pixKey) {
		this.id = pixKey.getId();
		this.key = pixKey.getPixKey();
		this.userId = pixKey.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Long getUser_id() {
		return userId;
	}

	public void setUser_id(Long userId) {
		this.userId = userId;
	}

	public static List<PixKeyDto> convert(List<PixKey> pixKey) {
		return pixKey.stream().map(PixKeyDto::new).collect(Collectors.toList());
	}

}
