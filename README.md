# 🛒 E-Commerce Platform

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED.svg)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> A production-ready, scalable e-commerce backend platform built with enterprise-grade Spring Boot architecture, demonstrating modern software engineering practices and comprehensive testing strategies.

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Technology Stack](#-technology-stack)
- [System Architecture](#-system-architecture)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Testing Strategy](#-testing-strategy)
- [Deployment](#-deployment)
- [Project Structure](#-project-structure)
- [Performance & Optimization](#-performance--optimization)
- [Roadmap](#-roadmap)
- [Contact](#-contact)

---

## 🎯 Overview

This e-commerce platform is a **robust, enterprise-grade backend solution** designed to handle real-world e-commerce operations at scale. Built with Spring Boot 3.3.3 and following clean architecture principles, this project demonstrates professional-level software development practices including:

- **Comprehensive domain modeling** with properly designed entity relationships
- **Layered architecture** ensuring separation of concerns and maintainability
- **Production-ready security** with Spring Security integration
- **Extensive test coverage** using industry-standard testing frameworks
- **CI/CD automation** with GitHub Actions and Docker containerization
- **Multi-database support** enabling flexible deployment scenarios

### Business Value

This platform addresses core e-commerce business challenges:
- **Customer Management**: Secure user authentication and profile management
- **Inventory Control**: Real-time product catalog with quantity tracking
- **Order Processing**: Complex order management with multi-item support and status tracking
- **Scalability**: Designed to handle growing transaction volumes and user bases
- **Maintainability**: Clean code architecture facilitating rapid feature development

---

## ✨ Key Features

### Core Business Functionality
- **User Management System**: Complete CRUD operations with secure authentication and authorization
- **Product Catalog Management**: Full lifecycle management including inventory tracking and pricing
- **Advanced Order Processing**: Multi-item order support with relationship mapping between orders and order items
- **Order Item Management**: Granular control over individual items within orders, supporting complex e-commerce scenarios

### Technical Excellence
- **RESTful API Design**: Industry-standard REST endpoints with proper HTTP verb usage and status codes
- **Spring Security Integration**: Robust authentication and authorization framework ready for JWT implementation
- **JPA/Hibernate ORM**: Efficient database interactions with optimized query generation
- **Transaction Management**: ACID-compliant operations ensuring data integrity
- **Actuator Integration**: Production-ready monitoring and health check endpoints
- **Error Handling**: Comprehensive exception handling with meaningful error responses

### DevOps & Quality Assurance
- **Automated CI/CD Pipeline**: GitHub Actions workflow for continuous integration and deployment
- **Docker Containerization**: Production-ready container images published to GitHub Container Registry
- **Comprehensive Testing**: Unit tests with Mockito and integration tests ensuring reliability
- **Multi-Environment Configuration**: Separate configurations for development, testing, and production
- **Database Flexibility**: Support for both H2 (development/testing) and MySQL (production)

---

## 🛠 Technology Stack

### Backend Framework
- **Java 17** - Latest LTS version with modern language features
- **Spring Boot 3.3.3** - Enterprise-grade application framework
  - Spring Web - RESTful API development
  - Spring Data JPA - Simplified data access layer
  - Spring Security - Authentication and authorization
  - Spring Boot Actuator - Application monitoring and metrics
  - Spring Boot DevTools - Enhanced development experience

### Database & Persistence
- **MySQL 8.0** - Production database (supports scalability and ACID compliance)
- **H2 Database** - In-memory database for testing (enables fast, isolated test execution)
- **Hibernate** - Advanced ORM with lazy loading and caching capabilities

### Testing & Quality
- **JUnit 5** - Modern testing framework with advanced assertion capabilities
- **Mockito** - Sophisticated mocking framework for unit testing
- **Spring Boot Test** - Integration testing support with test containers

### Build & Deployment
- **Maven 3.6+** - Dependency management and build automation
- **Docker** - Containerization for consistent deployment across environments
- **GitHub Actions** - Automated CI/CD pipeline
- **GitHub Packages** - Artifact repository for Maven and Docker images

### Development Tools
- **Lombok** - Reduces boilerplate code, improves maintainability
- **Jackson** - JSON serialization with custom date formatting
- **Maven Wrapper** - Ensures consistent Maven version across development teams

### Why These Technologies?

- **Spring Boot 3.3.3**: Chosen for its production-ready features, extensive ecosystem, and strong community support
- **Java 17**: LTS version providing modern language features (records, pattern matching, sealed classes) while ensuring long-term stability
- **MySQL**: Industry-standard relational database offering excellent performance, reliability, and horizontal scaling capabilities
- **Docker**: Enables microservice architecture readiness and simplifies deployment across different environments

---

## 🏗 System Architecture

This platform implements a **clean, layered architecture** following Domain-Driven Design principles:

```
┌─────────────────────────────────────────────────────────┐
│                     Client Layer                        │
│              (REST API Consumers)                       │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                Controller Layer                         │
│   (OrderController, ProductController, UserController)  │
│   • Request validation                                  │
│   • Response formatting                                 │
│   • HTTP status code management                         │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                 Service Layer                           │
│   (OrderService, ProductService, UserService)           │
│   • Business logic implementation                       │
│   • Transaction management                              │
│   • Data transformation                                 │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│               Repository Layer                          │
│   (OrderRepository, ProductRepository, UserRepository)  │
│   • Data access abstraction                             │
│   • Query optimization                                  │
│   • Database operations                                 │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                Database Layer                           │
│           (MySQL / H2 Database)                         │
└─────────────────────────────────────────────────────────┘
```

### Design Patterns Implemented

- **Repository Pattern**: Abstracts data access logic, making the codebase database-agnostic
- **Dependency Injection**: Promotes loose coupling and testability through constructor injection
- **DTO Pattern**: Separates internal domain models from API contracts (via request/response objects)
- **Layered Architecture**: Clear separation of concerns enabling independent layer testing and modification

### Entity Relationships

```
User (1) ──────── (N) Order
                      │
                      │ (1)
                      │
                      │ (N)
                   OrderItem (N) ──────── (1) Product
```

- **One-to-Many**: User → Orders (A user can have multiple orders)
- **One-to-Many**: Order → OrderItems (An order can contain multiple items)
- **Many-to-One**: OrderItem → Product (Multiple order items can reference the same product)

This design ensures **data normalization**, **referential integrity**, and **efficient query performance**.

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java Development Kit (JDK) 17 or higher**
  ```bash
  java -version  # Should output 17 or higher
  ```
- **Maven 3.6+** (or use included Maven Wrapper)
  ```bash
  mvn -version
  ```
- **MySQL 8.0+** (for production deployment)
  ```bash
  mysql --version
  ```
- **Docker** (optional, for containerized deployment)
  ```bash
  docker --version
  ```

### Installation & Setup

#### 1. Clone the Repository
```bash
git clone https://github.com/ensuca/ecommerce-platform.git
cd ecommerce-platform
```

#### 2. Database Configuration

##### For MySQL (Production)
Create a MySQL database:
```sql
CREATE DATABASE ecommerce_platform_db;
```

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_platform_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

##### For H2 (Development/Testing)
Uncomment the H2 configuration in `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

#### 3. Build the Project
Using Maven Wrapper (recommended):
```bash
./mvnw clean install
```

Or using system Maven:
```bash
mvn clean install
```

This command will:
- Compile the source code
- Run all unit and integration tests
- Package the application as a JAR file
- Install artifacts to your local Maven repository

#### 4. Run the Application

Using Maven:
```bash
./mvnw spring-boot:run
```

Or run the JAR directly:
```bash
java -jar target/ecommerce-platform-0.0.1-SNAPSHOT.jar
```

The application will start on **http://localhost:8080**

#### 5. Verify Installation

Check application health:
```bash
curl http://localhost:8080/actuator/health
```

Expected response:
```json
{"status":"UP"}
```

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Authentication
> **Note**: Spring Security is configured. For production use, implement JWT-based authentication by extending the existing security configuration.

---

### User Management Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/users` | Retrieve all users | - | `200 OK` with user array |
| `GET` | `/users/{id}` | Get specific user by ID | - | `200 OK` with user object<br>`404 Not Found` if user doesn't exist |
| `POST` | `/users` | Create new user | User JSON | `201 Created` with created user |
| `PUT` | `/users/{id}` | Update existing user | User JSON | `200 OK` with updated user |
| `DELETE` | `/users/{id}` | Delete user | - | `204 No Content` |

**User Model:**
```json
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "password": "hashed_password"
}
```

---

### Product Management Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/products` | Retrieve all products | - | `200 OK` with product array |
| `GET` | `/products/{id}` | Get specific product | - | `200 OK` with product object<br>`404 Not Found` if not exists |
| `POST` | `/products` | Add new product | Product JSON | `201 Created` with created product |
| `PUT` | `/products/{id}` | Update product details | Product JSON | `200 OK` with updated product |
| `DELETE` | `/products/{id}` | Remove product | - | `204 No Content` |

**Product Model:**
```json
{
  "id": 1,
  "name": "Premium Laptop",
  "description": "High-performance laptop with 16GB RAM",
  "price": 1299.99,
  "quantity": 50
}
```

---

### Order Management Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/orders` | Retrieve all orders | - | `200 OK` with order array |
| `GET` | `/orders/{id}` | Get specific order | - | `200 OK` with order object<br>`404 Not Found` if not exists |
| `POST` | `/orders` | Create new order | CreateOrderRequest JSON | `201 Created` with created order |
| `PUT` | `/orders/{id}` | Update order status/details | Order JSON | `200 OK` with updated order |
| `DELETE` | `/orders/{id}` | Cancel/delete order | - | `204 No Content` |

**CreateOrderRequest Model:**
```json
{
  "order": {
    "userId": 1,
    "productId": 1,
    "quantity": 2,
    "orderDate": "2025-10-01T14:30:00",
    "status": "PENDING"
  },
  "orderItems": [
    {
      "productId": 1,
      "quantity": 2,
      "orderId": 1
    }
  ]
}
```

**Order Response Model:**
```json
{
  "id": 1,
  "userId": 1,
  "productId": 1,
  "quantity": 2,
  "orderDate": "2025-10-01T14:30:00",
  "status": "PENDING",
  "orderItems": [
    {
      "id": 1,
      "orderId": 1,
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

---

### Order Item Management Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/order-items` | Retrieve all order items | - | `200 OK` with order item array |
| `GET` | `/order-items/{id}` | Get specific order item | - | `200 OK` with order item object |
| `POST` | `/order-items` | Add item to order | OrderItem JSON | `201 Created` |
| `PUT` | `/order-items/{id}` | Update order item | OrderItem JSON | `200 OK` |
| `DELETE` | `/order-items/{id}` | Remove order item | - | `204 No Content` |

---

### Example API Usage

#### Create a New Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse with USB receiver",
    "price": 29.99,
    "quantity": 100
  }'
```

#### Create an Order with Multiple Items
```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "order": {
      "userId": 1,
      "productId": 1,
      "quantity": 3,
      "orderDate": "2025-10-01T10:00:00",
      "status": "PENDING"
    },
    "orderItems": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 2,
        "quantity": 1
      }
    ]
  }'
```

---

## 🧪 Testing Strategy

This project demonstrates **professional testing practices** with comprehensive coverage across multiple testing levels.

### Test Architecture

- **Unit Tests**: Test individual components in isolation using Mockito
- **Integration Tests**: Verify interactions between layers using Spring Boot Test
- **Repository Tests**: Validate data access logic using `@DataJpaTest`

### Running Tests

Execute all tests:
```bash
./mvnw test
```

Run tests with coverage report:
```bash
./mvnw test jacoco:report
```

Run specific test class:
```bash
./mvnw test -Dtest=OrderServiceTest
```

### Test Coverage Highlights

#### OrderServiceTest Example
Located at `src/test/java/com/enesuca/ecommerceplatform/order_/service/OrderServiceTest.java:1`

Key test scenarios:
- ✅ **Order Creation**: Validates order persistence with order items
- ✅ **Order Retrieval**: Tests finding orders by ID with proper Optional handling
- ✅ **Order Item Addition**: Verifies relationship management between orders and items
- ✅ **Edge Cases**: Tests order-not-found scenarios and null handling
- ✅ **Repository Interactions**: Confirms proper mock interactions and verification

### Testing Technologies
- **JUnit 5**: Parameterized tests, nested tests, and lifecycle management
- **Mockito**: Behavior verification, argument captors, and spy functionality
- **@DataJpaTest**: Optimized JPA testing with in-memory H2 database
- **MockMvc**: Controller layer testing with request/response validation

### Continuous Testing
GitHub Actions automatically runs the full test suite on every push and pull request, ensuring code quality and preventing regressions.

---

## 🐳 Deployment

### Docker Deployment

#### Build Docker Image
```bash
# First, package the application
./mvnw clean package -DskipTests

# Build Docker image
docker build -t ecommerce-platform:latest .
```

#### Run with Docker
```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/ecommerce_platform_db \
  -e SPRING_DATASOURCE_USERNAME=your_username \
  -e SPRING_DATASOURCE_PASSWORD=your_password \
  ecommerce-platform:latest
```

#### Docker Compose (with MySQL)
Create `docker-compose.yml`:
```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: rootpass
      MYSQL_DATABASE: ecommerce_platform_db
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql

  app:
    image: ecommerce-platform:latest
    depends_on:
      - mysql
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/ecommerce_platform_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: rootpass

volumes:
  mysql-data:
```

Run with:
```bash
docker-compose up -d
```

---

### CI/CD Pipeline

This project includes a **production-ready GitHub Actions workflow** (`.github/workflows/maven-publish.yml:1`) that automates:

1. **Build & Test**: Compiles code and runs test suite
2. **Maven Package Publishing**: Publishes artifacts to GitHub Packages
3. **Docker Image Creation**: Builds optimized container images
4. **Container Registry Push**: Publishes to GitHub Container Registry with SHA tags
5. **Artifact Archiving**: Uploads test reports and logs for troubleshooting

#### Workflow Triggers
- Manual dispatch via GitHub UI
- Can be extended for automatic triggers (push to main, pull requests, etc.)

#### Using Published Packages

Pull the Docker image:
```bash
docker pull ghcr.io/ensuca/ecommerce-platform/ecommerce-platform:latest
```

---

### Environment Configuration

#### Required Environment Variables

| Variable | Description | Example |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | Database connection URL | `jdbc:mysql://localhost:3306/ecommerce_platform_db` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `ecommerce_user` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `secure_password` |
| `SPRING_JPA_HIBERNATE_DDL_AUTO` | Hibernate schema generation | `validate` (production), `update` (development) |
| `SERVER_PORT` | Application port | `8080` |

#### Production Deployment Checklist
- [ ] Set `spring.jpa.hibernate.ddl-auto=validate` to prevent schema modifications
- [ ] Configure proper database connection pooling
- [ ] Enable HTTPS/TLS encryption
- [ ] Implement JWT authentication for API security
- [ ] Set up database backups and replication
- [ ] Configure logging to external aggregation service
- [ ] Enable Spring Boot Actuator with secured endpoints
- [ ] Set up monitoring and alerting (Prometheus, Grafana, etc.)

---

## 📂 Project Structure

```
ecommerce-platform/
├── .github/
│   └── workflows/
│       └── maven-publish.yml      # CI/CD pipeline configuration
├── .mvn/                           # Maven wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/com/enesuca/ecommerceplatform/
│   │   │   ├── EcommercePlatformApplication.java  # Main application entry point
│   │   │   ├── order_/
│   │   │   │   ├── controller/
│   │   │   │   │   ├── CreateOrderRequest.java    # DTO for order creation
│   │   │   │   │   ├── OrderController.java       # Order REST endpoints
│   │   │   │   │   └── OrderItemController.java   # Order item endpoints
│   │   │   │   ├── model/
│   │   │   │   │   ├── Order_.java                # Order entity with relationships
│   │   │   │   │   └── OrderItem.java             # Order item entity
│   │   │   │   ├── repository/
│   │   │   │   │   ├── OrderRepository.java       # Order data access
│   │   │   │   │   └── OrderItemRepository.java   # Order item data access
│   │   │   │   └── service/
│   │   │   │       ├── OrderService.java          # Order business logic
│   │   │   │       └── OrderItemService.java      # Order item business logic
│   │   │   ├── product/
│   │   │   │   ├── controller/
│   │   │   │   │   └── ProductController.java     # Product REST endpoints
│   │   │   │   ├── model/
│   │   │   │   │   └── Product.java               # Product entity with validation
│   │   │   │   ├── repository/
│   │   │   │   │   └── ProductRepository.java     # Product data access
│   │   │   │   └── service/
│   │   │   │       └── ProductService.java        # Product business logic
│   │   │   └── user/
│   │   │       ├── controller/
│   │   │       │   └── UserController.java        # User REST endpoints
│   │   │       ├── model/
│   │   │       │   └── User.java                  # User entity
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java        # User data access
│   │   │       └── service/
│   │   │           └── UserService.java           # User business logic
│   │   └── resources/
│   │       └── application.properties              # Application configuration
│   └── test/
│       ├── java/com/enesuca/ecommerceplatform/
│       │   ├── EcommercePlatformApplicationTests.java  # Application context tests
│       │   └── order_/
│       │       ├── controller/
│       │       │   ├── OrderControllerTest.java        # Controller integration tests
│       │       │   └── OrderItemControllerTest.java
│       │       └── service/
│       │           ├── OrderServiceTest.java           # Service unit tests
│       │           └── OrderItemServiceTest.java
│       └── resources/
│           └── application-test.properties         # Test-specific configuration
├── target/                         # Build output directory
├── Dockerfile                      # Container image definition
├── pom.xml                        # Maven project configuration
├── mvnw / mvnw.cmd                # Maven wrapper scripts
└── README.md                      # Project documentation
```

### Key Directories

- **`controller/`**: REST API endpoints handling HTTP requests/responses
- **`service/`**: Business logic layer with transaction management
- **`repository/`**: Spring Data JPA interfaces for database operations
- **`model/`**: JPA entities representing database tables
- **`test/`**: Comprehensive test suite with unit and integration tests

---

## ⚡ Performance & Optimization

### Database Optimizations
- **Lazy Loading**: Entity relationships configured with lazy fetching to prevent N+1 query problems
- **Connection Pooling**: HikariCP (Spring Boot default) for efficient database connection management
- **Index Strategy**: Primary keys and foreign keys automatically indexed by JPA
- **Query Optimization**: Spring Data JPA generates optimized queries based on method names

### Application Performance
- **Actuator Monitoring**: Built-in health checks and metrics endpoints for performance tracking
- **Spring DevTools**: Automatic restart and live reload during development
- **Jackson Optimization**: Efficient JSON serialization with custom date formatters
- **Hibernate Second-Level Cache Ready**: Architecture supports adding caching layer for frequently accessed data

### Scalability Considerations
- **Stateless Design**: Controllers are stateless, enabling horizontal scaling
- **Database Migration Ready**: JPA schema updates can be replaced with Flyway/Liquibase for production
- **Containerization**: Docker support enables deployment to Kubernetes or cloud platforms
- **RESTful Architecture**: Enables microservice decomposition if needed

### Future Performance Enhancements
- Implement Redis caching for frequently accessed products
- Add database read replicas for query load distribution
- Implement pagination for large result sets
- Add GraphQL endpoint for flexible client data fetching
- Integrate monitoring solutions (Prometheus, Grafana, ELK stack)

---

## 🗺 Roadmap

### Short-term Goals (Next Release)
- [ ] **JWT Authentication Implementation**: Complete the Spring Security configuration with JWT tokens
- [ ] **Input Validation Enhancement**: Add comprehensive Bean Validation annotations (`@Valid`, `@NotNull`, etc.)
- [ ] **API Documentation**: Integrate Swagger/OpenAPI for interactive API documentation
- [ ] **Pagination & Filtering**: Add pagination support to all GET endpoints
- [ ] **Exception Handling**: Implement global exception handler with meaningful error messages

### Mid-term Goals (v2.0)
- [ ] **Payment Gateway Integration**: Integrate Stripe/PayPal for order payments
- [ ] **Email Notifications**: Order confirmation and status update emails
- [ ] **Product Categories**: Add category hierarchy for better product organization
- [ ] **Shopping Cart**: Implement cart functionality with session management
- [ ] **User Roles & Permissions**: Add admin/customer role-based access control
- [ ] **Order History & Tracking**: Enhanced order tracking with status timeline

### Long-term Vision (v3.0+)
- [ ] **Microservices Architecture**: Decompose into independent services (User, Product, Order, Payment)
- [ ] **Event-Driven Architecture**: Implement Apache Kafka for asynchronous communication
- [ ] **GraphQL API**: Alternative API endpoint for flexible data querying
- [ ] **Full-Text Search**: Integrate Elasticsearch for advanced product search
- [ ] **Mobile App Support**: Dedicated mobile API endpoints with push notifications
- [ ] **Analytics Dashboard**: Admin dashboard with sales analytics and reporting

### Known Limitations
- **Security**: Current implementation has basic Spring Security; JWT needs to be fully implemented
- **Scalability**: Single database instance; needs read replicas and caching for high traffic
- **Validation**: Limited input validation; needs comprehensive Bean Validation
- **Documentation**: API documentation could be enhanced with Swagger UI

---

## 📞 Contact

**Enes Uca** - Full Stack Developer

- 💼 **LinkedIn**: [linkedin.com/in/enes-uca-41039327b](https://www.linkedin.com/in/enes-uca-41039327b)
- 🐙 **GitHub**: [@ensuca](https://github.com/ensuca)
- 🌐 **Portfolio**: [ensuca.github.io/ensuca.githubio](https://ensuca.github.io/ensuca.githubio)
- 📧 **Email**: enesuca55@gmail.com

### Project Links
- **Repository**: [github.com/ensuca/ecommerce-platform](https://github.com/ensuca/ecommerce-platform)
- **Issues & Bug Reports**: [github.com/ensuca/ecommerce-platform/issues](https://github.com/ensuca/ecommerce-platform/issues)
- **Pull Requests**: Contributions are welcome!

---

## 📄 License

This project is available for portfolio demonstration and educational purposes. For commercial use, please contact the author.

---

## 🙏 Acknowledgments

Built with industry-leading technologies:
- [Spring Framework](https://spring.io/) - Comprehensive programming and configuration model
- [Hibernate](https://hibernate.org/) - Object-relational mapping framework
- [MySQL](https://www.mysql.com/) - Reliable, scalable database management system
- [Docker](https://www.docker.com/) - Containerization platform

---

<div align="center">

**⭐ If you find this project impressive, please consider starring it on GitHub! ⭐**

*Built with passion for clean code and best practices*

</div>

---
---
---

# 🇹🇷 Türkçe

# 🛒 E-Ticaret Platformu

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED.svg)](https://www.docker.com/)
[![Lisans](https://img.shields.io/badge/Lisans-MIT-yellow.svg)](LICENSE)

> Kurumsal düzeyde Spring Boot mimarisi ile geliştirilmiş, üretime hazır, ölçeklenebilir bir e-ticaret backend platformu. Modern yazılım mühendisliği pratikleri ve kapsamlı test stratejilerini sergiler.

## 📋 İçindekiler

- [Genel Bakış](#-genel-bakış)
- [Temel Özellikler](#-temel-özellikler)
- [Teknoloji Yığını](#-teknoloji-yığını)
- [Sistem Mimarisi](#-sistem-mimarisi)
- [Başlangıç](#-başlangıç)
- [API Dokümantasyonu](#-api-dokümantasyonu)
- [Test Stratejisi](#-test-stratejisi)
- [Deployment (Dağıtım)](#-deployment-dağıtım)
- [Proje Yapısı](#-proje-yapısı)
- [Performans & Optimizasyon](#-performans--optimizasyon)
- [Yol Haritası](#-yol-haritası)
- [İletişim](#-i̇letişim)

---

## 🎯 Genel Bakış

Bu e-ticaret platformu, gerçek dünya e-ticaret operasyonlarını ölçekte yönetmek için tasarlanmış **sağlam, kurumsal düzeyde bir backend çözümüdür**. Spring Boot 3.3.3 ile geliştirilmiş ve temiz mimari prensiplerini takip eden bu proje, profesyonel seviye yazılım geliştirme pratiklerini gösterir:

- **Kapsamlı domain modelleme** düzgün tasarlanmış varlık ilişkileri ile
- **Katmanlı mimari** endişelerin ayrılması ve sürdürülebilirliği sağlar
- **Üretime hazır güvenlik** Spring Security entegrasyonu ile
- **Kapsamlı test kapsamı** endüstri standardı test framework'leri kullanarak
- **CI/CD otomasyonu** GitHub Actions ve Docker konteynerizasyon ile
- **Çoklu veritabanı desteği** esnek dağıtım senaryolarını mümkün kılar

### İş Değeri

Bu platform, temel e-ticaret iş zorluklarını çözer:
- **Müşteri Yönetimi**: Güvenli kullanıcı kimlik doğrulama ve profil yönetimi
- **Envanter Kontrolü**: Miktar takibi ile gerçek zamanlı ürün kataloğu
- **Sipariş İşleme**: Çoklu ürün desteği ve durum takibi ile karmaşık sipariş yönetimi
- **Ölçeklenebilirlik**: Artan işlem hacimleri ve kullanıcı tabanlarını yönetecek şekilde tasarlanmış
- **Sürdürülebilirlik**: Hızlı özellik geliştirmeyi kolaylaştıran temiz kod mimarisi

---

## ✨ Temel Özellikler

### Temel İş Fonksiyonları
- **Kullanıcı Yönetim Sistemi**: Güvenli kimlik doğrulama ve yetkilendirme ile eksiksiz CRUD işlemleri
- **Ürün Katalog Yönetimi**: Envanter takibi ve fiyatlandırma dahil tam yaşam döngüsü yönetimi
- **Gelişmiş Sipariş İşleme**: Siparişler ve sipariş kalemleri arasında ilişki eşlemesi ile çoklu ürün desteği
- **Sipariş Kalemi Yönetimi**: Karmaşık e-ticaret senaryolarını destekleyen, siparişler içindeki bireysel kalemler üzerinde detaylı kontrol

### Teknik Mükemmellik
- **RESTful API Tasarımı**: Uygun HTTP metod kullanımı ve durum kodları ile endüstri standardı REST endpoint'leri
- **Spring Security Entegrasyonu**: JWT implementasyonu için hazır, sağlam kimlik doğrulama ve yetkilendirme framework'ü
- **JPA/Hibernate ORM**: Optimize edilmiş sorgu üretimi ile verimli veritabanı etkileşimleri
- **Transaction Yönetimi**: Veri bütünlüğünü sağlayan ACID uyumlu işlemler
- **Actuator Entegrasyonu**: Üretime hazır izleme ve sağlık kontrolü endpoint'leri
- **Hata Yönetimi**: Anlamlı hata yanıtları ile kapsamlı exception handling

### DevOps & Kalite Güvencesi
- **Otomatik CI/CD Pipeline**: Sürekli entegrasyon ve dağıtım için GitHub Actions workflow'u
- **Docker Konteynerizasyon**: GitHub Container Registry'ye yayınlanan üretime hazır konteyner imajları
- **Kapsamlı Test**: Güvenilirliği sağlayan Mockito ile birim testleri ve entegrasyon testleri
- **Çoklu Ortam Yapılandırması**: Geliştirme, test ve üretim için ayrı konfigürasyonlar
- **Veritabanı Esnekliği**: Hem H2 (geliştirme/test) hem de MySQL (üretim) desteği

---

## 🛠 Teknoloji Yığını

### Backend Framework
- **Java 17** - Modern dil özellikleri ile en son LTS sürümü
- **Spring Boot 3.3.3** - Kurumsal düzeyde uygulama framework'ü
  - Spring Web - RESTful API geliştirme
  - Spring Data JPA - Basitleştirilmiş veri erişim katmanı
  - Spring Security - Kimlik doğrulama ve yetkilendirme
  - Spring Boot Actuator - Uygulama izleme ve metrikler
  - Spring Boot DevTools - Geliştirilmiş geliştirme deneyimi

### Veritabanı & Kalıcılık
- **MySQL 8.0** - Üretim veritabanı (ölçeklenebilirlik ve ACID uyumluluğu destekler)
- **H2 Database** - Test için in-memory veritabanı (hızlı, izole test yürütmeyi sağlar)
- **Hibernate** - Lazy loading ve caching yetenekleri ile gelişmiş ORM

### Test & Kalite
- **JUnit 5** - Gelişmiş assertion yetenekleri ile modern test framework'ü
- **Mockito** - Birim test için sofistike mocking framework'ü
- **Spring Boot Test** - Test container'ları ile entegrasyon test desteği

### Build & Deployment
- **Maven 3.6+** - Bağımlılık yönetimi ve build otomasyonu
- **Docker** - Ortamlar arası tutarlı dağıtım için konteynerizasyon
- **GitHub Actions** - Otomatik CI/CD pipeline
- **GitHub Packages** - Maven ve Docker imajları için artifact repository

### Geliştirme Araçları
- **Lombok** - Boilerplate kodu azaltır, sürdürülebilirliği artırır
- **Jackson** - Özel tarih formatlama ile JSON serileştirme
- **Maven Wrapper** - Geliştirme ekipleri arasında tutarlı Maven sürümü sağlar

### Neden Bu Teknolojiler?

- **Spring Boot 3.3.3**: Üretime hazır özellikleri, geniş ekosistemi ve güçlü topluluk desteği için seçildi
- **Java 17**: Uzun vadeli kararlılığı sağlarken modern dil özelliklerini (records, pattern matching, sealed classes) sunan LTS sürümü
- **MySQL**: Mükemmel performans, güvenilirlik ve yatay ölçeklendirme yetenekleri sunan endüstri standardı ilişkisel veritabanı
- **Docker**: Mikroservis mimarisine hazırlığı sağlar ve farklı ortamlara dağıtımı basitleştirir

---

## 🏗 Sistem Mimarisi

Bu platform, Domain-Driven Design prensiplerini takip eden **temiz, katmanlı bir mimari** uygular:

```
┌─────────────────────────────────────────────────────────┐
│                   İstemci Katmanı                       │
│              (REST API Tüketicileri)                    │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                Controller Katmanı                       │
│   (OrderController, ProductController, UserController)  │
│   • İstek doğrulama                                     │
│   • Yanıt formatlama                                    │
│   • HTTP durum kodu yönetimi                            │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│                 Servis Katmanı                          │
│   (OrderService, ProductService, UserService)           │
│   • İş mantığı implementasyonu                          │
│   • Transaction yönetimi                                │
│   • Veri dönüşümü                                       │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│              Repository Katmanı                         │
│   (OrderRepository, ProductRepository, UserRepository)  │
│   • Veri erişim soyutlaması                             │
│   • Sorgu optimizasyonu                                 │
│   • Veritabanı işlemleri                                │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────────┐
│               Veritabanı Katmanı                        │
│           (MySQL / H2 Veritabanı)                       │
└─────────────────────────────────────────────────────────┘
```

### Uygulanan Tasarım Desenleri

- **Repository Pattern**: Veri erişim mantığını soyutlar, kod tabanını veritabanından bağımsız hale getirir
- **Dependency Injection**: Constructor injection yoluyla gevşek bağlılık ve test edilebilirlik sağlar
- **DTO Pattern**: İç domain modellerini API sözleşmelerinden ayırır (request/response nesneleri aracılığıyla)
- **Layered Architecture**: Bağımsız katman testi ve değişikliğini sağlayan net endişe ayrımı

### Varlık İlişkileri

```
User (1) ──────── (N) Order
                      │
                      │ (1)
                      │
                      │ (N)
                   OrderItem (N) ──────── (1) Product
```

- **Bire-Çok**: User → Orders (Bir kullanıcının birden fazla siparişi olabilir)
- **Bire-Çok**: Order → OrderItems (Bir sipariş birden fazla kalem içerebilir)
- **Çoka-Bir**: OrderItem → Product (Birden fazla sipariş kalemi aynı ürüne referans verebilir)

Bu tasarım **veri normalizasyonu**, **referans bütünlüğü** ve **verimli sorgu performansı** sağlar.

---

## 🚀 Başlangıç

### Ön Gereksinimler

Aşağıdakilerin kurulu olduğundan emin olun:

- **Java Development Kit (JDK) 17 veya üzeri**
  ```bash
  java -version  # 17 veya üzeri çıktı vermeli
  ```
- **Maven 3.6+** (veya dahil edilen Maven Wrapper'ı kullanın)
  ```bash
  mvn -version
  ```
- **MySQL 8.0+** (üretim dağıtımı için)
  ```bash
  mysql --version
  ```
- **Docker** (konteyner dağıtım için opsiyonel)
  ```bash
  docker --version
  ```

### Kurulum & Yapılandırma

#### 1. Repository'yi Klonlayın
```bash
git clone https://github.com/ensuca/ecommerce-platform.git
cd ecommerce-platform
```

#### 2. Veritabanı Yapılandırması

##### MySQL İçin (Üretim)
Bir MySQL veritabanı oluşturun:
```sql
CREATE DATABASE ecommerce_platform_db;
```

`src/main/resources/application.properties` dosyasını güncelleyin:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_platform_db
spring.datasource.username=MYSQL_KULLANICI_ADINIZ
spring.datasource.password=MYSQL_ŞIFRENIZ
spring.jpa.hibernate.ddl-auto=update
```

##### H2 İçin (Geliştirme/Test)
`application.properties` dosyasındaki H2 konfigürasyonunun yorumunu kaldırın:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

#### 3. Projeyi Build Edin
Maven Wrapper kullanarak (önerilen):
```bash
./mvnw clean install
```

Veya sistem Maven'ı kullanarak:
```bash
mvn clean install
```

Bu komut:
- Kaynak kodu derler
- Tüm birim ve entegrasyon testlerini çalıştırır
- Uygulamayı JAR dosyası olarak paketler
- Artifact'leri yerel Maven repository'nize kurar

#### 4. Uygulamayı Çalıştırın

Maven kullanarak:
```bash
./mvnw spring-boot:run
```

Veya JAR'ı doğrudan çalıştırın:
```bash
java -jar target/ecommerce-platform-0.0.1-SNAPSHOT.jar
```

Uygulama **http://localhost:8080** adresinde başlayacaktır

#### 5. Kurulumu Doğrulayın

Uygulama sağlığını kontrol edin:
```bash
curl http://localhost:8080/actuator/health
```

Beklenen yanıt:
```json
{"status":"UP"}
```

---

## 📡 API Dokümantasyonu

### Base URL
```
http://localhost:8080/api
```

### Kimlik Doğrulama
> **Not**: Spring Security yapılandırılmıştır. Üretim kullanımı için, mevcut güvenlik yapılandırmasını genişleterek JWT tabanlı kimlik doğrulama uygulayın.

---

### Kullanıcı Yönetim Endpoint'leri

| Metod | Endpoint | Açıklama | İstek Gövdesi | Yanıt |
|-------|----------|----------|---------------|-------|
| `GET` | `/users` | Tüm kullanıcıları getir | - | `200 OK` kullanıcı dizisi ile |
| `GET` | `/users/{id}` | ID'ye göre belirli kullanıcıyı getir | - | `200 OK` kullanıcı nesnesi ile<br>`404 Not Found` kullanıcı yoksa |
| `POST` | `/users` | Yeni kullanıcı oluştur | User JSON | `201 Created` oluşturulan kullanıcı ile |
| `PUT` | `/users/{id}` | Mevcut kullanıcıyı güncelle | User JSON | `200 OK` güncellenmiş kullanıcı ile |
| `DELETE` | `/users/{id}` | Kullanıcıyı sil | - | `204 No Content` |

**User Modeli:**
```json
{
  "id": 1,
  "username": "ahmet_yilmaz",
  "email": "ahmet@ornek.com",
  "password": "hashlenmiş_şifre"
}
```

---

### Ürün Yönetim Endpoint'leri

| Metod | Endpoint | Açıklama | İstek Gövdesi | Yanıt |
|-------|----------|----------|---------------|-------|
| `GET` | `/products` | Tüm ürünleri getir | - | `200 OK` ürün dizisi ile |
| `GET` | `/products/{id}` | Belirli ürünü getir | - | `200 OK` ürün nesnesi ile<br>`404 Not Found` yoksa |
| `POST` | `/products` | Yeni ürün ekle | Product JSON | `201 Created` oluşturulan ürün ile |
| `PUT` | `/products/{id}` | Ürün detaylarını güncelle | Product JSON | `200 OK` güncellenmiş ürün ile |
| `DELETE` | `/products/{id}` | Ürünü kaldır | - | `204 No Content` |

**Product Modeli:**
```json
{
  "id": 1,
  "name": "Premium Dizüstü Bilgisayar",
  "description": "16GB RAM ile yüksek performanslı dizüstü",
  "price": 1299.99,
  "quantity": 50
}
```

---

### Sipariş Yönetim Endpoint'leri

| Metod | Endpoint | Açıklama | İstek Gövdesi | Yanıt |
|-------|----------|----------|---------------|-------|
| `GET` | `/orders` | Tüm siparişleri getir | - | `200 OK` sipariş dizisi ile |
| `GET` | `/orders/{id}` | Belirli siparişi getir | - | `200 OK` sipariş nesnesi ile<br>`404 Not Found` yoksa |
| `POST` | `/orders` | Yeni sipariş oluştur | CreateOrderRequest JSON | `201 Created` oluşturulan sipariş ile |
| `PUT` | `/orders/{id}` | Sipariş durumunu/detaylarını güncelle | Order JSON | `200 OK` güncellenmiş sipariş ile |
| `DELETE` | `/orders/{id}` | Siparişi iptal et/sil | - | `204 No Content` |

**CreateOrderRequest Modeli:**
```json
{
  "order": {
    "userId": 1,
    "productId": 1,
    "quantity": 2,
    "orderDate": "2025-10-01T14:30:00",
    "status": "PENDING"
  },
  "orderItems": [
    {
      "productId": 1,
      "quantity": 2,
      "orderId": 1
    }
  ]
}
```

**Order Yanıt Modeli:**
```json
{
  "id": 1,
  "userId": 1,
  "productId": 1,
  "quantity": 2,
  "orderDate": "2025-10-01T14:30:00",
  "status": "PENDING",
  "orderItems": [
    {
      "id": 1,
      "orderId": 1,
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

---

### Sipariş Kalemi Yönetim Endpoint'leri

| Metod | Endpoint | Açıklama | İstek Gövdesi | Yanıt |
|-------|----------|----------|---------------|-------|
| `GET` | `/order-items` | Tüm sipariş kalemlerini getir | - | `200 OK` sipariş kalemi dizisi ile |
| `GET` | `/order-items/{id}` | Belirli sipariş kalemini getir | - | `200 OK` sipariş kalemi nesnesi ile |
| `POST` | `/order-items` | Siparişe kalem ekle | OrderItem JSON | `201 Created` |
| `PUT` | `/order-items/{id}` | Sipariş kalemini güncelle | OrderItem JSON | `200 OK` |
| `DELETE` | `/order-items/{id}` | Sipariş kalemini kaldır | - | `204 No Content` |

---

### Örnek API Kullanımı

#### Yeni Ürün Oluşturma
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Kablosuz Fare",
    "description": "USB alıcılı ergonomik kablosuz fare",
    "price": 29.99,
    "quantity": 100
  }'
```

#### Birden Fazla Kalemle Sipariş Oluşturma
```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "order": {
      "userId": 1,
      "productId": 1,
      "quantity": 3,
      "orderDate": "2025-10-01T10:00:00",
      "status": "PENDING"
    },
    "orderItems": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 2,
        "quantity": 1
      }
    ]
  }'
```

---

## 🧪 Test Stratejisi

Bu proje, birden fazla test seviyesinde kapsamlı kapsama ile **profesyonel test pratiklerini** gösterir.

### Test Mimarisi

- **Birim Testleri**: Mockito kullanarak bileşenleri izole şekilde test eder
- **Entegrasyon Testleri**: Spring Boot Test kullanarak katmanlar arası etkileşimleri doğrular
- **Repository Testleri**: `@DataJpaTest` kullanarak veri erişim mantığını doğrular

### Testleri Çalıştırma

Tüm testleri çalıştır:
```bash
./mvnw test
```

Kapsam raporu ile testleri çalıştır:
```bash
./mvnw test jacoco:report
```

Belirli test sınıfını çalıştır:
```bash
./mvnw test -Dtest=OrderServiceTest
```

### Test Kapsamı Öne Çıkanları

#### OrderServiceTest Örneği
Konumda: `src/test/java/com/enesuca/ecommerceplatform/order_/service/OrderServiceTest.java:1`

Ana test senaryoları:
- ✅ **Sipariş Oluşturma**: Sipariş kalemleri ile sipariş kalıcılığını doğrular
- ✅ **Sipariş Getirme**: ID'ye göre sipariş bulma ile uygun Optional işlemesi testleri
- ✅ **Sipariş Kalemi Ekleme**: Siparişler ve kalemler arasındaki ilişki yönetimini doğrular
- ✅ **Sınır Durumları**: Sipariş bulunamadı senaryoları ve null işlemesi testleri
- ✅ **Repository Etkileşimleri**: Uygun mock etkileşimlerini ve doğrulamayı onaylar

### Test Teknolojileri
- **JUnit 5**: Parametrik testler, iç içe testler ve yaşam döngüsü yönetimi
- **Mockito**: Davranış doğrulama, argüman yakalayıcılar ve spy işlevselliği
- **@DataJpaTest**: In-memory H2 veritabanı ile optimize edilmiş JPA testi
- **MockMvc**: İstek/yanıt doğrulaması ile controller katmanı testi

### Sürekli Test
GitHub Actions, kod kalitesini sağlamak ve gerilemeleri önlemek için her push ve pull request'te otomatik olarak tam test paketini çalıştırır.

---

## 🐳 Deployment (Dağıtım)

### Docker Dağıtımı

#### Docker İmajı Oluşturma
```bash
# İlk olarak, uygulamayı paketleyin
./mvnw clean package -DskipTests

# Docker imajı oluşturun
docker build -t ecommerce-platform:latest .
```

#### Docker ile Çalıştırma
```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/ecommerce_platform_db \
  -e SPRING_DATASOURCE_USERNAME=kullanici_adiniz \
  -e SPRING_DATASOURCE_PASSWORD=sifreniz \
  ecommerce-platform:latest
```

#### Docker Compose (MySQL ile)
`docker-compose.yml` oluşturun:
```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: rootpass
      MYSQL_DATABASE: ecommerce_platform_db
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql

  app:
    image: ecommerce-platform:latest
    depends_on:
      - mysql
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/ecommerce_platform_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: rootpass

volumes:
  mysql-data:
```

Şununla çalıştırın:
```bash
docker-compose up -d
```

---

### CI/CD Pipeline

Bu proje, şunları otomatikleştiren **üretime hazır bir GitHub Actions workflow'u** içerir (`.github/workflows/maven-publish.yml:1`):

1. **Build & Test**: Kodu derler ve test paketini çalıştırır
2. **Maven Paket Yayınlama**: Artifact'leri GitHub Packages'a yayınlar
3. **Docker İmaj Oluşturma**: Optimize edilmiş konteyner imajları oluşturur
4. **Container Registry Push**: SHA etiketleri ile GitHub Container Registry'ye yayınlar
5. **Artifact Arşivleme**: Sorun giderme için test raporlarını ve logları yükler

#### Workflow Tetikleyicileri
- GitHub UI üzerinden manuel tetikleme
- Otomatik tetikleyiciler için genişletilebilir (main'e push, pull request'ler, vb.)

#### Yayınlanan Paketleri Kullanma

Docker imajını çekin:
```bash
docker pull ghcr.io/ensuca/ecommerce-platform/ecommerce-platform:latest
```

---

### Ortam Yapılandırması

#### Gerekli Ortam Değişkenleri

| Değişken | Açıklama | Örnek |
|----------|----------|-------|
| `SPRING_DATASOURCE_URL` | Veritabanı bağlantı URL'si | `jdbc:mysql://localhost:3306/ecommerce_platform_db` |
| `SPRING_DATASOURCE_USERNAME` | Veritabanı kullanıcı adı | `ecommerce_user` |
| `SPRING_DATASOURCE_PASSWORD` | Veritabanı şifresi | `guvenli_sifre` |
| `SPRING_JPA_HIBERNATE_DDL_AUTO` | Hibernate şema oluşturma | `validate` (üretim), `update` (geliştirme) |
| `SERVER_PORT` | Uygulama portu | `8080` |

#### Üretim Dağıtım Kontrol Listesi
- [ ] Şema değişikliklerini önlemek için `spring.jpa.hibernate.ddl-auto=validate` ayarlayın
- [ ] Uygun veritabanı bağlantı havuzu yapılandırın
- [ ] HTTPS/TLS şifrelemeyi etkinleştirin
- [ ] API güvenliği için JWT kimlik doğrulama uygulayın
- [ ] Veritabanı yedekleme ve replikasyon kurun
- [ ] Harici toplama servisine loglama yapılandırın
- [ ] Güvenli endpoint'lerle Spring Boot Actuator'ı etkinleştirin
- [ ] İzleme ve uyarı kurun (Prometheus, Grafana, vb.)

---

## 📂 Proje Yapısı

```
ecommerce-platform/
├── .github/
│   └── workflows/
│       └── maven-publish.yml      # CI/CD pipeline yapılandırması
├── .mvn/                           # Maven wrapper yapılandırması
├── src/
│   ├── main/
│   │   ├── java/com/enesuca/ecommerceplatform/
│   │   │   ├── EcommercePlatformApplication.java  # Ana uygulama giriş noktası
│   │   │   ├── order_/
│   │   │   │   ├── controller/
│   │   │   │   │   ├── CreateOrderRequest.java    # Sipariş oluşturma için DTO
│   │   │   │   │   ├── OrderController.java       # Sipariş REST endpoint'leri
│   │   │   │   │   └── OrderItemController.java   # Sipariş kalemi endpoint'leri
│   │   │   │   ├── model/
│   │   │   │   │   ├── Order_.java                # İlişkilerle sipariş varlığı
│   │   │   │   │   └── OrderItem.java             # Sipariş kalemi varlığı
│   │   │   │   ├── repository/
│   │   │   │   │   ├── OrderRepository.java       # Sipariş veri erişimi
│   │   │   │   │   └── OrderItemRepository.java   # Sipariş kalemi veri erişimi
│   │   │   │   └── service/
│   │   │   │       ├── OrderService.java          # Sipariş iş mantığı
│   │   │   │       └── OrderItemService.java      # Sipariş kalemi iş mantığı
│   │   │   ├── product/
│   │   │   │   ├── controller/
│   │   │   │   │   └── ProductController.java     # Ürün REST endpoint'leri
│   │   │   │   ├── model/
│   │   │   │   │   └── Product.java               # Doğrulama ile ürün varlığı
│   │   │   │   ├── repository/
│   │   │   │   │   └── ProductRepository.java     # Ürün veri erişimi
│   │   │   │   └── service/
│   │   │   │       └── ProductService.java        # Ürün iş mantığı
│   │   │   └── user/
│   │   │       ├── controller/
│   │   │       │   └── UserController.java        # Kullanıcı REST endpoint'leri
│   │   │       ├── model/
│   │   │       │   └── User.java                  # Kullanıcı varlığı
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java        # Kullanıcı veri erişimi
│   │   │       └── service/
│   │   │           └── UserService.java           # Kullanıcı iş mantığı
│   │   └── resources/
│   │       └── application.properties              # Uygulama yapılandırması
│   └── test/
│       ├── java/com/enesuca/ecommerceplatform/
│       │   ├── EcommercePlatformApplicationTests.java  # Uygulama context testleri
│       │   └── order_/
│       │       ├── controller/
│       │       │   ├── OrderControllerTest.java        # Controller entegrasyon testleri
│       │       │   └── OrderItemControllerTest.java
│       │       └── service/
│       │           ├── OrderServiceTest.java           # Servis birim testleri
│       │           └── OrderItemServiceTest.java
│       └── resources/
│           └── application-test.properties         # Test'e özel yapılandırma
├── target/                         # Build çıktı dizini
├── Dockerfile                      # Konteyner imaj tanımı
├── pom.xml                        # Maven proje yapılandırması
├── mvnw / mvnw.cmd                # Maven wrapper scriptleri
└── README.md                      # Proje dokümantasyonu
```

### Ana Dizinler

- **`controller/`**: HTTP istek/yanıtlarını işleyen REST API endpoint'leri
- **`service/`**: Transaction yönetimi ile iş mantığı katmanı
- **`repository/`**: Veritabanı işlemleri için Spring Data JPA arayüzleri
- **`model/`**: Veritabanı tablolarını temsil eden JPA varlıkları
- **`test/`**: Birim ve entegrasyon testleri ile kapsamlı test paketi

---

## ⚡ Performans & Optimizasyon

### Veritabanı Optimizasyonları
- **Lazy Loading**: N+1 sorgu problemlerini önlemek için lazy fetching ile yapılandırılmış varlık ilişkileri
- **Connection Pooling**: Verimli veritabanı bağlantı yönetimi için HikariCP (Spring Boot varsayılanı)
- **Index Stratejisi**: Primary key'ler ve foreign key'ler JPA tarafından otomatik olarak indekslenir
- **Sorgu Optimizasyonu**: Spring Data JPA, metod adlarına dayalı optimize edilmiş sorgular üretir

### Uygulama Performansı
- **Actuator İzleme**: Performans takibi için yerleşik sağlık kontrolleri ve metrik endpoint'leri
- **Spring DevTools**: Geliştirme sırasında otomatik yeniden başlatma ve canlı yeniden yükleme
- **Jackson Optimizasyonu**: Özel tarih formatters ile verimli JSON serileştirme
- **Hibernate Second-Level Cache Hazır**: Mimari, sık erişilen veriler için caching katmanı eklemeyi destekler

### Ölçeklenebilirlik Değerlendirmeleri
- **Stateless Tasarım**: Controller'lar stateless, yatay ölçeklendirmeyi mümkün kılar
- **Veritabanı Migration Hazır**: JPA şema güncellemeleri üretim için Flyway/Liquibase ile değiştirilebilir
- **Konteynerizasyon**: Docker desteği Kubernetes veya bulut platformlarına dağıtımı sağlar
- **RESTful Mimari**: Gerektiğinde mikroservis ayrıştırmasını mümkün kılar

### Gelecekteki Performans İyileştirmeleri
- Sık erişilen ürünler için Redis caching uygulama
- Sorgu yükü dağıtımı için veritabanı read replica'ları ekleme
- Büyük sonuç setleri için pagination uygulama
- Esnek istemci veri getirme için GraphQL endpoint ekleme
- İzleme çözümleri entegre etme (Prometheus, Grafana, ELK stack)

---

## 🗺 Yol Haritası

### Kısa Vadeli Hedefler (Sonraki Sürüm)
- [ ] **JWT Kimlik Doğrulama Uygulaması**: Spring Security yapılandırmasını JWT token'ları ile tamamlama
- [ ] **Input Validation İyileştirmesi**: Kapsamlı Bean Validation anotasyonları ekleme (`@Valid`, `@NotNull`, vb.)
- [ ] **API Dokümantasyonu**: Etkileşimli API dokümantasyonu için Swagger/OpenAPI entegrasyonu
- [ ] **Pagination & Filtering**: Tüm GET endpoint'lerine pagination desteği ekleme
- [ ] **Exception Handling**: Anlamlı hata mesajları ile global exception handler uygulama

### Orta Vadeli Hedefler (v2.0)
- [ ] **Ödeme Gateway Entegrasyonu**: Sipariş ödemeleri için Stripe/PayPal entegrasyonu
- [ ] **Email Bildirimleri**: Sipariş onayı ve durum güncellemesi email'leri
- [ ] **Ürün Kategorileri**: Daha iyi ürün organizasyonu için kategori hiyerarşisi ekleme
- [ ] **Alışveriş Sepeti**: Oturum yönetimi ile sepet fonksiyonalitesi uygulama
- [ ] **Kullanıcı Rolleri & İzinleri**: Admin/müşteri rol tabanlı erişim kontrolü ekleme
- [ ] **Sipariş Geçmişi & Takip**: Durum zaman çizelgesi ile gelişmiş sipariş takibi

### Uzun Vadeli Vizyon (v3.0+)
- [ ] **Mikroservis Mimarisi**: Bağımsız servislere ayırma (User, Product, Order, Payment)
- [ ] **Event-Driven Mimari**: Asenkron iletişim için Apache Kafka uygulama
- [ ] **GraphQL API**: Esnek veri sorgulama için alternatif API endpoint'i
- [ ] **Full-Text Search**: Gelişmiş ürün araması için Elasticsearch entegrasyonu
- [ ] **Mobil Uygulama Desteği**: Push bildirimleri ile özel mobil API endpoint'leri
- [ ] **Analytics Dashboard**: Satış analitiği ve raporlama ile admin dashboard'u

### Bilinen Kısıtlamalar
- **Güvenlik**: Mevcut implementasyon temel Spring Security'ye sahip; JWT'nin tam olarak uygulanması gerekiyor
- **Ölçeklenebilirlik**: Tek veritabanı instance'ı; yüksek trafik için read replica'lar ve caching gerekli
- **Validation**: Sınırlı input validation; kapsamlı Bean Validation gerekli
- **Dokümantasyon**: API dokümantasyonu Swagger UI ile geliştirilebilir

---

## 📞 İletişim

**Enes Uca** - Full Stack Geliştirici

- 💼 **LinkedIn**: [linkedin.com/in/enes-uca-41039327b](https://www.linkedin.com/in/enes-uca-41039327b)
- 🐙 **GitHub**: [@ensuca](https://github.com/ensuca)
- 🌐 **Portfolio**: [ensuca.github.io/ensuca.githubio](https://ensuca.github.io/ensuca.githubio)
- 📧 **Email**: enesuca55@gmail.com

### Proje Linkleri
- **Repository**: [github.com/ensuca/ecommerce-platform](https://github.com/ensuca/ecommerce-platform)
- **Sorunlar & Hata Raporları**: [github.com/ensuca/ecommerce-platform/issues](https://github.com/ensuca/ecommerce-platform/issues)
- **Pull Request'ler**: Katkılar memnuniyetle karşılanır!

---

## 📄 Lisans

Bu proje, portföy gösterimi ve eğitim amaçlı kullanılabilir. Ticari kullanım için lütfen yazar ile iletişime geçin.

---

## 🙏 Teşekkürler

Endüstri lideri teknolojiler ile geliştirilmiştir:
- [Spring Framework](https://spring.io/) - Kapsamlı programlama ve yapılandırma modeli
- [Hibernate](https://hibernate.org/) - Nesne-ilişkisel eşleme framework'ü
- [MySQL](https://www.mysql.com/) - Güvenilir, ölçeklenebilir veritabanı yönetim sistemi
- [Docker](https://www.docker.com/) - Konteynerizasyon platformu

---

<div align="center">

**⭐ Bu projeyi etkileyici buluyorsanız, lütfen GitHub'da yıldızlamayı düşünün! ⭐**

*Temiz kod ve en iyi pratikler tutkusuyla geliştirilmiştir*

</div>
