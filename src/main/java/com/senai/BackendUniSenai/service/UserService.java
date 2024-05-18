package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.User;
import com.senai.BackendUniSenai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Optional<User>> findUserById(int id) {
        try {
            Optional<User> user = userRepository.findById(id);

            if (user.isPresent()) {
                return ResponseEntity.ok(user);
            }
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<User> add(int idUser, String password, char typeUser) {
        try {
            User user = new User();
            user.addUser(idUser, password, typeUser);
            return ResponseEntity.ok(userRepository.saveAndFlush(user));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<User> update(int id, User user) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado no banco de dados.");
        }
        user.setId(id);

        try {
            final User updateUser = userRepository.save(user);
            return ResponseEntity.ok(updateUser);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<User> deleteByRegisterId(int id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado no banco de dados.");
        }

        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity verifyLogin(String email, String password, char userType) {
        try {
            int response = userRepository.verifyUser(email, password, userType);
            if (response == 1) {
                return ResponseEntity.ok().build();
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail ou senha inválidos");
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
