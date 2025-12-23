package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
                                .url("http://9036.408procr.amypo.ai")
                                .description("Backend Server")
                ));
    }
}
