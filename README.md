### ENGLİSH

# E-commerce Platform

## Overview
This project is an e-commerce platform backend application built using **Spring Boot** and **MySQL**. It is designed to handle basic e-commerce operations such as managing users, products, orders, and payments. The project follows a microservice architecture with separate services for user management, product management, and order management.

---

## Table of Contents
1. [Features](#features)
2. [Technologies](#technologies)
3. [Architecture](#architecture)
4. [Installation](#installation)
5. [Usage](#usage)
6. [API Endpoints](#api-endpoints)
7. [Tests](#tests)
8. [License](#license)

---

## Features

- User management (CRUD operations)
- Product management (CRUD operations)
- Order management (Create, Read, Update, Delete Orders)
- Order item management
- JWT-based authentication
- RESTful API
- Unit and Integration tests
- CI/CD pipeline with GitHub Actions
- Database integration with MySQL
- Data validation and error handling

---

## Technologies

- **Java 17**
- **Spring Boot 3.3.3**
  - Spring Boot Starter Actuator
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Web
  - Spring Boot Starter Security
- **MySQL 8.0**
- **Hibernate** (ORM)
- **Maven** (Dependency Management)
- **JUnit** (Testing Framework)
- **MockMvc** (Testing)
- **Lombok** (Boilerplate code reduction)
- **GitHub Actions** (CI/CD)
- **Docker** (Optional: Containerization)

---

## Architecture

The e-commerce platform follows a **multi-layered architecture** with the following layers:
1. **Model Layer:** Contains entity classes that map to database tables.
2. **Repository Layer:** Interfaces for database operations, using Spring Data JPA.
3. **Service Layer:** Contains the business logic of the application.
4. **Controller Layer:** Handles HTTP requests and responses, using REST API.
5. **DTOs:** Data Transfer Objects used to pass data between layers.
6. **Security Layer:** Manages authentication and authorization using JWT.

---

## Installation

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- MySQL 8.0+

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/ensuca/ecommerce-platform.git
   cd ecommerce-platform
   ```
   
2. **Configure MySQL**
   -Create a MySQL database for the project
   ```SQL
   CREATE DATABASE ecommerce_db;
   
  -Update your MySQL credentials in the application.properties:
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>
  ```

3.**Build the project**

  ```bash
  mvn clean install
  ```
4.**Run the Application**

  ```bash
  mvn spring-boot:run
  ```

### Usage 

  - Once the application is running, you can interact with the API endpoints via Postman or any HTTP client.
  - After starting the application: The API will be available at: http://localhost:8080
    
### API Endpoints
- User Endpoints:
  - `GET /users` – Get all users
  - `GET /users/{id}` – Get a specific user
  - `POST /users` – Create a new user
  - `PUT /users/{id}` – Update user details
  - `DELETE /users/{id}` – Delete a user
- Product Endpoints:
  - `GET /products` – Get all products
  - `GET /products/{id}` – Get a specific product
  - `POST /products` – Create a new product
  - `PUT /products/{id` – Update product details
  - `DELETE /products/{id` – Delete a product
- Order Endpoints:
  - `GET /orders` – Get all orders
  - `GET /orders/{id}` – Get a specific order
  - `POST /orders` – Create a new order
  - `PUT /orders/{id}` – Update order details
  - `DELETE /orders/{id}` – Delete an order

### Tests
- Unit and integration tests are included in the project.
- To run the tests, execute the following Maven command:
  ```bash
  mvn test
  ```
- The tests use JUnit 5 and MockMvc to test the API and services.



### TÜRKÇE


# E-ticaret Platformu

## Genel Bakış
Bu proje, **Spring Boot** ve **MySQL** kullanılarak oluşturulmuş bir e-ticaret platformu arka uç uygulamasıdır. Kullanıcı, ürün ve sipariş yönetimi gibi temel e-ticaret işlemlerini gerçekleştirmek için tasarlanmıştır. Proje, kullanıcı yönetimi, ürün yönetimi ve sipariş yönetimi için ayrı mikroservis mimarisi kullanır.

---

## İçindekiler
1. [Özellikler](#özellikler)
2. [Teknolojiler](#teknolojiler)
3. [Mimari](#mimari)
4. [Kurulum](#kurulum)
5. [Kullanım](#kullanım)
6. [API Uç Noktaları](#api-uç-noktaları)
7. [Testler](#testler)
8. [Lisans](#lisans)

---

## Özellikler

- Kullanıcı yönetimi (CRUD işlemleri)
- Ürün yönetimi (CRUD işlemleri)
- Sipariş yönetimi (Oluşturma, Okuma, Güncelleme, Silme)
- Sipariş öğesi yönetimi
- JWT tabanlı kimlik doğrulama
- RESTful API
- Birim ve Entegrasyon testleri
- CI/CD pipeline ile GitHub Actions
- MySQL ile veri tabanı entegrasyonu
- Veri doğrulama ve hata yönetimi

---

## Teknolojiler

- **Java 17**
- **Spring Boot 3.3.3**
  - Spring Boot Starter Actuator
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Web
  - Spring Boot Starter Security
- **MySQL 8.0**
- **Hibernate** (ORM)
- **Maven** (Bağımlılık Yönetimi)
- **JUnit** (Test Framework)
- **MockMvc** (Test Aracı)
- **Lombok** (Kod sadeleştirme)
- **GitHub Actions** (CI/CD)
- **Docker** (Opsiyonel: Konteynerizasyon)

---

## Mimari

E-ticaret platformu, aşağıdaki katmanları içeren **çok katmanlı bir mimari** izler:
1. **Model Katmanı:** Veri tabanı tablolarına eşlenen varlık sınıfları içerir.
2. **Repository Katmanı:** Veri tabanı işlemleri için Spring Data JPA arayüzlerini içerir.
3. **Servis Katmanı:** Uygulamanın iş mantığını içerir.
4. **Controller Katmanı:** HTTP istek ve yanıtlarını işler, REST API kullanır.
5. **DTO’lar:** Katmanlar arasında veri taşımak için kullanılan Data Transfer Object'ler.
6. **Güvenlik Katmanı:** JWT ile kimlik doğrulama ve yetkilendirme yönetimi sağlar.

---

## Kurulum

### Gereksinimler
- Java 11 veya üzeri
- Maven 3.6+
- MySQL 8.0+

### Adımlar

1. **Depoyu Klonlayın**
   ```bash
   git clone https://github.com/ensuca/ecommerce-platform.git
   cd ecommerce-platform
   ```
2. **MySQL Yapılandırması**
   - Proje için bir MySQL veri tabanı oluşturun:
   ```sql
   CREATE DATABASE ecommerce_db;
   ```
    - MySQL kimlik bilgilerinizi application.properties dosyasında güncelleyin:
    
    ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
   spring.datasource.username=<kullanıcı-adınız>
   spring.datasource.password=<şifreniz>
    ```
3. **Projeyi Derleyin**
    ```bash
   mvn clean install
    ```
4. **Uygulamyı Başlatın**
    ```bash
   mvn spring-boot:run
    ```

### Kullanım
- Uygulama başlatıldığında, API uç noktalarına Postman veya herhangi bir HTTP istemcisi aracılığıyla erişebilirsiniz.
- Uygulamayı başlattıktan sonra API şu adreste erişilebilir olacaktır: http://localhost:8080

### API Uç Noktaları 
  - Kullanıcı Uç Noktaları:
      - `GET /users` – Tüm kullanıcıları getir
      - `GET /users/{id}` – Belirli bir kullanıcıyı getir
      - `POST /users` – Yeni kullanıcı oluştur
      - `PUT /users/{id}` – Kullanıcı bilgilerini güncelle
      - `DELETE /users/{id}` – Kullanıcıyı sil
  - Ürün Uç Noktaları:
      - `GET /products` – Tüm ürünleri getir
      - `GET /products/{id}` – Belirli bir ürünü getir
      - `POST /products` – Yeni bir ürün oluştur
      - `PUT /products/{id}` – Ürün bilgilerini güncelle
      - `DELETE /products/{id}` – Ürünü sil
  - Sipariş Uç Noktaları:
      - `GET /orders` – Tüm siparişleri getir
      - `GET /orders/{id}` – Belirli bir siparişi getir
      - `POST /orders` – Yeni bir sipariş oluştur
      - `PUT /orders/{id}` – Sipariş bilgilerini güncelle
      - `DELETE /orders/{id}` – Siparişi sil
## Testler

- Proje içerisinde birim ve entegrasyon testleri bulunmaktadır.

### Testleri Çalıştırma
Testleri çalıştırmak için aşağıdaki Maven komutunu kullanın:
  ```bash
  mvn test
  ```
