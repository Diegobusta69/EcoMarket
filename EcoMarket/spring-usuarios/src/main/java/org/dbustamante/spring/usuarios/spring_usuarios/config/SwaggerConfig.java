package org.dbustamante.spring.usuarios.spring_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Usuarios")
                        .version("1.0")
                        .description("Documentación del microservicio de usuarios"));
    }
}


