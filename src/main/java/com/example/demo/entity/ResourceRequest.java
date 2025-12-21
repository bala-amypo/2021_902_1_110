@Entity
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;

    @ManyToOne
    private User requestedBy;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String purpose;

    private String status = "PENDING";
}
