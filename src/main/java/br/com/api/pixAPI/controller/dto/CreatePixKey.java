package br.com.api.pixAPI.controller.dto;

import br.com.api.pixAPI.model.PixKey;

public class CreatePixKey {

	private Long key;
	private Long userId;

	public CreatePixKey() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public PixKey toPixKey() {
		
		PixKey pixKey = new PixKey();
		
		pixKey.setPixKey(this.key);
		
		return pixKey;
	}

}
