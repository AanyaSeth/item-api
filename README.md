# Item API – Java Spring Boot Application

## Overview

This project is a simple Java Spring Boot backend application that provides a RESTful API and a basic web interface to manage a collection of items.

Users can:

* Add new items
* View all items
* Retrieve a single item by ID
* Interact through a simple browser UI (no JSON required)

The application uses an in-memory data store (ArrayList) and does not require any external database.

---

## Technologies Used

* Java 17
* Spring Boot 3
* Spring MVC
* Thymeleaf (for UI)
* Maven

---

## How to Run Locally

### 1. Clone the repository

```
git clone https://github.com/AanyaSeth/item-api.git
cd item-api
```

### 2. Build the project

```
mvn clean package
```

(or build using IntelliJ)

### 3. Run the application

```
java -jar target/item-api-1.0.0.jar
```

### 4. Open in browser

```
http://localhost:8080
```

---

## API Endpoints

### 1. Add Item

**POST /add**

Adds a new item with validation.

Fields:

* name (required)
* description (required)
* price (> 0)

---

### 2. Get Item by ID

**GET /api/items/{id}**

Returns an item by its ID.

Example:

```
GET /api/items/1
```

---

### 3. View Items (UI)

**GET /**

Displays all items and a form to add new items via browser.

---

## Implementation Details

* Items are stored in memory using an ArrayList
* IDs are auto-generated
* Input validation prevents empty or invalid values
* MVC architecture separates controller, service, and model layers
* Thymeleaf provides an interactive UI

---

## Live Demo

Hosted on Render:

👉   https://item-api-wgtd.onrender.com

---

## Author

Aanya Seth
