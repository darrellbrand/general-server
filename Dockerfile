# ----------- Stage 1: Build with JDK 21 and Gradle 8.5 on Alpine -------------
FROM openjdk:21-alpine as builder

ENV GRADLE_VERSION=8.5

RUN apk add --no-cache curl unzip bash \
  && curl -sSL https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle.zip \
  && unzip gradle.zip -d /opt/gradle \
  && ln -s /opt/gradle/gradle-${GRADLE_VERSION}/bin/gradle /usr/bin/gradle

WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# ----------- Stage 2: Run with JDK 21 on Alpine ----------------
FROM openjdk:21-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /app
COPY --from=builder /app/build/libs/GeneralServer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
