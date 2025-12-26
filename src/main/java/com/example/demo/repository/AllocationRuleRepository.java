package com.example.demo.repository;

import com.example.demo.entity.AllocationRule;
import java.util.List;
import java.util.Optional;

public interface AllocationRuleRepository {
    boolean existsByRuleName(String ruleName);
    Optional<AllocationRule> findById(Long id);
    List<AllocationRule> findAll();
    AllocationRule save(AllocationRule rule);
}
