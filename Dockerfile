# Stage 1: We bouwen het .jar bestand
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: We draaien de applicatie
FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/avocado-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]