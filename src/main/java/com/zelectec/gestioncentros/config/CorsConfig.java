package com.zelectec.gestioncentros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todas las rutas
                .allowedOrigins( // Dominio permitido (cambiar según tu entorno)
                        "http://localhost:4200",
                        "https://centro-tecnico.netlify.app"

                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","PATCH") // Métodos HTTP permitidos
                .allowedHeaders("*") // Cabeceras permitidas
                .allowCredentials(true)
                .exposedHeaders("Authorization"); // Permite el uso de credenciales (cookies, auth, etc.)
    }
}
