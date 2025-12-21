package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @OneToOne
    private ResourceRequest request;

    private Boolean conflictFlag;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setRequest(ResourceRequest request) {
        this.request = request;
    }

    public void setConflictFlag(Boolean conflictFlag) {
        this.conflictFlag = conflictFlag;
    }
}
