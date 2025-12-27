package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // =========================
    // REGISTER
    // =========================
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User saved = userService.registerUser(user);
        return ResponseEntity.ok(saved);
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        User user = userService.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        // ✅ IMPORTANT: match JwtUtil signature
        String token = jwtUtil.generateToken(
                user.getEmail(),   // subject
                user.getRole()     // role
        );

        return ResponseEntity.ok(Map.of("token", token));
    }
}
