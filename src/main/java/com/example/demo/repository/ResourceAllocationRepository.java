package com.example.demo.repository;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationRepository {
    List<ResourceAllocation> findAll();
    ResourceAllocation save(ResourceAllocation allocation);
}
