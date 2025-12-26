package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceAllocationService;

import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository r, ResourceRepository res, ResourceAllocationRepository a) {
        this.reqRepo = r;
        this.resRepo = res;
        this.allocRepo = a;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId).orElseThrow();
        List<Resource> list = resRepo.findByResourceType(req.getResourceType());
        if (list.isEmpty()) throw new RuntimeException("No resource");

        ResourceAllocation a = new ResourceAllocation();
        a.setResource(list.get(0));
        a.setRequest(req);
        return allocRepo.save(a);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
