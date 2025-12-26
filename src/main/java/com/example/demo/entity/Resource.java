package com.example.demo.entity;

import java.time.LocalDateTime;

public class Resource {

    private Long id;
    private String resourceName;
    private String resourceType;
    private Integer capacity;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Resource() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
