@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Resource Allocation Optimizer API")
                        .version("1.0"));
    }
}
