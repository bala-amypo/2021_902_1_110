package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component   // ✅ THIS IS THE FIX
public class JwtUtil {

    private final Key key;
    private final long expirationMs;

    // Spring will use this constructor
    public JwtUtil() {
        this.key = Keys.hmacShaKeyFor(
                "test-secret-key-that-is-long-enough-1234".getBytes()
        );
        this.expirationMs = 3600000; // 1 hour
    }

    // Existing constructor (used by tests)
    public JwtUtil(String secret, long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    public Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
