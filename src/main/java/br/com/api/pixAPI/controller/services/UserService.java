package br.com.api.pixAPI.controller.services;

import br.com.api.pixAPI.controller.dto.CreateUser;
import br.com.api.pixAPI.controller.dto.UpdateUser;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity findUser(Long id) {

        if (id == null) {
            return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
        }
        if (!userRepository.findById(id).isPresent()) {
            return new ResponseEntity("Usuario não encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    public User create(CreateUser user) {
        return userRepository.save(user.toUser());
    }

    public ResponseEntity update(UpdateUser user) {

        if (user.getUserId() == null) {
            return new ResponseEntity("Informe um ID de usuário", HttpStatus.BAD_REQUEST);
        }
        if (!userRepository.findById(user.getUserId()).isPresent()) {
            return new ResponseEntity("Usuário não existe", HttpStatus.NOT_FOUND);
        }
        User updateUser = userRepository.findById(user.getUserId()).get();
        return new ResponseEntity(user.toUser(updateUser), HttpStatus.OK);
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
