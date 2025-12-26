package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService) {
        this.userService = userService;
        // manual creation (NO Spring bean needed)
        this.jwtUtil = new JwtUtil(
                "test-secret-key-that-is-long-enough-1234",
                3600000
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = userService.getUser(1L); // dummy fetch for demo

        String token = jwtUtil.generateToken(
                1L,
                user.getEmail(),
                user.getRole()
        );

        return new AuthResponse(
                token,
                1L,
                user.getEmail(),
                user.getRole()
        );
    }
}
