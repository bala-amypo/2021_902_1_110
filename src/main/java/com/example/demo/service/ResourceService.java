public interface ResourceService {
    Resource createResource(Resource resource);
    Resource getResource(Long id);
    List<Resource> getAllResources();
}
