package com.example.orderbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // 예시
        // corsRegistry.addMapping("/order/*")
        //         .allowedOrigins("http://localhost:5173")
        //         .allowedMethods("GET");
    }
}
