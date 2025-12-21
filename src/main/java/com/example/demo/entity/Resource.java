@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String resourceName;

    private String resourceType;
    private Integer capacity;

    public Long getId() {
        return id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
