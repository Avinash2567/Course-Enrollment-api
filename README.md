# Course Enrollment API

A RESTful backend application built with Java and Spring Boot to manage student course enrollments and track enrollment statuses. The application provides validated API endpoints, structured exception handling, database integration, and interactive API documentation through Swagger UI.

## Features

- Create and update student course enrollment records.
- Track enrollment statuses: Enrolled and Completed.
- Validate student IDs, course identifiers, and status codes.
- Handle invalid requests and missing enrollment records.
- Manage records using Spring Data JPA and H2.
- Explore and test endpoints through Swagger UI.
- Organize code using a layered backend architecture.

## Technology Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.1.2
- **API:** Spring Web MVC
- **Persistence:** Spring Data JPA
- **Database:** H2 In-Memory Database
- **Build Tool:** Maven
- **API Documentation:** Swagger UI / OpenAPI

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/course-status` | Create or update enrollment statuses |
| GET | `/api/course-status/{studentId}/{course}` | Retrieve a student's course status |

### Create or Update Enrollment Status

**Request:**

`POST /api/course-status`

```json
{
  "entries": "101-PYTHON:E,102-JAVA:C"
}
```

Entry format: `studentId-course:statusCode`

| Status Code | Meaning |
|---|---|
| `E` | Enrolled |
| `C` | Completed |

Multiple entries can be submitted in a comma-separated list.

### Retrieve Enrollment Status

**Request:**

`GET /api/course-status/101/PYTHON`

Returns the current enrollment status for student `101` in the `PYTHON` course.

## Getting Started

### Prerequisites

- Java JDK 21
- Git

The project includes Maven Wrapper, so a separate Maven installation is generally unnecessary.

### Clone the Repository

```bash
git clone https://github.com/Avinash2567/course-enrollment-api.git
cd course-enrollment-api
```

### Build the Project

On Windows PowerShell:

```powershell
.\mvnw.cmd clean compile
```

### Run Tests

```powershell
.\mvnw.cmd clean test
```

### Start the Application

```powershell
.\mvnw.cmd spring-boot:run
```

The application normally runs on port `8080`.

## API Documentation

After starting the application, open:

- **Swagger UI:** http://localhost:8080/swagger-ui/index.html
- **OpenAPI Specification:** http://localhost:8080/v3/api-docs

Swagger UI allows you to explore available endpoints, submit requests, and inspect responses.

## Database Notes

The application uses an H2 in-memory database. Enrollment records are lost when the application stops or restarts.

## Future Improvements

- Integrate a persistent database such as PostgreSQL or MySQL.
- Add authentication and role-based authorization.
- Expand unit and integration test coverage.
- Add automated builds and testing through CI.

## Author

**Avinash K**

GitHub: [@Avinash2567](https://github.com/Avinash2567)

---

*Developed to demonstrate REST API development, validation, exception handling, and database integration using Java and Spring Boot.*