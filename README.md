# Hotel Management System – REST API Documentation

This is a **Spring Boot backend-only Hotel Management System** that provides REST APIs to manage **Rooms** and **Bookings**.

Base URL (example):

```
http://localhost:8080
```

---

## 📦 Modules

* Room Management
* Booking Management

---

## 🏨 Room APIs

### 1️⃣ Get All Rooms

**Endpoint**

```
GET /api/rooms
```

**Description**: Fetches all rooms.

**Response**

```json
[
  {
    "id": 1,
    "roomNumber": "101",
    "type": "DELUXE",
    "price": 2500,
    "available": true
  }
]
```

---

### 2️⃣ Get Available Rooms

**Endpoint**

```
GET /api/rooms/available
```

**Description**: Returns only available rooms.

---

### 3️⃣ Get Room by ID

**Endpoint**

```
GET /api/rooms/{id}
```

**Path Variable**

* `id` → Room ID

---

### 4️⃣ Add a New Room

**Endpoint**

```
POST /api/rooms
```

**Request Body**

```json
{
  "roomNumber": "102",
  "type": "STANDARD",
  "price": 1800,
  "available": true
}
```

---

### 5️⃣ Update Room

**Endpoint**

```
PUT /api/rooms/{id}
```

**Request Body**

```json
{
  "roomNumber": "102",
  "type": "PREMIUM",
  "price": 3000,
  "available": false
}
```

---

### 6️⃣ Delete Room

**Endpoint**

```
DELETE /api/rooms/{id}
```

**Response**

```
Room deleted successfully
```

---

## 📅 Booking APIs

### 1️⃣ Get All Bookings

**Endpoint**

```
GET /api/bookings
```

---

### 2️⃣ Book a Room

**Endpoint**

```
POST /api/bookings/room/{roomId}
```

**Path Variable**

* `roomId` → Room ID

**Request Body**

```json
{
  "customerName": "John Doe",
  "checkInDate": "2026-02-01",
  "checkOutDate": "2026-02-05"
}
```

**Description**: Creates a booking for the specified room.

---

### 3️⃣ Update Booking

**Endpoint**

```
PUT /api/bookings/booking/{bookingId}
```

**Request Body**

```json
{
  "customerName": "John Smith",
  "checkInDate": "2026-02-02",
  "checkOutDate": "2026-02-06"
}
```

---

### 4️⃣ Delete Booking

**Endpoint**

```
DELETE /api/bookings/booking/{bookingId}
```

**Response**

```
Booking deleted successfully
```

---

## ⚙️ Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL

---

## ▶️ Running the Project

1. Clone the repository
2. Configure `application.properties`
3. Run the application

```bash
mvn spring-boot:run
```

---

## 📌 Notes

* This is a **backend-only** project
* Suitable for **beginners learning Spring Boot REST APIs**
* Can be extended with authentication, payments, and frontend integration

---

✅ **Author**: w w
