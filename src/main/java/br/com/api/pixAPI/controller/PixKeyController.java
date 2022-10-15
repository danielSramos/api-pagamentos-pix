package br.com.api.pixAPI.controller;

import br.com.api.pixAPI.controller.dto.CreatePixKey;
import br.com.api.pixAPI.controller.services.PixKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("pix")

public class PixKeyController {

    @Autowired
    PixKeyService pixKeyService;

    @GetMapping
    public ResponseEntity list() {
        return pixKeyService.list();
    }

    @GetMapping("/{key}")
    public ResponseEntity findById(@PathVariable("key") Long key) {
        return pixKeyService.findByKey(key);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CreatePixKey request) {
        return pixKeyService.create(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return pixKeyService.delete(id);
    }
}
