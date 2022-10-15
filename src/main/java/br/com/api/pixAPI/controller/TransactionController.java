package br.com.api.pixAPI.controller;

import br.com.api.pixAPI.controller.dto.Deposit;
import br.com.api.pixAPI.controller.dto.Transference;
import br.com.api.pixAPI.controller.dto.Withdraw;
import br.com.api.pixAPI.controller.services.TransactionService;
import br.com.api.pixAPI.model.Transaction;
import br.com.api.pixAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/{id}/deposit")
    public ResponseEntity<User> deposit(@PathVariable("id") Long id, @RequestBody Deposit request) {
        return transactionService.deposit(id, request);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<User> withdraw(@PathVariable("id") Long id, @RequestBody Withdraw request) {
        return transactionService.withdraw(id, request);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Transaction> transfer(@PathVariable("id") Long id, @RequestBody Transference request) {
        return transactionService.transfer(id, request);
    }
}
