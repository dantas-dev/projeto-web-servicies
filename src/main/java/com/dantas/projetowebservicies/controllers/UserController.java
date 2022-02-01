package com.dantas.projetowebservicies.controllers;

import com.dantas.projetowebservicies.model.user.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        UserEntity user = new UserEntity(1L, "Rafael", "rafael@email.com", "99999999", "12345");
        return ResponseEntity.ok().body(user);
    }
}
