@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String resourceName;

    private String resourceType;
    private Integer capacity;
    private String location;

    private LocalDateTime createdAt = LocalDateTime.now();
}
