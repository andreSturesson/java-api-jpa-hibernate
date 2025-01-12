package com.booleanuk.api.controller;

import com.booleanuk.api.model.User;
import com.booleanuk.api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    record PostUser(String email, String firstName) {}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody PostUser request) {
        User user = new User(request.email(), request.firstName());
        return this.repository.save(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        User existingUser = this.repository.findById(id).orElseThrow();
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getFirstName() != null) {
            existingUser.setFirstName(user.getFirstName());
        }
        if (user.getActive() != null) {
            existingUser.setActive(user.getActive());
        }
        return this.repository.save(existingUser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.repository.deleteById(id);
    }
}
