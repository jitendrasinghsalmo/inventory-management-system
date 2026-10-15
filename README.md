<div align="center">

# 📦 Inventory Management System
### Spring Boot REST API for Products, Orders and Stock Control

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Hibernate-6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)

[✨ Features](#-key-features) • [🛠️ Tech Stack](#️-tech-stack) • [🔗 API Endpoints](#-api-endpoints) • [🚀 Getting Started](#-getting-started)

</div>

---

## 📑 Table of Contents

- [About](#-about)
- [Key Features](#-key-features)
- [Tech Stack](#️-tech-stack)
- [Architecture](#-architecture)
- [Database Design](#-database-design)
- [Project Structure](#-project-structure)
- [API Endpoints](#-api-endpoints)
- [Sample Requests](#-sample-requests)
- [Getting Started](#-getting-started)
- [Future Scope](#-future-scope)
- [Author](#-author)

---

## 📌 About

A **backend-only** REST API built with Spring Boot to manage products and customer orders. When an order is placed, the available stock is checked and reduced automatically. If the stock is not enough, the API returns a clear error message.

---

## ✨ Key Features

- ➕ Add new products (name, price, quantity)
- 📋 Fetch all products
- 🔍 Search a product by name
- ✏️ Update a product
- 🛒 Place an order for a product with a quantity
- 📉 **Automatic stock reduction** after every order
- ⚠️ **Insufficient stock check** with a custom exception
- 🧯 **Global exception handling** using `@RestControllerAdvice`
- 🔗 Order and OrderItem relationship (One-to-Many / Many-to-One)

---

## 🛠️ Tech Stack

| Layer | Technologies |
|---|---|
| **Language** | Java 17 |
| **Framework** | Spring Boot, Spring MVC (REST) |
| **Persistence** | Spring Data JPA, Hibernate |
| **Database** | PostgreSQL |
| **Build Tool** | Maven (Maven Wrapper included) |
| **Dev Tools** | Spring Boot DevTools |
| **IDE** | Eclipse / Spring Tool Suite |

---

## 🏗️ Architecture

```text
Client (Postman)
      ➔  Controller   (REST endpoints)
      ➔  Service      (business logic, stock check)
      ➔  Repository   (Spring Data JPA)
      ➔  PostgreSQL
```

---

## 🗄️ Database Design

Tables are created automatically by Hibernate (`ddl-auto=update`).

| Table | Columns |
|---|---|
| `product` | id, name, price, qty |
| `orders` | id, orderdate |
| `order_item` | id, qty, product_id (FK), orders_id (FK) |

**Relationships**
- One `Orders` has many `OrderItem`
- Many `OrderItem` belong to one `Product`

---

## 📁 Project Structure

```text
Inventory_Management_System/
├── src/main/java/Springboot_2_Project/
│   ├── Springboot2ProjectApplication.java   # Main class
│   ├── Controller/
│   │   ├── ProductController.java
│   │   └── OrdersController.java
│   ├── Service/
│   │   ├── ProductService.java
│   │   ├── ProductServiceImp.java
│   │   ├── OrderService.java
│   │   └── OrderServiceImp.java
│   ├── Repository/
│   │   ├── ProductRepository.java
│   │   └── OrderRepository.java
│   ├── Entity/
│   │   ├── Product.java
│   │   ├── Orders.java
│   │   └── OrderItem.java
│   └── ExceptionHandling/
│       ├── ExceptionHandle.java             # Global handler
│       └── InsufficientStockException.java
├── src/main/resources/application.properties
├── src/test/java/...                        # Basic context test
└── pom.xml
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/saved` | Add a new product (JSON body) |
| `GET` | `/fetch` | Get all products |
| `GET` | `/findbyname?name=Vivo` | Find a product by name |
| `PUT` | `/update?id=1` | Update a product by id (demo: sets name to `Vivo`) |
| `POST` | `/orderd/{id}?qty=2` | Place an order for product `id` with quantity `qty` |

---

## 🧪 Sample Requests

### ➕ Add Product

`POST http://localhost:8080/saved`

```json
{
  "name": "Laptop",
  "price": 55000.0,
  "qty": 10
}
```

### 📋 Get All Products

`GET http://localhost:8080/fetch`

### 🔍 Find by Name

`GET http://localhost:8080/findbyname?name=Laptop`

### 🛒 Place Order

`POST http://localhost:8080/orderd/1?qty=2`

**Success:** returns the saved order with its order item and the product, and the product stock is reduced by `2`.

**Error examples (plain text):**

```text
product is not available
InsufficientStock only 3 items available
```

---

## 🚀 Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.8+ (or use the included `mvnw`)
- PostgreSQL
- Postman (to test the APIs)

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/jitendrasinghsalmo/inventory-management-system.git
cd inventory-management-system
```

**2. Create the database**

```sql
CREATE DATABASE inventory_db;
```

**3. Configure properties**

Open `src/main/resources/application.properties` and set your own values:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory_db
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

> **Note:** Never push real passwords to GitHub.

**4. Run the application**

```bash
mvn spring-boot:run
```

On Windows you can also use:

```bash
mvnw.cmd spring-boot:run
```

**5. Test with Postman**

```text
http://localhost:8080
```

---

## 🧭 Future Scope

- Make `PUT /update` accept a request body (update name, price, qty)
- Add `@Transactional` to order placement for safe rollback
- Add DELETE product and order history APIs
- Add input validation (`@Valid`) and proper HTTP status codes
- Add Spring Security with JWT authentication
- Add Swagger / OpenAPI documentation
- Add unit tests for the service layer

---

## 👨‍💻 Author

**Jitendra Singh**
Java Full Stack Developer | Bengaluru, India

- GitHub: [jitendrasinghsalmo](https://github.com/jitendrasinghsalmo)
- LinkedIn: [Jitendra Singh](https://www.linkedin.com/in/jitendra-singh-725698290)

---

<div align="center">

⭐ If you like this project, please give it a star on GitHub!

</div>