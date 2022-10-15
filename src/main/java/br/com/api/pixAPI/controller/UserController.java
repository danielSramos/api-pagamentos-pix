package br.com.api.pixAPI.controller;

import br.com.api.pixAPI.controller.dto.CreateUser;
import br.com.api.pixAPI.controller.dto.UpdateUser;
import br.com.api.pixAPI.controller.services.UserService;
import br.com.api.pixAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity findAll() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody CreateUser request) {
        return new ResponseEntity<>(userService.create(request), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id ,@Valid @RequestBody UpdateUser request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
