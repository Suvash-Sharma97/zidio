Submission for Zidio Learning Platform
Author: Suvash Sharma Subedi
Title: Full Stack Java Web Developer Intern
---

## 🚀 Tech Stack Overview

| Layer     | Technology                 |
|-----------|----------------------------|
| Frontend  | HTML, CSS, JavaScript      |
| Backend   | Spring Boot, JPA           |
| Database  | MySQL                      |

---

## 🧑‍💻 Frontend: ZIDIOConnect Interface

### ✨ Highlights

- Interactive login page with input validation  
- Editable profile section to manage name, contact, bio, and upload resume  
- Clean and responsive user interface  
- Simple section transitions powered by vanilla JavaScript  

### 🛠 Setup Instructions

1. Launch `index.html` in your web browser.  
2. Make sure the backend server is up and running at `http://localhost:8080`.  
3. Modify `script.js` to send POST and PUT requests to `/api/students/login` and `/api/students/{id}` accordingly.  

---

## 🔒 Backend: REST API with Spring Boot

### 📁 Directory

Located in: `/Zidio_backend`

### 📦 Components

- **StudentController** – Handles login, registration, and profile updates  
- **StudentService** – Manages the main logic and operations  
- **StudentRepository** – Interfaces with the database using JPA  
- **Student** – Entity class representing student data  
- **JWT Security** – Implements authentication using JSON Web Tokens  

### 🔐 API Overview

| Method | Endpoint                  | Purpose              |
|--------|---------------------------|----------------------|
| POST   | `/api/students/login`     | Authenticate student |
| POST   | `/api/students/register`  | Register a new user  |
| PUT    | `/api/students/{id}`      | Edit student profile |

### 🛠 Getting Started

1. Ensure you have **Java 17+** and **Maven** installed.  
2. Open a terminal and navigate to the backend folder:

   ```bash
   cd Zidio_backend

   mvn clean install
   mvn spring-boot:run
