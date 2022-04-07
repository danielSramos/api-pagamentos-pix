package br.com.api.pixAPI.controller;

import br.com.api.pixAPI.controller.dto.UpdateUser;
import br.com.api.pixAPI.controller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.api.pixAPI.controller.dto.CreateUser;
import br.com.api.pixAPI.model.User;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/list")
    public ResponseEntity findById(@RequestParam(value = "id", required = false) Long id) {
        return userService.findUser(id);
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@Valid @RequestBody CreateUser request) {
        return new ResponseEntity<>(userService.create(request), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody UpdateUser request) {
        return userService.update(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam(value = "id", required = false) Long id) {
        return userService.delete(id);
    }
}
