FROM openjdk:23-jdk-slim
WORKDIR /app
COPY target/notification-service.jar notification-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "notification-service.jar"]
