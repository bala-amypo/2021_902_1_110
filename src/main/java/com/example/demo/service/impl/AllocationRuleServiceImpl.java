package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import java.util.List;

public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AllocationRuleRepository repo) {
        this.repo = repo;
    }

    public AllocationRule createRule(AllocationRule rule) {
        if (repo.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule exists");
        }
        return repo.save(rule);
    }

    public AllocationRule getRule(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<AllocationRule> getAllRules() {
        return repo.findAll();
    }
}
