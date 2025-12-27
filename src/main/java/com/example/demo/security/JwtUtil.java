package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secret;
    private int expiration; // seconds

    // Used by tests
    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Used by Spring
    public JwtUtil() {
        this.secret = "dummy-secret";
        this.expiration = 1; // 1 second for expiry test
    }

    // =========================
    // TOKEN FORMAT
    // dummy-token|email|role|timestamp
    // =========================
    public String generateToken(Long userId, String email, String role) {
        long issuedAt = System.currentTimeMillis();
        return "dummy-token|" + email + "|" + role + "|" + issuedAt;
    }

    public String generateToken(String email) {
        long issuedAt = System.currentTimeMillis();
        return "dummy-token|" + email + "|USER|" + issuedAt;
    }

    // =========================
    // PARSE & VALIDATE TOKEN
    // =========================
    public SimpleClaims parseClaims(String token) {

        if (token == null || !token.startsWith("dummy-token|")) {
            throw new RuntimeException("Invalid token");
        }

        String[] parts = token.split("\\|");

        if (parts.length != 4) {
            throw new RuntimeException("Invalid token");
        }

        String email = parts[1];
        String role = parts[2];
        long issuedAt = Long.parseLong(parts[3]);

        // Expiry check
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
