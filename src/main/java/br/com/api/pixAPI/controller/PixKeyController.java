package br.com.api.pixAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.controller.dto.CreatePixKey;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.UserRepository;

@RestController
@RequestMapping("pix")
@ResponseBody

public class PixKeyController {

	@Autowired
	private PixKeyRepository pixKeyRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/list")
	public List<PixKey> findAll() {
		return pixKeyRepository.findAll();
	}

	@GetMapping("/list/{id}")
	public Optional<PixKey> findById(@PathVariable("id") Long id) {

		return pixKeyRepository.findPixKeyById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody CreatePixKey request) {

		Optional<User> searchedUser = userRepository.findById(request.getUserId());
		

		if (!searchedUser.isPresent()) {
			System.out.println("usuario nao encontrado");
			
			return new ResponseEntity<String> ("Usuário não encontrado", HttpStatus.BAD_REQUEST);
			
//			return null;
		} else {
			
			Optional<PixKey> searchedPixKey = pixKeyRepository.findPixKey(request.getKey());
			if (!searchedPixKey.isEmpty()) {
				System.out.println("Chave já existe!!!");
				
				return new ResponseEntity<String>("Chave pix já existe!!!", HttpStatus.BAD_REQUEST);
				
//				return null;
			} else if (pixKeyRepository.pixKeyCount(searchedUser.get().getId()) >= 3) {
				System.out.println("Maximo de chaves cadastradas atingido, delete alguma chave para cadastrar outra nova");
				return new ResponseEntity<String>("Maximo de chaves cadastradas atingido, delete alguma chave para cadastrar outra nova", HttpStatus.BAD_REQUEST);
			} else {
				User user = searchedUser.get();

				PixKey newPixkey = request.toPixKey();

				newPixkey.setUser(user);

				String newPixKeyCreated = newPixkey.toString();
				
				pixKeyRepository.save(newPixkey);
				
				return new ResponseEntity<String>(newPixKeyCreated, HttpStatus.OK);
				
//				return pixKeyRepository.save(newPixkey);
			}

		}
	}

	@GetMapping("/test/{id}")
	public ResponseEntity<Integer> teste(@PathVariable("id") Long id) {

		Integer pixKeyCount = pixKeyRepository.pixKeyCount(id);

		return new ResponseEntity<Integer>(pixKeyCount, HttpStatus.OK);

	}

}
