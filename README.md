# Theatre Management System

A backend application built using Spring Boot to manage movie theatres, including show scheduling, seat allocation, and booking operations. The system provides RESTful APIs for efficient theatre management and booking workflows.

---

## 🚀 Features

* Add and manage movies
* Schedule shows for different theatres
* Manage seat allocation and booking
* RESTful APIs for all operations
* Efficient database interaction using JPA

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* REST APIs

---

## 📂 Project Structure

* `controller/` – Handles API requests
* `service/` – Business logic implementation
* `repository/` – Database interaction using JPA
* `model/` – Entity classes
* `application.properties` – Configuration file

---

## ⚙️ How It Works

* Users can add movies and assign show timings
* APIs handle booking and seat allocation logic
* Spring Data JPA manages database operations
* Ensures efficient handling of theatre data

---

## 🔗 API Endpoints (Sample)

* `POST /movies` → Add a new movie
* `GET /movies` → Fetch all movies
* `POST /shows` → Create show schedule
* `POST /bookings` → Book tickets

---

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/theatre-management-system.git
```

### 2. Navigate to project folder

```bash
cd theatre-management-system
```

### 3. Configure database

* Update `application.properties` with your MySQL credentials

### 4. Run the application

```bash
mvn spring-boot:run
```

---

## 🗄️ Database

* MySQL database used for storing:

  * Movies
  * Shows
  * Bookings
  * Seat details

---

## 📌 Future Improvements

* Add frontend (React) for user interface
* Implement authentication and authorization
* Enhance booking system with payment integration

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork and improve the project.

---

## 📧 Contact

For any queries or suggestions, feel free to reach out.
