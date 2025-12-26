package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AllocationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        if (repository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule exists");
        }
        return repository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return repository.findAll();
    }
}
