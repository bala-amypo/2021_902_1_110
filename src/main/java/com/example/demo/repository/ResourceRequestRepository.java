package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRequestRepository {

    List<ResourceRequest> findByRequestedBy_Id(Long userId);

    List<ResourceRequest> findByStartTimeBetween(
            LocalDateTime start,
            LocalDateTime end
    );

    Optional<ResourceRequest> findById(Long id);

    ResourceRequest save(ResourceRequest request);
}
