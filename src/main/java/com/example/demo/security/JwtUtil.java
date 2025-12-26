package com.example.demo.security;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secret;
    private final long validityMs;

    public JwtUtil(String secret, long validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + validityMs;
        String payload = userId + "|" + email + "|" + role + "|" + expiry;
        String encoded = Base64.getEncoder().encodeToString(payload.getBytes());

        return "header." + encoded + ".signature";
    }

    public Map<String, Object> parseClaims(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid token");
            }

            String decoded =
                    new String(Base64.getDecoder().decode(parts[1]));
            String[] data = decoded.split("\\|");

            long expiry = Long.parseLong(data[3]);
            if (System.currentTimeMillis() > expiry) {
                throw new RuntimeException("Token expired");
            }

            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", Long.parseLong(data[0]));
            claims.put("email", data[1]);
            claims.put("role", data[2]);
            claims.put("subject", data[1]);

            return claims;
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
