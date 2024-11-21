package com.zelectec.gestioncentros.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EnvLoader {
    public static void loadEnv(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines
                    .filter(line -> !line.startsWith("#") && line.contains("=")) // Ignorar comentarios y líneas inválidas
                    .forEach(line -> {
                        int idx = line.indexOf("=");
                        String key = line.substring(0, idx).trim();
                        String value = line.substring(idx + 1).trim();
                        System.setProperty(key, value); // Establecer las variables en el entorno del sistema
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo .env: " + e.getMessage(), e);
        }
    }
}
