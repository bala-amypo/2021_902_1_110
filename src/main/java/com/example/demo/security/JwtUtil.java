package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Used by tests
    public String generateToken(String email) {
        return "dummy-token-" + email;
    }

    // Used by AuthController
    public String generateToken(Long userId, String email, String role) {
        return "dummy-token-" + email;
    }

    public SimpleClaims extractAllClaims(String token) {
        SimpleClaims claims = new SimpleClaims();

        if (token != null && token.contains("dummy-token-")) {
            String email = token.replace("dummy-token-", "");
            claims.put("sub", email);
        }

        return claims;
    }
}
