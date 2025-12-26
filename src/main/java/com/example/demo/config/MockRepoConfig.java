package com.example.demo.config;

import com.example.demo.repository.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockRepoConfig {

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }

    @Bean
    public ResourceRepository resourceRepository() {
        return Mockito.mock(ResourceRepository.class);
    }

    @Bean
    public ResourceRequestRepository resourceRequestRepository() {
        return Mockito.mock(ResourceRequestRepository.class);
    }

    @Bean
    public ResourceAllocationRepository resourceAllocationRepository() {
        return Mockito.mock(ResourceAllocationRepository.class);
    }

    @Bean
    public AllocationRuleRepository allocationRuleRepository() {
        return Mockito.mock(AllocationRuleRepository.class);
    }
}
