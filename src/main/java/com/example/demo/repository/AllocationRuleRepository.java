package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AllocationRule;

public interface AllocationRuleRepository extends JpaRepository<AllocationRule, Long> {
    boolean existsByRuleName(String ruleName);
}
