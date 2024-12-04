package com.quiz.Quiz.Application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allows all endpoints
                .allowedOrigins("http://localhost:8080","http://192.168.149.89:8080","http://127.0.0.1:5500/","http://192.168.149.89:5500",
                        "https://quizapplicationspringboot-production-e821.up.railway.app") // Allows your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }


}