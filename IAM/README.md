# IAM Module — MediaHub

## Description
This module handles the IAM functionality of the MediaHub platform.

## Package Structure
```
com.mediahub.iam
├── model/          — POJO / Model classes
├── repository/     — Database layer (JDBC queries)
├── service/        — Business logic layer
└── controller/     — REST API endpoints
```

## Branch
`feature/IAM`

## How to Run
1. Configure `application.properties` with your MySQL credentials
2. Run `IAMApplication.java` as a Spring Boot application
