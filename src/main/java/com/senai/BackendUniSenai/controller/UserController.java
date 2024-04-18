package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.User;
import com.senai.BackendUniSenai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
