package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User register(User user);

    // 🔥 ADD THIS (required by controllers)
    User saveUser(User user);

    User getUser(Long id);

    User findByEmail(String email);
}
