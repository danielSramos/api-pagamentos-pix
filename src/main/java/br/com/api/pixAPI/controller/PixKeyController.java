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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.controller.dto.CreatePixKey;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.UserRepository;

@RestController
@RequestMapping("pix")
@ResponseBody
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
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
	public PixKey create(@RequestBody CreatePixKey request) {

		Optional<User> searchedUser = userRepository.findById(request.getUserId());
		

		if (!searchedUser.isPresent()) {
			System.out.println("usuario nao encontrado");
			return null;
		} else {
			
			List<PixKey> searchedPixKey = pixKeyRepository.findPixKey(request.getKey());
			if (!searchedPixKey.isEmpty()) {
				System.out.println("Chave já existe!!!");
				return null;
			} else {
				User user = searchedUser.get();

				PixKey newPixkey = request.toPixKey();

				newPixkey.setUser(user);

				return pixKeyRepository.save(newPixkey);
			}

		}
	}
	
	@GetMapping("/test")
	public ResponseEntity<User> teste() {
		
		
		User user = new User();
		
		user.setName("Daniel");
		user.setEmail("daniel@email");
		user.setPhone("84747383");
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
