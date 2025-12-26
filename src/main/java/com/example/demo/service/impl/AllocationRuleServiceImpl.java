package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS IS REQUIRED
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repo;

    // ⚠️ DO NOT change constructor (tests depend on it)
    public AllocationRuleServiceImpl(AllocationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        if (repo.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule exists");
        }
        return repo.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return repo.findAll();
    }
}
