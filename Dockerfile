version: '3.8'

services:
  mysql:
    image: mysql:8
    container_name: mysql-container
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: healthcare_db
    ports:
      - "3306:3306"

  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper-container
    restart: always
    ports:
      - "2181:2181"

  kafka:
    image: wurstmeister/kafka
    container_name: kafka-container
    restart: always
    ports:
      - "9092:9092"
    environment:
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: "true"
    depends_on:
      - zookeeper

  appointment-service:
    build: ./appointment-service
    container_name: appointment-service
    restart: always
    ports:
      - "8081:8081"
    depends_on:
      - mysql
      - kafka
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/healthcare_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
      SPRING_KAFKA_BOOTSTRAP_SERVERS: kafka:9092

  notification-service:
    build: ./notification-service
    container_name: notification-service
    restart: always
    ports:
      - "8082:8082"
    depends_on:
      - kafka
    environment:
      SPRING_KAFKA_BOOTSTRAP_SERVERS: kafka:9092

  user-service:
    build: ./user-service
    container_name: user-service
    restart: always
    ports:
      - "8083:8083"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/healthcare_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
