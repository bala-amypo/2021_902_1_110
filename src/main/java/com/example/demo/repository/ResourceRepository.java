@Repository
public interface ResourceRepository
        extends JpaRepository<Resource, Long> {

    boolean existsByResourceName(String name);

    List<Resource> findByResourceType(String type);
}
