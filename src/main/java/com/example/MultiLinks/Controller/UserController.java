package com.example.MultiLinks.Controller;

import com.example.MultiLinks.Model.User;
import com.example.MultiLinks.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<User> getUserByNome(@PathVariable String nome) {
        User user = userRepository.findByNome(nome);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUser(@PathVariable UUID id, @RequestBody User atualizandoUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setNome(atualizandoUser.getNome());
            user.setEmail(atualizandoUser.getEmail());
            user.setSenha(atualizandoUser.getSenha());
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarUser(@PathVariable UUID id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            userRepository.delete(user);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


