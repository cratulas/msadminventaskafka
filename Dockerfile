# Etapa 1: Construcción del JAR
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/msadminventaskafka-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8087

ENTRYPOINT ["java", "-jar", "app.jar"]
