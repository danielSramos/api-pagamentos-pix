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
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.controller.dto.CreateUser;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.UserRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("user")
@Transactional
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/list/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/new")
	public ResponseEntity<User> create(@RequestBody CreateUser request) {
		
		User user = request.toUser();

		userRepository.save(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
