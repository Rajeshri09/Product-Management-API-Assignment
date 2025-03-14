# Product-Management-API-Assignment


## Overview
This project is a RESTful API built with **Spring Boot** and **MongoDB** for managing products. It allows users to perform **CRUD (Create, Read, Update, Delete)** operations on product data.

## Features
- Create new products
- Retrieve all products
- Get product details by ID
- Update existing products
- Delete products from the database
- Data persistence using **MongoDB**

## Technologies Used
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB** (Local or Cloud)
- **Postman** (for API testing)
- **Maven** (for dependency management)

## Setup Instructions

### 1. Clone the Repository
```sh
git clone <your-repository-url>
cd product-management-api
```

### 2. Configure MongoDB
Make sure MongoDB is installed and running. Update `application.properties` or `application.yml` if necessary.

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/productsdb
```

### 3. Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### 1. Create a Product
**Endpoint:** `POST /api/products`
**Request Body:**
```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse with USB receiver",
  "price": 29.99,
  "quantity": 100,
  "category": "Electronics"
}
```
**Response:** Returns the created product with a unique ID.

### 2. Get All Products
**Endpoint:** `GET /api/products`
**Response:** Returns a list of all products.

### 3. Get Product by ID
**Endpoint:** `GET /api/products/{id}`
**Response:** Returns a single product based on the ID.

### 4. Update a Product
**Endpoint:** `PUT /api/products/{id}`
**Request Body:** (Update only the required fields)
```json
{
  "price": 24.99,
  "quantity": 150
}
```
**Response:** Returns the updated product.

### 5. Delete a Product
**Endpoint:** `DELETE /api/products/{id}`
**Response:** Returns a confirmation message upon successful deletion.

## Testing with Postman
1. Open **Postman**.
2. Send a **POST request** to `/api/products` to create a product.
3. Use **GET requests** to fetch all products or a specific product by ID.
4. Use **PUT request** to update product details.
5. Use **DELETE request** to remove a product.

## Database Verification
- Use **MongoDB Compass** or **Mongo Shell** to check stored data.
- Run `db.products.find()` to list all stored products.

## Project Structure
```
├── src/main/java/com/example/productapi
│   ├── controller (Handles API requests)
│   ├── model (Product entity)
│   ├── repository (MongoDB interactions)
│   ├── service (Business logic)
│   └── main (Application entry point)
├── src/main/resources
│   ├── application.properties
├── pom.xml (Maven dependencies)
├── README.md
```


