# Etapa 1: build del jar con Maven
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copiamos el pom y las fuentes del resource-server
COPY pom.xml .
COPY src ./src

# Compilamos y empaquetamos
RUN ./mvnw -B clean package -DskipTests || mvn -B clean package -DskipTests

# Etapa 2: imagen ligera para ejecución
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiamos el jar construido desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto del resource-server (ajústalo si en tu app es otro)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
