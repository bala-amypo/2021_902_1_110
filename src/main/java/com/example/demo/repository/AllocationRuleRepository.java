package com.example.demo.repository;

import com.example.demo.entity.AllocationRule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AllocationRuleRepository {

    boolean existsByRuleName(String ruleName);
    AllocationRule save(AllocationRule rule);
    Optional<AllocationRule> findById(Long id);
    List<AllocationRule> findAll();
}
