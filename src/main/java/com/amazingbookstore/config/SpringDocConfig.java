package com.amazingbookstore.config;

import java.util.Collections;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi bookStoreApiDocket() {
        return GroupedOpenApi.builder()
                .group("Book Store REST API")
                .pathsToMatch()
                .packagesToScan("com.amazingbookstore.controller")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info().title("Book Store REST API")
                .description("All API's for Book Store Application")
                .version("1.0")
                .contact(new Contact()
                        .name("BookStore Admin")
                        .url("https://amazingbookstore.onrender.com")
                        .email("bookstore@gmail.com"))
                .termsOfService("term and condition url")
                .license(new License().name("book store license").url("license url")));
        openAPI.addExtension("x-vendor-extensions", Collections.emptyList());
        
        return openAPI;
    }
}
