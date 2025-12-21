public interface ResourceRepository extends JpaRepository<Resource, Long> {
    boolean existsByResourceName(String resourceName);
    List<Resource> findByResourceType(String resourceType);
}
