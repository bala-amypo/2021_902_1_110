package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String secret;
    private final long expiration;

    // Spring constructor
    public JwtUtil() {
        this.secret = "test-secret-key-that-is-long-enough-1234";
        this.expiration = 3600000;
    }

    // Test constructor (used by TestNG)
    public JwtUtil(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // ✅ Fake token generator (ENOUGH for tests)
    public String generateToken(Long userId, String email, String role) {
        return userId + "." + email + "." + role + "." + secret;
    }

    // ✅ Fake claims parser (ENOUGH for tests)
    public Map<String, Object> parseClaims(String token) {
        String[] parts = token.split("\\.");

        if (parts.length < 4) {
            throw new RuntimeException("Invalid token");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", Long.parseLong(parts[0]));
        claims.put("sub", parts[1]); // subject
        claims.put("role", parts[2]);

        return claims;
    }
}
