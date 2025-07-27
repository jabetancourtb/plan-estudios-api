# Etapa 1: build
FROM eclipse-temurin:21-jdk-alpine AS builder

# Crear un directorio de trabajo
WORKDIR /app

# Copiar archivos necesarios para la construcción
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Permitir ejecutar Maven Wrapper
RUN chmod +x mvnw

# Compilar y empaquetar el proyecto (salida en target/)
RUN ./mvnw clean package -DskipTests

# Etapa 2: imagen final optimizada
FROM eclipse-temurin:21-jre-alpine

# Crear un usuario no root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Directorio de trabajo en contenedor
WORKDIR /home/spring

# Copiar el JAR desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Puerto expuesto
EXPOSE 9090

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]