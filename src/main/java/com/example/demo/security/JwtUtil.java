package com.example.demo.security;

import java.util.Base64;

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

    public Claims parseClaims(String token) {
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

            Long userId = Long.parseLong(data[0]);
            String email = data[1];
            String role = data[2];

            return new Claims(email, role, userId);

        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
