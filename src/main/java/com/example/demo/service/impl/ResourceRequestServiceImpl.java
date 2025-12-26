package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceRequestService;
import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository reqRepo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(ResourceRequestRepository reqRepo, UserRepository userRepo) {
        this.reqRepo = reqRepo;
        this.userRepo = userRepo;
    }

    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        User user = userRepo.findById(userId).orElseThrow();
        request.setRequestedBy(user);
        request.setStatus("PENDING");
        return reqRepo.save(request);
    }

    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return reqRepo.findByRequestedBy_Id(userId);
    }

    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest r = reqRepo.findById(requestId).orElseThrow();
        r.setStatus(status);
        return reqRepo.save(r);
    }
}
