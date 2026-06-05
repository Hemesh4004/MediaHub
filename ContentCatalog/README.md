# ContentCatalog Module — MediaHub

## Description
This module handles the ContentCatalog functionality of the MediaHub platform.

## Package Structure
```
com.mediahub.catalog
├── model/          — POJO / Model classes
├── repository/     — Database layer (JDBC queries)
├── service/        — Business logic layer
└── controller/     — REST API endpoints
```

## Branch
`feature/ContentCatalog`

## How to Run
1. Configure `application.properties` with your MySQL credentials
2. Run `ContentCatalogApplication.java` as a Spring Boot application
