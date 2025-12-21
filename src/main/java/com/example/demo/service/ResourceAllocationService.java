public interface ResourceAllocationService {
    ResourceAllocation autoAllocate(Long requestId);
    ResourceAllocation getAllocation(Long id);
    List<ResourceAllocation> getAllAllocations();
}
