package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository reqRepo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(
            ResourceRequestRepository reqRepo,
            UserRepository userRepo) {
        this.reqRepo = reqRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        request.setRequestedBy(user);
        request.setStatus("PENDING");

        return reqRepo.save(request);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return reqRepo.findByRequestedBy_Id(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long id, String status) {
        ResourceRequest req = reqRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        req.setStatus(status);
        return reqRepo.save(req);
    }
}
