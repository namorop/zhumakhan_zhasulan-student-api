# Stage 1: build jar with JDK + Gradle wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon

# Stage 2: run jar on small JRE image
FROM eclipse-temurin:21-jre
LABEL author="Zhumakhan Zhasulan"
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
