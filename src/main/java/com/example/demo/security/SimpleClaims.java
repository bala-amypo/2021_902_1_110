package com.example.demo.security;

import java.util.HashMap;

public class SimpleClaims extends HashMap<String, Object> {

    public String getSubject() {
        Object sub = this.get("sub");
        return sub != null ? sub.toString() : null;
    }

    public String getRole() {
        Object role = this.get("role");
        return role != null ? role.toString() : null;
    }
}
