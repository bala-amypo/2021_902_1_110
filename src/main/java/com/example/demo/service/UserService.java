package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    // REQUIRED BY TESTS
    User registerUser(User user);

    // Used by controllers
    User saveUser(User user);

    User getUser(Long id);

    User findByEmail(String email);
}
