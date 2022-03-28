package br.com.api.pixAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.controller.dto.NewTransaction;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.Transaction;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.TransactionRepository;
import br.com.api.pixAPI.repository.UserRepository;

@RestController
@RequestMapping("transfer")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PixKeyRepository pixKeyRepository;
	
	
	@PostMapping("/new")
	public ResponseEntity<Transaction> newTransaction(@RequestBody NewTransaction request) {

		Optional<User> findedUser = userRepository.findById(request.getUserId());
		Optional<PixKey> findedPixKey = pixKeyRepository.findPixKey(request.getPixKey());

		Transaction newTransaction = new Transaction();
		newTransaction.setPixKey(findedPixKey.get());
		newTransaction.setUser(findedUser.get());
		newTransaction.setValue(request.getValue());

		findedUser.get().setValue(request.getValue());

		return new ResponseEntity<Transaction>(transactionRepository.save(newTransaction), HttpStatus.OK);
	}
	
}
