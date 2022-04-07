package br.com.api.pixAPI.controller;

import br.com.api.pixAPI.controller.dto.CreatePixKey;
import br.com.api.pixAPI.controller.services.PixKeyService;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pix")

public class PixKeyController {

	@Autowired
	PixKeyService pixKeyService;

	@Autowired
	private PixKeyRepository pixKeyRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/list")
	public ResponseEntity findById(@RequestParam(value = "id", required = false) Long id) {
		return pixKeyService.list(id);
	}

	@PostMapping("/create")
	public ResponseEntity create(@Valid @RequestBody CreatePixKey request) {
		return pixKeyService.create(request);
	}

	@DeleteMapping("/delete")
	public ResponseEntity delete(@RequestParam(value = "id") Long id) {
		return pixKeyService.delete(id);
	}
}
