package com.example.demo.repository;

import com.example.demo.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository {

    boolean existsByResourceName(String name);

    List<Resource> findByResourceType(String type);

    List<Resource> findAll();

    Optional<Resource> findById(Long id);

    Resource save(Resource resource);
}
