package com.saep.plural.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration 
@OpenAPIDefinition(
    info = @Info(
        title = "API REST Plural",
        version = "1.0",
        description = "API REST para o sistema Plural"
    )
)
public class Swagger {
    
}
