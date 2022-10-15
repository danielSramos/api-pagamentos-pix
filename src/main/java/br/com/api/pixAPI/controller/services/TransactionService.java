package br.com.api.pixAPI.controller.services;

import br.com.api.pixAPI.controller.dto.Deposit;
import br.com.api.pixAPI.controller.dto.Transference;
import br.com.api.pixAPI.controller.dto.Withdraw;
import br.com.api.pixAPI.model.Transaction;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.TransactionRepository;
import br.com.api.pixAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public ResponseEntity deposit(Long id, Deposit request) {
        if (id == null || request.getValue() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> foundUser = userRepository.findById(id);

        if (!foundUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = foundUser.get();
        user.setValue(user.getValue() + request.getValue());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity withdraw(Long id, Withdraw request) {
        if (id == null || request.getValue() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> foundUser = userRepository.findById(id);

        if (!foundUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = foundUser.get();
        Double balance =  user.getValue() - request.getValue();

        if (balance < 0) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        user.setValue(balance);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity transfer(Long id, Transference request) {

        if (id == null || request.getValue() == null || request.getReceiverPixKey() == null || request.getValue() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> receiver = userRepository.findUserByPixKey(request.getReceiverPixKey());

        if (!receiver.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<User> send = userRepository.findById(id);

        if (!send.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Double balance = send.get().getValue() - request.getValue();

        if (balance < 0 ) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        Transaction transaction = new Transaction();

        transaction.setValue(request.getValue());
        transaction.setSendUsers(send.get());
        transaction.setReceiverUsers(receiver.get());
        send.get().setValue(balance);

        receiver.get().setValue(receiver.get().getValue() + request.getValue());

        transactionRepository.save(transaction);

        List<User> list = new ArrayList<>();
        list.add(send.get());
        list.add(receiver.get());
        userRepository.saveAll(list);

        return ResponseEntity.ok(transaction);
    }
}
