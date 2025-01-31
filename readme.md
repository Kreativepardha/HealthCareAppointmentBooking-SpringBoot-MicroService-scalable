
# Healthcare Appointment Booking System

## ¿? Project Overview
This is a **microservices-based** Healthcare Appointment Booking System built using **Spring Boot** for backend services and **React.js** for the frontend. It enables users to book appointments with healthcare professionals, manage profiles, receive real-time notifications, and make secure payments.

---
## ¿? Architecture & Tech Stack

### **Backend (Microservices Architecture)**
- **Spring Boot** ¿ RESTful API development
- **Spring Cloud** ¿ Microservices management
- **Spring Security & Keycloak** ¿ Authentication & Authorization
- **MySQL** ¿ Database management
- **RabbitMQ** ¿ Asynchronous communication
- **WebSockets** ¿ Real-time notifications
- **Resilience4j** ¿ Circuit Breaker, Retry, and Bulkhead patterns
- **Eureka Server** ¿ Service discovery
- **Spring Cloud Gateway** ¿ API Gateway & Load Balancer
- **Docker** ¿ Containerization
- **Prometheus & Grafana** ¿ Monitoring & Logging

### **Frontend**
- **React.js** ¿ UI development
- **Redux** ¿ State management
- **Tailwind CSS** ¿ UI styling
- **Material-UI** ¿ Pre-built UI components
- **Formik** ¿ Form handling & validation

### **DevOps & Deployment**
- **Docker** ¿ Containerized deployment
- **Kubernetes** *(optional)* ¿ Scaling & orchestration
- **CI/CD Pipelines** ¿ Automated builds & deployments
- **Prometheus & Grafana** ¿ API monitoring & visualization

---
## ¿? Microservices Overview

### 1 **User Service**
¿? Handles **user authentication** & profile management.
¿? Integrates **Keycloak** for authentication & authorization.
¿? Generates & validates **JWT tokens**.
¿? Stores user data in **MySQL**.

### 2 **Health Service**
¿? Manages **doctor profiles, specializations, and availability**.
¿? CRUD operations for doctors & healthcare professionals.
¿? Stores doctor information in **MySQL**.

### 3 **Appointment Service**
¿? Enables users to **book, reschedule, and cancel** appointments.
¿? Implements **Resilience4j** (Circuit Breaker, Retry, Bulkhead).
¿? Integrates **RabbitMQ** for event-driven notifications.
¿? Stores booking details in **MySQL**.

### 4 **Payment Service**
¿? Integrates **Razorpay** for secure payment transactions.
¿? Validates payments & updates appointment status.

### 5 **Notification Service**
¿? Uses **RabbitMQ** & **WebSockets** to send real-time notifications.
¿? Notifies users about **appointment confirmations, reminders, and cancellations**.

### 6 **API Gateway (Spring Cloud Gateway)**
¿? Routes requests to respective microservices.
¿? Implements **load balancing, security, and rate limiting**.
¿? Validates **JWT tokens** before forwarding requests.

---
## ¿? Steps Followed (Implementation Roadmap)

### **Step 1: Project Setup & Initialization**
¿? Created **Spring Boot projects** for each microservice.
¿? Added **Maven dependencies** for required libraries.
¿? Set up **MySQL database & Dockerized services**.

### **Step 2: Implemented User Authentication (Keycloak & JWT)**
¿? Configured **Keycloak** as the authentication provider.
¿? Implemented **JWT-based authentication & authorization**.
¿? Built API endpoints for **user registration & login**.

### **Step 3: Developed Health Service (Doctor Management)**
¿? Created **Doctor entity, repository, service, and controller**.
¿? Added CRUD APIs for **doctor profile management**.
¿? Integrated **MySQL** database & exception handling.

### **Step 4: Built Appointment Service (Booking System)**
¿? Created **Appointment entity, repository, and service**.
¿? Implemented **booking, rescheduling, and cancellation APIs**.
¿? Integrated **RabbitMQ** for event-driven notifications.
¿? Added **Resilience4j** (Circuit Breaker, Retry, Bulkhead).

### **Step 5: Integrated Payment Gateway (Razorpay)**
¿? Configured **Razorpay API** for handling payments.
¿? Implemented **payment processing & verification**.
¿? Updated **appointment status** post-payment confirmation.

### **Step 6: Implemented Notification Service (RabbitMQ & WebSockets)**
¿? Integrated **RabbitMQ** for asynchronous messaging.
¿? Implemented **WebSockets** for real-time notifications.
¿? Users get notified for **appointment confirmations & reminders**.

### **Step 7: Built API Gateway (Spring Cloud Gateway)**
¿? Configured API routes & **enabled load balancing**.
¿? Implemented **JWT authentication filter**.
¿? Added **rate limiting & security features**.

### **Step 8: Implemented Service Discovery (Eureka Server)**
¿? Registered all microservices with **Eureka**.
¿? Enabled **dynamic service discovery**.
¿? Integrated API Gateway with **Eureka**.

### **Step 9: Added Monitoring & Logging (Prometheus & Grafana)**
¿? Integrated **Spring Boot Actuator** for metrics.
¿? Configured **Prometheus** to collect API data.
¿? Set up **Grafana dashboards** for real-time monitoring.

---
## ¿? How to Run Locally

### **1 Clone the Repository**
```bash
git clone https://github.com/your-repo/healthcare-booking.git
cd healthcare-booking
```

### **2 Start MySQL Database** (Docker)
```bash
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=healthcare -p 3306:3306 -d mysql
```

### **3 Start RabbitMQ Message Broker**
```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```

### **4 Start Eureka Server**
```bash
cd eureka-server
mvn spring-boot:run
```

### **5 Start Microservices**
```bash
cd user-service && mvn spring-boot:run &
cd appointment-service && mvn spring-boot:run &
cd health-service && mvn spring-boot:run &
cd payment-service && mvn spring-boot:run &
cd notification-service && mvn spring-boot:run &
cd gateway-service && mvn spring-boot:run
```

### **6 Access Services via API Gateway**
¿? **User Service:** `http://localhost:9000/users`
¿? **Appointment Service:** `http://localhost:9000/appointments`
¿? **Health Service:** `http://localhost:9000/health`
¿? **Payment Service:** `http://localhost:9000/payments`
¿? **Notifications:** `http://localhost:9000/notifications`

---
## ¿? Next Steps
- **¿? Add Kubernetes for Service Orchestration**
- **¿? Implement OAuth2 with Keycloak**
- **¿? Improve API Performance with Caching (Redis)**
- **¿? Deploy to AWS/GCP using CI/CD Pipelines**

---
## ¿? Need Help?
If you have any questions or need help, feel free to **open an issue** or **contact me**!

¿? Happy Coding!

