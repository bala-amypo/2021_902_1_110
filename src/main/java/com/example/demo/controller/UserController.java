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

    // ✅ CREATE USER (again: registerUser)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.registerUser(user);
    }

    // ✅ GET USER BY EMAIL (matches interface)
    @GetMapping("/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
}
