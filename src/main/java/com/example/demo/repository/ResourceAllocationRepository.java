package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ResourceAllocation;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {
}
