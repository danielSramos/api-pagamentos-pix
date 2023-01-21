package br.com.api.pixAPI.controller.services;

import br.com.api.pixAPI.controller.dto.CreateUser;
import br.com.api.pixAPI.controller.dto.UpdateUser;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public ResponseEntity list() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity findById(Long id) {
        if (id == null) {
            return new ResponseEntity("ID obrigatorio", HttpStatus.BAD_REQUEST);
        }
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity("Usuario não encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user.get(), HttpStatus.OK);
    }

    public User create(CreateUser user) throws Exception{
        emailService.sendMail(user.toUser());
        System.out.println("Usuário criado com sucesso e email enviado.");
        return userRepository.save(user.toUser());
    }

    public ResponseEntity update(Long id, UpdateUser user) {

        if (id == null) {
            return new ResponseEntity("Informe um ID de usuário", HttpStatus.BAD_REQUEST);
        }
        Optional<User> userById = userRepository.findById(id);
        if (!userById.isPresent()) {
            return new ResponseEntity("Usuário não existe", HttpStatus.NOT_FOUND);
        }
        User updated = userRepository.save(user.toUser(userById.get()));
        return new ResponseEntity(updated, HttpStatus.OK);
    }

    public ResponseEntity delete(Long id) {

        if (id == null) {
            return new ResponseEntity("Informe um ID", HttpStatus.BAD_REQUEST);
        }
        if (!userRepository.findById(id).isPresent()) {
            return new ResponseEntity("Usuario não existe", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity("Usuário deletado com sucesso!!", HttpStatus.OK);
    }
}
