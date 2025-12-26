package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository repo;

    public ResourceServiceImpl(ResourceRepository repo) {
        this.repo = repo;
    }

    public Resource createResource(Resource resource) {
        if (resource.getCapacity() == null || resource.getCapacity() < 1 || resource.getResourceType() == null) {
            throw new RuntimeException();
        }
        if (repo.existsByResourceName(resource.getResourceName())) {
            throw new RuntimeException("Resource exists");
        }
        return repo.save(resource);
    }

    public List<Resource> getAllResources() {
        return repo.findAll();
    }
}
