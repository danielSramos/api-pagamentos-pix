package br.com.api.pixAPI.controller.services;

import br.com.api.pixAPI.controller.dto.CreatePixKey;
import br.com.api.pixAPI.model.PixKey;
import br.com.api.pixAPI.model.User;
import br.com.api.pixAPI.repository.PixKeyRepository;
import br.com.api.pixAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PixKeyService {

    @Autowired
    private PixKeyRepository pixKeyRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity list() {
        return new ResponseEntity(pixKeyRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity findByKey(Long key) {
        if (key == null) {
            return new ResponseEntity("Id incorreto", HttpStatus.NOT_FOUND);
        }

        Optional<PixKey> user = pixKeyRepository.findByPixKey(key);
        if (!user.isPresent()) {
            return new ResponseEntity("Chave não existe", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

    public ResponseEntity create(CreatePixKey request) {
        Optional<User> user = userRepository.findById(request.getUserId());
        Optional<PixKey> pixKey = pixKeyRepository.findByPixKey(request.getKey());

        if (!user.isPresent()) {
            return new ResponseEntity("Usuário não existe!", HttpStatus.NOT_FOUND);
        }

        if (pixKey.isPresent()) {
            return new ResponseEntity("Chave já existe!!!", HttpStatus.BAD_REQUEST);
        }

        if (pixKeyRepository.pixKeyCount(request.getUserId()) >= 3) {
            String message = "Maximo de chaves atingido, delete uma chave para cadastar outra";
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }

        PixKey key = request.toPixKey();
        key.setUser(user.get());
        pixKeyRepository.save(key);
        return new ResponseEntity(key.toString(), HttpStatus.OK);
    }

    public ResponseEntity delete(Long id) {
        if (id == null) {
            return new ResponseEntity("Chave não existe", HttpStatus.NOT_FOUND);
        }

        pixKeyRepository.deleteById(id);
        return new ResponseEntity("Chave deletada com sucesso!", HttpStatus.OK);
    }
}
