package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceRequestService;

import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository reqRepo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(ResourceRequestRepository r, UserRepository u) {
        this.reqRepo = r;
        this.userRepo = u;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest rr) {
        User user = userRepo.findById(userId).orElseThrow();
        rr.setRequestedBy(user);
        rr.setStatus("PENDING");
        return reqRepo.save(rr);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return reqRepo.findByRequestedBy_Id(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long id, String status) {
        ResourceRequest r = reqRepo.findById(id).orElseThrow();
        r.setStatus(status);
        return reqRepo.save(r);
    }
}
