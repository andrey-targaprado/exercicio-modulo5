package com.example.exercicio1.controller;

import ch.qos.logback.classic.Logger;
import com.example.exercicio1.Exercicio1Application;
import com.example.exercicio1.model.User;
import com.example.exercicio1.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(Exercicio1Application.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/user/list"})
    public ResponseEntity<Iterable<User>> getUsers(){
        LOGGER.info("Lista de usuarios fornecida.");
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping({"/user"})
    public ResponseEntity<Void> userCreate(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping({"/user{id}"})
    public ResponseEntity<Void> userUpdate(@PathVariable(value="id") long id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
