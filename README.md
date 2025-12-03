🎯 **Quiz Application — Full-Stack Project**
(Spring Boot + React + Vite + Axios + MySQL)

A complete full-stack Quiz Application where users can load quizzes, view MCQ questions, select answers, and submit responses to get the score — built using modern Java backend + modern React frontend.

🚀 **Live Tech Stack Overview**

Layer	Technology

Frontend	React.js (Vite), Axios, JavaScript ES6

Backend	Spring Boot 4, Spring Web MVC, Spring Data JPA

Database	MySQL

Build Tools	Maven, npm

Other Tools	Lombok, REST APIs

📌 **Features**

✔ Load quiz dynamically by ID

✔ Display multiple-choice questions

✔ Submit answers & calculate score

✔ REST API integration

✔ Fully modular backend + frontend

✔ Clean code structure

✔ Easy to deploy anywhere

📁 **Project Structure**

```
quiz-project/
│
├── quiz-backend/            # Spring Boot API
│   ├── src/main/java        # Controllers, Services, Models
│   ├── src/main/resources   # application.properties
│   └── pom.xml
│
└── quiz-frontend/           # React + Vite frontend
    ├── src/                 # Components/UI
    ├── public/
    └── package.json
```

🏗 **Architecture Diagram**
```
           ┌────────────────────┐
           │    React Frontend  │
           │  (Vite + Axios)    │
           └─────────▲──────────┘
                     │ API Calls
                     │
           ┌─────────▼──────────┐
           │   Spring Boot       │
           │   REST Backend      │
           └─────────▲──────────┘
                     │ JPA
                     │
           ┌─────────▼──────────┐
           │      MySQL DB       │
           └─────────────────────┘
```

⚙️ **Backend Setup (Spring Boot)**

📌 application.properties

spring.application.name=quizapp

server.port=4242

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/questiondb

spring.datasource.username=root

spring.datasource.password=Admin@123

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

🛢 **MySQL Database Setup**

Create database:

CREATE DATABASE questiondb;

Insert or import quiz questions.

🔥 **Running the Backend**

cd quiz-backend

mvn spring-boot:run


**Backend runs on:**

👉 http://localhost:4242

🌐 **Frontend Setup (React + Vite)**

API Call Inside App.jsx:

axios.get(`http://localhost:4242/quiz/get/${quizId}`)

**Run frontend:**

cd quiz-frontend

npm install

npm run dev

**Frontend runs on:**

👉 http://localhost:5173

📡 **API Endpoints**

Method	Endpoint	Description

POST	/quiz/create?category=a&numQ=b&title=c	Create quiz from DB questions

GET	/quiz/get/{id}	Fetch quiz questions

POST	/quiz/submit/{id}	Submit answers & compute score

🧪 **Sample API Usage**

Create Quiz

POST http://localhost:4242/quiz/create?category=java&numQ=5&title=JavaBasics

Get Quiz

GET http://localhost:4242/quiz/get/1

Submit Quiz
```
[
  { "id": 1, "response": "true" },
  { "id": 2, "response": "ArithmeticException" }
]
```

📦 **Build Commands**

Backend Build

mvn clean package

Frontend Build

npm run build

👨‍💻 **Author**
```
Krantikumar Dilip Patil
Java Full Stack Developer
Artificial Intelligence & Data Science Engineer
GitHub: https://github.com/Krantikumar4211
```
