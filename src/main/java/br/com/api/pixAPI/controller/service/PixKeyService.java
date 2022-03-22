package br.com.api.pixAPI.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.repository.PixKeyRepository;

@Service
public class PixKeyService {

	private Long pixKey;
	private Long user_id;
	
	@Autowired
	PixKeyRepository pixKeyRepository;
	
	public Long getPixKey() {
		return pixKey;
	}
	public Long getUser_id() {
		return user_id;
	}
	
	public void setPixKey(Long pixKey) {
		this.pixKey = pixKey;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public PixKey create(PixKey pixKey) {
		
		if(pixKeyRepository.findPixKey(getPixKey()) != null) {
			return null;
		}
		return pixKeyRepository.save(pixKey);

	}
	
	
	
	
	
	
	
	
}
