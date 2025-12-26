package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService service;

    public AllocationRuleController(AllocationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AllocationRule createRule(@RequestBody AllocationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<AllocationRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public AllocationRule getRule(@PathVariable Long id) {
        return service.getRule(id);
    }
}
