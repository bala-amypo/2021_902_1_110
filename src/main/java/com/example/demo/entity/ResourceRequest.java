package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;
    private String status;

    @ManyToOne
    private User requestedBy;

    public Long getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getStatus() {
        return status;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User user) {
        this.requestedBy = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
