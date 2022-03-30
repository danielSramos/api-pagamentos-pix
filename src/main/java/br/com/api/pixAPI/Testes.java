package br.com.api.pixAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("teste")
public class Testes {

	@GetMapping("/test")
	public ResponseEntity test() {
		return new ResponseEntity("Classe de teste", HttpStatus.OK);
	}
}
