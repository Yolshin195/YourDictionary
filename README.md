# YourDictionary

## Description

YourDictionary is a Kotlin + Spring Boot project that provides a REST API for managing phrases. It supports pagination and includes Swagger UI for easy API exploration.

---

## How to Run

1. **Build and start the application using Docker Compose:**

```bash
docker-compose up -d
```

2. **Check container logs (optional):**

```bash
docker-compose logs -f
```

3. **Stop the application:**

```bash
docker-compose down
```

---

## API Documentation

Once the application is running, open your browser and navigate to:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Here you can explore the API endpoints, send test requests, and see request/response models.

---

## Project Structure

* `api` — REST controllers
* `service` — Business logic
* `dto` — Data transfer objects
* `repository` — Database access (JPA repositories)

---

## Requirements

* Docker & Docker Compose installed on your machine
* Java 21 (if running locally without Docker)
* Internet connection to download dependencies on first build

---

## Troubleshooting

* If ports are busy, change the exposed port in `docker-compose.yml`.
* For database resets, clear volumes or change DB config (if applicable).

---
