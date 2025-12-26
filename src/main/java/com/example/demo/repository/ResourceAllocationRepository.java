package com.example.demo.repository;

import com.example.demo.entity.ResourceAllocation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceAllocationRepository
        extends JpaRepository<ResourceAllocation, Long> {
}

