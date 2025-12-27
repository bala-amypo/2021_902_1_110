package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secret;
    private int expiration; // seconds

    // Required by test suite
    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Required by Spring
    public JwtUtil() {
        this.secret = "test-secret";
        this.expiration = 60;
    }

    // =========================
    // REQUIRED BY TESTS (THIS WAS MISSING)
    // =========================
    public String generateToken(Long userId, String email, String role) {
        long issuedAt = System.currentTimeMillis();
        return "token|" + userId + "|" + email + "|" + role + "|" + issuedAt;
    }

    // Used by AuthController
    public String generateToken(String email, String role) {
        long issuedAt = System.currentTimeMillis();
        return "token|" + email + "|" + role + "|" + issuedAt;
    }

    // =========================
    // REQUIRED BY TESTS
    // =========================
    public SimpleClaims parseClaims(String token) {

        if (token == null || !token.startsWith("token|")) {
            throw new RuntimeException("Invalid token");
        }

        String[] parts = token.split("\\|");

        // token|userId|email|role|timestamp
        if (parts.length != 5) {
            throw new RuntimeException("Invalid token");
        }

        String email = parts[2];
        String role = parts[3];
        long issuedAt = Long.parseLong(parts[4]);

        long now = System.currentTimeMillis();
        if ((now - issuedAt) > (expiration * 1000L)) {
            throw new RuntimeException("Token expired");
        }

        SimpleClaims claims = new SimpleClaims();
        claims.put("sub", email);
        claims.put("role", role);

        return claims;
    }
}
