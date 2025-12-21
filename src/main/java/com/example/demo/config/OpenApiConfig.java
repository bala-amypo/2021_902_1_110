@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Resource Allocation Optimizer API")
                        .version("1.0"))
                .servers(List.of(
                        new Server()
                                .url("https://9548.pro604cr.amypo.ai/")
                                .description("Deployed Server")
                ));
    }
}
