package com.nelson.ruiz.ToDoListo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT","DELETE") // Métodos específicos
                .allowedHeaders("Content-Type") // Encabezados específicos
                .exposedHeaders("Content-Disposition") // Exponer encabezados
               // .allowCredentials(true)
                .maxAge(3600); // Cache de CORS por 1 hora
    }


}
