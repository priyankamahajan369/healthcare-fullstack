# Healthcare Scheduling Platform - Full Stack Java Interview Project

> IMPORTANT INTERVIEW ETHICS NOTE: This is an original interview demonstration project modeled on common enterprise healthcare workflows. It is not Mount Sinai source code and contains no proprietary Mount Sinai data. You can say it demonstrates the same kinds of skills you used at work. Only claim specific production incidents as your own if they are true.

## What this project proves
- Java 17 + Spring Boot REST APIs
- CRUD: Create, Read, Update, Delete
- Maven multi-module build
- JPA specification + Hibernate implementation
- PostgreSQL persistence
- Patient Service and Appointment Service REST communication
- React UI consuming backend APIs
- Redux Toolkit centralized state
- Postman manual API testing
- JUnit / MockMvc backend automated tests
- Docker and Docker Compose
- GitHub Actions CI

## Architecture
React + Redux -> Appointment/Patient REST Controllers -> Service Layer -> JPA Repository -> Hibernate -> PostgreSQL
Appointment Service -> REST call -> Patient Service before appointment creation

## Ports
- Patient Service: 8081
- Appointment Service: 8082
- React UI: 3000
- Patient PostgreSQL: 5433 (host) / 5432 (container)
- Appointment PostgreSQL: 5434 (host) / 5432 (container)

## Run with Docker
```bash
docker compose -f deployment_Docker/docker-compose_Docker.yml up --build
```
Then open http://localhost:3000

## Useful endpoints
Patient Service:
- POST /api/patients
- GET /api/patients
- GET /api/patients/{id}
- PUT /api/patients/{id}
- DELETE /api/patients/{id}

Appointment Service:
- POST /api/appointments
- GET /api/appointments
- GET /api/appointments/{id}
- PUT /api/appointments/{id}
- DELETE /api/appointments/{id}

## Filename convention
Normal source files include the demonstrated skill in the filename, e.g. `PatientController_REST_API.java`, `PatientRepository_JPA.java`, `PatientService_ServiceLayer.java`, and `patientSlice_Redux.js`.
Framework-reserved names such as `pom.xml`, `package.json`, and `application.yml` keep their required names; their parent folder names identify the skill.

## Interview-safe wording
Good: "This project demonstrates the architecture and patterns I used in enterprise healthcare development."
Avoid: "This is Mount Sinai's code" or claims about a real incident unless you personally handled it.
