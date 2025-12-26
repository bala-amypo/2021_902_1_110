package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationServiceImpl
        implements ResourceAllocationService {

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

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        List<Resource> list =
                resRepo.findByResourceType(req.getResourceType());

        if (list.isEmpty()) {
            throw new RuntimeException("No resource available");
        }

        ResourceAllocation alloc = new ResourceAllocation();
        alloc.setRequest(req);
        alloc.setResource(list.get(0));

        return allocRepo.save(alloc);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
