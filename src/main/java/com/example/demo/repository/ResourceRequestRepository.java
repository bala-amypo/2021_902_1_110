package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ResourceRequestRepository {
    Optional<ResourceRequest> findById(Long id);
    List<ResourceRequest> findByRequestedBy_Id(Long userId);
    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    ResourceRequest save(ResourceRequest request);
}
