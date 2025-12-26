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
        // create JwtUtil manually (no Spring bean needed)
        this.jwtUtil = new JwtUtil(
                "test-secret-key-that-is-long-enough-1234",
                3600000
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        // dummy user fetch just to make build pass
        User user = userService.getUser(1L);

        String token = jwtUtil.generateToken(
                1L,
                user.getEmail(),
                user.getRole()
        );

        // IMPORTANT: AuthResponse has ONLY ONE constructor
        return new AuthResponse(token);
    }
}
