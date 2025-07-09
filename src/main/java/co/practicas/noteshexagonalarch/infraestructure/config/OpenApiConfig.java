package co.practicas.noteshexagonalarch.infraestructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ensolvers Notes Hexagonal Architecture API")
                        .version("0.1")
                        .description("API to create, modify, delete, archive and filter notes."));
    }
}

