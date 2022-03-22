package br.com.api.pixAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/list")
	public List<User> buscarTodos() {
		return userRepository.findAll();
	}

	@PostMapping("/new")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping(value = "/list/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}

}
