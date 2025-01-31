

FROM openjdk:23-jdk-slim

WORKDIR /app

COPY target/appointment-service.jar appointment-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "appointment-service.jar"]