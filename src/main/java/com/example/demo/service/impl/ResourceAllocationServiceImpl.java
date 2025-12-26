package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceAllocationService;
import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(
            ResourceRequestRepository reqRepo,
            ResourceRepository resRepo,
            ResourceAllocationRepository allocRepo) {
        this.reqRepo = reqRepo;
        this.resRepo = resRepo;
        this.allocRepo = allocRepo;
    }

    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId).orElseThrow();
        List<Resource> resources = resRepo.findByResourceType(req.getResourceType());
        if (resources.isEmpty()) throw new RuntimeException();

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(req);
        allocation.setResource(resources.get(0));
        return allocRepo.save(allocation);
    }

    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
