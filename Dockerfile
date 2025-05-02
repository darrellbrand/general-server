# ----------- Stage 1: Build the application -------------
FROM gradle:8.5-jdk19 AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# ----------- Stage 2: Run the application ----------------
FROM eclipse-temurin:19-jdk
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring:spring
WORKDIR /app
COPY --from=builder /app/build/libs/GeneralServer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
