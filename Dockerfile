# Imagen base de Java
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Spring Boot al contenedor
COPY out/artifacts/gestion_zelectec_jar gestion-zelectec.jar app.jar

# Establecer la variable de entorno para el archivo JAR (si es necesario)
# ENV SPRING_PROFILES_ACTIVE=prod

# Exponer el puerto en el que tu aplicación Spring Boot escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
