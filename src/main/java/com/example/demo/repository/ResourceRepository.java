package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Resource;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    boolean existsByResourceName(String resourceName);
    List<Resource> findByResourceType(String resourceType);
}
