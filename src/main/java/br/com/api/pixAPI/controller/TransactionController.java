package br.com.api.pixAPI.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pixAPI.model.Transaction;
import br.com.api.pixAPI.repository.TransactionRepository;

@RestController
@RequestMapping("transfer")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping
	@Transactional
	public Transaction transferir() {
		
		
		
		return null;
	}
	
}
