package br.com.api.pixAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.controller.dto.PixKeyDto;
import br.com.api.pixAPI.controller.service.PixKeyService;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.repository.PixKeyRepository;

@RestController
@RequestMapping("pix")
@ResponseBody
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PixKeyController {

	@Autowired
	private PixKeyRepository pixKeyRepository;

	@Autowired
	PixKeyService pixKeyService;

	@GetMapping("/list")
	public List<PixKeyDto> findAll() {
		List<PixKey> pixKey = pixKeyRepository.findAll();
		return PixKeyDto.convert(pixKey);
	}
	
	@GetMapping("/list/{id}")
	public Optional<PixKey> findById(@PathVariable("id") Long id) {

		return pixKeyRepository.findPixKeyById(id);
	}
	

	@PostMapping("/new")
	public PixKey create(@RequestBody PixKey pixKey) {
		
		return pixKeyService.create(pixKey);
	}
	
}
