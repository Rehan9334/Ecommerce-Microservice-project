# Ecommerce-Microservice-project

An example e-commerce microservices system (for learning purposes), built using multiple microservices (discovery service, API gateway, user service, product service, order service, payment service) with Docker Compose for easy local setup.

---

## 📄 Table of Contents

1. [Project Overview](#project-overview)  
2. [Architecture & Services](#architecture--services)  
3. [Prerequisites](#prerequisites)  
4. [Getting Started](#getting-started)  
5. [Configuration](#configuration)  
6. [Running (Docker Compose)](#running-docker-compose)  
7. [Technologies Used](#technologies-used)  
8. [Project Status](#project-status)  
9. [Contributing](#contributing)  
10. [License](#license)  

---

## Project Overview

This project is a demonstration of a microservices-based e-commerce backend system.  
It attempts to model a real-world e-commerce architecture by separating concerns across multiple services (user, product, orders, payments), using service discovery, API gateway, and inter-service communication (e.g. with messaging or direct calls).  
The goal is educational — to help you understand how microservices communicate, how to structure such a system, and how to deploy it using containerization.

---

## Architecture & Services

The project consists of the following services:

| Service | Purpose / Role |
|--------|----------------|
| Discovery Server (e.g. Eureka) | Service registry to let services discover each other dynamically |
| API Gateway | Single entry-point for clients, routes requests to appropriate microservices |
| User Service | Manages user data, authentication/authorization (if implemented) |
| Product Service | Manages product catalog, product data (stored in MongoDB) |
| Order Service | Handles orders, order history (stored in MySQL) |
| Payment Service | Handles payment processing logic (stub / demo) |
| (Optionally) Message / Queue / Kafka integration | For asynchronous events (order placed → payment / inventory / notification flows) |

> You can extend this list as you add more services (e.g. “cart service”, “notification service”, etc.)

---

## Prerequisites

Before running the project locally, make sure you have:

- Docker and Docker Compose installed  
- (Optionally) Java / JDK if you plan to build/run services individually without Docker  
- (Optionally) MongoDB and MySQL if you plan to run services outside Docker  

---

## Getting Started

1. Clone the repository:  
   ```bash
   git clone https://github.com/Rehan9334/Ecommerce-Microservice-project.git
   cd Ecommerce-Microservice-project
