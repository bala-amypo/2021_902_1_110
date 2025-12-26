package com.example.demo.repository;

import com.example.demo.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository
        extends JpaRepository<Resource, Long> {

    boolean existsByResourceName(String name);
}

