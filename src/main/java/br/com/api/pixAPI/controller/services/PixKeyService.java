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

@Service
public class PixKeyService {

    @Autowired
    private PixKeyRepository pixKeyRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity list(Long id) {

        if (id == null) {
            return new ResponseEntity(pixKeyRepository.findAll(), HttpStatus.OK);
        }
        if (!pixKeyRepository.findById(id).isPresent()) {
            return new ResponseEntity("Chave não existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(pixKeyRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity create(CreatePixKey request) {

        if (!userRepository.findById(request.getUserId()).isPresent()) {
            return new ResponseEntity("Usuário não existe!", HttpStatus.NOT_FOUND);
        }
        if (pixKeyRepository.findPixKey(request.getKey()).isPresent()) {
            return new ResponseEntity("Chave já existe!!!", HttpStatus.BAD_REQUEST);
        }
        if (pixKeyRepository.pixKeyCount(request.getUserId()) >= 3) {
            String message = "Maximo de chaves atingido, delete uma chave para cadastar outra";
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
        User user = userRepository.findById(request.getUserId()).get();
        request.toPixKey().setUser(user);
        PixKey key = request.toPixKey();
        key.setUser(user);
        pixKeyRepository.save(key);
        return new ResponseEntity(key.toString(), HttpStatus.OK);
    }

    public ResponseEntity delete(Long id) {
        pixKeyRepository.deleteById(id);
        return new ResponseEntity("Chave deletada com sucesso!", HttpStatus.OK);
    }
}
