package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class Claims {

    private String subject;
    private String role;
    private Long userId;

    private Map<String, Object> data = new HashMap<>();

    public Claims(String subject, String role, Long userId) {
        this.subject = subject;
        this.role = role;
        this.userId = userId;

        data.put("sub", subject);
        data.put("role", role);
        data.put("userId", userId);
    }

    // used by test: claims.getSubject()
    public String getSubject() {
        return subject;
    }

    // used by test: claims.get("role")
    public Object get(String key) {
        return data.get(key);
    }
}
