package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "dummy-token-" + email;
    }

    public SimpleClaims extractAllClaims(String token) {
        SimpleClaims claims = new SimpleClaims();

        // Simulate JWT "sub"
        if (token != null && token.contains("dummy-token-")) {
            String email = token.replace("dummy-token-", "");
            claims.put("sub", email);
        }

        return claims;
    }
}
