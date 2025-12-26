package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRequestRepository
        extends JpaRepository<ResourceRequest, Long> {
}
