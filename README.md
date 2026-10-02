# E-Commerce Microservices

A backend e-commerce system built using Spring Boot and a microservices architecture. 
The application separates customer, product, and order management into independent services 
and uses Netflix Eureka for service discovery.

## Architecture

The project consists of four Spring Boot applications:

- **Eureka Server** – Service registry and discovery
- **Customer Service** – Customer management
- **Product Service** – Product management
- **Order Service** – Order creation and retrieval with customer and product details

### Service Ports

| Service | Port | Purpose |
|---|---:|---|
| Eureka Server | 8761 | Service discovery |
| Customer Service | 8081 | Customer CRUD operations |
| Product Service | 8082 | Product CRUD operations |
| Order Service | 8083 | Order management |

## Tech Stack

- Java
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Data JPA
- Hibernate
- REST APIs
- MySQL
- Maven
- Postman

## Features

### Customer Service

Provides REST APIs for:

- Add customer
- Get all customers
- Get customer by ID
- Update customer
- Delete customer

Base URL:

`/api/v1/customers`

### Product Service

Provides REST APIs for:

- Add product
- Get all products
- Get product by ID
- Update product
- Delete product

Base URL:

`/api/v1/products`

### Order Service

Provides REST APIs for:

- Create an order
- Get an order by order number
- Get orders for a customer

Base URL:

`/api/v1/orders`

When an order is created, the Order Service retrieves the corresponding
customer and product information from their respective services and
returns a combined order response.

## Microservices Architecture

```text
                         ┌─────────────────────┐
                         │    Eureka Server    │
                         │      Port 8761      │
                         └──────────┬──────────┘
                                    │
                 ┌──────────────────┼──────────────────┐
                 │                  │                  │
                 ▼                  ▼                  ▼
        ┌────────────────┐ ┌────────────────┐ ┌────────────────┐
        │ Customer       │ │ Product        │ │ Order          │
        │ Service        │ │ Service        │ │ Service        │
        │ Port 8081      │ │ Port 8082      │ │ Port 8083      │
        └───────┬────────┘ └───────┬────────┘ └───────┬────────┘
                │                  │                  │
                ▼                  ▼                  ▼
           MySQL DB           MySQL DB           MySQL DB
                                                   │
                                                   │
                         ┌─────────────────────────┘
                         │
                         ▼
                  Customer Service
                  Product Service
