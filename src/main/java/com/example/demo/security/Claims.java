package com.example.demo.security;

public class Claims {

    private String subject;
    private String role;
    private Long userId;

    public Claims(String subject, String role, Long userId) {
        this.subject = subject;
        this.role = role;
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public String getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }
}
