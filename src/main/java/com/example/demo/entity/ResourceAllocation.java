package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @ManyToOne
    private ResourceRequest request;

    private String notes;

    private LocalDateTime allocatedAt = LocalDateTime.now();

    public ResourceAllocation() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }

    public ResourceRequest getRequest() { return request; }
    public void setRequest(ResourceRequest request) { this.request = request; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getAllocatedAt() { return allocatedAt; }
}
