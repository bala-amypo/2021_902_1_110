public interface ResourceRequestService {
    ResourceRequest createRequest(Long userId, ResourceRequest request);
    ResourceRequest getRequest(Long id);
    List<ResourceRequest> getRequestsByUser(Long userId);
    ResourceRequest updateRequestStatus(Long requestId, String status);
}
