package com.amazingbookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer{
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("https://amazingbookstoreapp.onrender.com")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*");
	}
}
