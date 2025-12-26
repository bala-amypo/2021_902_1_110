package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + validityInMs;

        String payload = email + "|" + role + "|" + expiry;
        String encoded = Base64.getEncoder()
                .encodeToString(payload.getBytes(StandardCharsets.UTF_8));

        // fake JWT format: header.payload.signature
        return "header." + encoded + ".signature";
    }

    public Map<String, Object> parseClaims(String token) {

        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) throw new RuntimeException("Invalid token");

            String decoded = new String(
                    Base64.getDecoder().decode(parts[1]),
                    StandardCharsets.UTF_8
            );

            String[] values = decoded.split("\\|");
            String email = values[0];
            String role = values[1];
            long expiry = Long.parseLong(values[2]);

            if (System.currentTimeMillis() > expiry) {
                throw new RuntimeException("Token expired");
            }

            Map<String, Object> claims = new HashMap<>();
            claims.put("sub", email);
            claims.put("role", role);
            return claims;

        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
