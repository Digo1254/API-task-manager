# Task Manager API

REST API for task management with JWT authentication, built with Spring Boot and PostgreSQL.

## Technologies
- Java 21
- Spring Boot 4
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Swagger/OpenAPI

## Features
- User registration and login with JWT authentication
- Create, read, update and delete tasks
- Filter tasks by status
- Each user can only see their own tasks
- Error handling with proper HTTP status codes
- API documentation with Swagger

## How to run

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Setup
1. Clone the repository
2. Create a PostgreSQL database named `taskdb`
3. Copy `application.properties.example` to `application.properties` and fill in your credentials
4. Run the project: mvn spring-boot:run

## API Documentation
Access Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Login and get JWT token |

### Tasks
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /tasks | List all user tasks |
| GET | /tasks/{id} | Get task by id |
| POST | /tasks | Create a new task |
| PUT | /tasks/{id} | Update a task |
| DELETE | /tasks/{id} | Delete a task |
| PATCH | /tasks/{id}/complete | Mark task as complete |