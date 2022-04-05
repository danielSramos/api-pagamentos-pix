package br.com.api.pixAPI.controller;

import java.util.Optional;

import br.com.api.pixAPI.controller.dto.Deposit;
import br.com.api.pixAPI.controller.dto.Transference;
import br.com.api.pixAPI.controller.dto.Withdraw;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.Transaction;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.UserRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("transaction")
@Transactional
public class TransactionController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PixKeyRepository pixKeyRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@PutMapping("/deposit")
	public ResponseEntity<User> deposit(@RequestBody Deposit request) {

		Optional<User> finderUser = userRepository.findById(request.getUserId());
		User user = finderUser.get();

		user.setValue(user.getValue() + request.getValue());

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping("/withdraw")
	public ResponseEntity<User> withdraw(@RequestBody Withdraw request) {

		Optional<User> finderUser = userRepository.findById(request.getUserId());
		User user = finderUser.get();

		user.setValue(user.getValue() - request.getValue());

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/transfer")
	public ResponseEntity<Transaction> transfer(@RequestBody Transference request) {

		Optional<User> receiver = userRepository.findUserByPixKey(request.getReceiverPixKey());
		Optional<User> send = userRepository.findById(request.getSendId());


		Transaction transaction = new Transaction();

		transaction.setValue(request.getValue());
		transaction.setSendUsers(send.get());
		transaction.setReceiverUsers(receiver.get());

		send.get().setValue(send.get().getValue() - request.getValue());
		receiver.get().setValue(receiver.get().getValue() + request.getValue());


		transactionRepository.save(transaction);

		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
}
