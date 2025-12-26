package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {

    private final String secret;
    private final long validity;

    public JwtUtil(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims parseClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
