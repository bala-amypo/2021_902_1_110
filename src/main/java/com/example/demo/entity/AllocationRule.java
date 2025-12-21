package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Integer priorityWeight;

    public String getRuleName() {
        return ruleName;
    }

    public Integer getPriorityWeight() {
        return priorityWeight;
    }
}
