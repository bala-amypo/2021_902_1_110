package com.example.demo.entity;

import java.time.LocalDateTime;

public class AllocationRule {

    private Long id;
    private String ruleName;
    private String ruleType;
    private Integer priorityWeight = 0;
    private LocalDateTime createdAt = LocalDateTime.now();

    public AllocationRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }

    public Integer getPriorityWeight() { return priorityWeight; }
    public void setPriorityWeight(Integer priorityWeight) { this.priorityWeight = priorityWeight; }
}
