package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(
                Base64.getEncoder()
                        .encodeToString(user.getPassword().getBytes())
        );

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return repo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
