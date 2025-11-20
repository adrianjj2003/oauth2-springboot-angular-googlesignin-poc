# Etapa 1: build del jar con Maven (incluye Maven + JDK17)
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos el pom y las fuentes del resource-server
COPY pom.xml .
COPY src ./src

# Compilamos y empaquetamos (sin tests para OKR2)
RUN mvn -B clean package -DskipTests

# Etapa 2: imagen ligera para ejecución
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiamos el jar construido desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto (ajusta si tu app usa otro)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
