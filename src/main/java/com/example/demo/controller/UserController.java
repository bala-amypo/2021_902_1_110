package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE USER
    @PostMapping
    public User register(@RequestBody User user) {
        return service.saveUser(user);   // ✅ FIXED
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // If you don’t really need this, see Option 2
        throw new RuntimeException("Method not implemented");
    }
}
