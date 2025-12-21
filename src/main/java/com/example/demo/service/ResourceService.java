package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new ValidationException("Resource already exists");
        }
        if (resource.getCapacity() < 1) {
            throw new ValidationException("Capacity must be >= 1");
        }
        return resourceRepository.save(resource);
    }

    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
