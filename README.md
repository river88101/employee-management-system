# Employee Management System

## Project Description
A full-stack Employee Management System with a Java Spring Boot backend and a React frontend. The system allows you to add, view (with location filtering), and remove employees. It demonstrates a microservice architecture with RESTful APIs and modern frontend state management.

## Features
- Add new employees (first name, last name, employee ID, location)
- Display employees filtered by location
- Remove employees from the system

## Tech Stack
- **Backend:** Java, Spring Boot, Spring JDBC Template, Spring REST, SQL
- **Frontend:** React, Redux, Redux-Saga, JavaScript
- **Testing:** JUnit5, Mockito, TestRestTemplate (backend); Jest, React Testing Library (frontend)

## Setup Instructions

### Backend
1. Clone the repository:
   ```bash
   git clone https://github.com/river88101/employee-management-system.git
   cd employee-management-system
   ```
2. Build and run the backend:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```
   The backend will start on `http://localhost:8080`.

3. H2 Database Console (for development):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:employeedb`
   - Username: `sa` (no password)

### Frontend
1. Create the React app (if not already present):
   ```bash
   npx create-react-app employee-management-ui
   cd employee-management-ui
   npm install @reduxjs/toolkit react-redux redux-saga axios
   ```
2. Start the frontend:
   ```bash
   npm start
   ```
   The frontend will start on `http://localhost:3000`.

## How to Run Tests

### Backend
```bash
./mvnw test
```

### Frontend
```bash
npm test
```

## API Endpoints (Backend)
- `POST   /api/employees` — Add a new employee
- `GET    /api/employees?location={location}` — Get employees filtered by location
- `GET    /api/employees` — Get all employees
- `DELETE /api/employees/{employeeId}` — Remove an employee by employee ID

## Usage Examples

### Add Employee (POST)
```
POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "employeeId": "E002",
  "firstName": "Jane",
  "lastName": "Smith",
  "location": "San Francisco"
}
```

### Get Employees by Location (GET)
```
GET http://localhost:8080/api/employees?location=New%20York
```

### Get All Employees (GET)
```
GET http://localhost:8080/api/employees
```

### Remove Employee (DELETE)
```
DELETE http://localhost:8080/api/employees/E002
```

## Other Notes
- Environment variables for the backend can be set in `src/main/resources/application.properties`.
- The backend uses an in-memory H2 database by default for development. For production, update the datasource settings.
- Make sure the backend is running before using the frontend.
- For deployment, configure environment variables and database settings as needed.


