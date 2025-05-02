# ----------- Stage 1: Build the application -------------
FROM gradle:8.5-jdk17-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# ----------- Stage 2: Run the application ----------------
FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY --from=builder /app/build/libs/GeneralServer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
