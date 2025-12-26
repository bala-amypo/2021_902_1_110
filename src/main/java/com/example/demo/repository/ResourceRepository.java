package com.example.demo.repository;

import com.example.demo.entity.Resource;
import java.util.List;

public interface ResourceRepository {
    boolean existsByResourceName(String name);
    List<Resource> findAll();
    List<Resource> findByResourceType(String type);
    Resource save(Resource resource);
}
