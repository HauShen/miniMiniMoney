# miniMiniMoney

`miniMiniMoney` is a backend service for a personal finance application. It provides APIs for managing user profiles, wallets, and financial records, with a focus on clean backend structure and maintainable business logic.

## Overview

This project is built as a Kotlin + Spring Boot backend for tracking personal financial data. It currently includes support for:

- User creation and retrieval
- User profile updates
- Wallet creation
- Financial transaction handling
- Asset creation
- Loan and debt record creation
- Database persistence with PostgreSQL
- Database migration support with Flyway
- API contract definition with OpenAPI

## Tech Stack

- **Language:** Kotlin
- **Framework:** Spring Boot
- **Build Tool:** Gradle Kotlin DSL
- **Database:** PostgreSQL
- **Database Migration:** Flyway
- **API Spec:** OpenAPI 3
- **HTTP Client:** Spring Cloud OpenFeign
- **Testing Tools:** Spring Boot Test, AssertJ, WireMock, H2

## Why I built this

I built this project to practice designing a backend service around a real-world domain: personal finance. The goal was to model common money-management concepts such as users, wallets, transactions, assets, loans, and debts, while keeping the codebase structured for future expansion.

## Features

### User Profile
- Create a user
- Retrieve a user by ID
- Update user details

### Wallet
- Create a wallet for a user

### Financial Records
- Create transactions
- Create assets
- Create loans
- Create debts

## API Examples

Example commands from the repository:

```bash
# Create user
curl -v -X POST \
  -H "Content-Type: application/json" \
  -d '{"name":"Ding", "birthday":"2023-07-11"}' \
  http://localhost:8080/user/create

# Get user
curl -v -X GET \
  http://localhost:8080/user/get/dbce5980-885b-46a6-b919-9ac1c596cc1a

# Update user
curl -v -X PUT \
  -H "Content-Type: application/json" \
  -d '{"name":"Ding2", "birthday":"2013-07-11"}' \
  http://localhost:8080/user/update/b2639889-9b24-4990-80c7-0e951ddd598e
```

Additional example API calls are available in `curl-commands.txt`.

## Project Structure

```text
src/main/kotlin/        # Kotlin source code
src/main/resources/     # application properties, OpenAPI spec, Flyway migrations
build.gradle.kts        # Gradle build configuration
curl-commands.txt       # example API requests
start-db.sh             # local PostgreSQL startup script
```

## Local Development

### Prerequisites

- Java 21
- Docker
- PostgreSQL (or Dockerized PostgreSQL)
- Gradle wrapper

### 1. Start the database

You can use the provided script:

```bash
chmod +x start-db.sh
./start-db.sh
```

This starts a PostgreSQL container with:
- database: `miniminimoney`
- username: `admin`
- password: `abc123`
- port: `15432`

### 2. Check application configuration

The default application properties use:

```properties
spring.datasource.url=jdbc:postgresql://localhost:15432/miniminimoney
spring.datasource.username=admin
spring.datasource.password=abc123
```

### 3. Run the application

```bash
./gradlew bootRun
```

## Configuration

Main configuration is stored in:

- `src/main/resources/application.properties`
- `src/main/resources/application-test.properties`
- `src/main/resources/application-scheduler.properties`

## API Contract

The OpenAPI definition is available at:

- `src/main/resources/miniminimoney.yaml`

It documents parts of the API, including endpoints for user operations.

## Database Migration

Flyway is configured to load migrations from:

```text
src/main/resources/db/migration
```


This project is an actively evolving backend prototype for a personal finance system. It already models several core financial entities and API flows, and it can be extended further with authentication, reporting, validation improvements, and richer financial analytics.

> Built a Kotlin Spring Boot backend for a personal finance application, implementing APIs and business logic for managing users, wallets, transactions, assets, loans, and debts with PostgreSQL and Flyway.
