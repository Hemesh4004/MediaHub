# MediaHub — Digital Content & Subscription Management Platform

## Project Overview
MediaHub is a web-based digital content and subscription management platform
designed for media companies, OTT operators, publishing houses, and content
studios to manage content catalogs, creator onboarding, subscription plans,
audience engagement, content licensing, royalty calculations, and revenue analytics.

## Tech Stack
- Backend  : Java Spring Boot 3.2.0
- Frontend : React / Angular
- Database : MySQL / PostgreSQL
- Build    : Maven

## Modules

| Module           | Description                              | Branch                    | Member   |
|------------------|------------------------------------------|---------------------------|----------|
| IAM              | Identity and Access Management           | feature/IAM               | Member 1 |
| ContentCatalog   | Content Catalog and Creator Management   | feature/ContentCatalog    | Member 2 |
| Editorial        | Editorial and Content Scheduling         | feature/Editorial         | Member 3 |
| Licensing        | Content Licensing and Rights Management  | feature/Licensing         | Member 4 |
| Royalty          | Royalty and Revenue Management           | feature/Royalty           | Member 5 |
| Analytics        | Media Analytics and Reporting            | feature/Analytics         | Member 6 |
| Notifications    | Notifications and Alerts                 | feature/Notifications     | Member 7 |
| Subscription     | Subscription and Plan Management         | feature/Subscription      | Member 8 |
| mediahub-shared  | Shared common utilities and models       | main                      | All      |

## Branch Strategy
- `main`                  — stable production-ready code
- `develop`               — integration branch (merge all features here first)
- `feature/MODULE`        — individual module development branch

## Project Structure
```
MediaHub/
├── IAM/
├── ContentCatalog/
├── Editorial/
├── Licensing/
├── Royalty/
├── Analytics/
├── Notifications/
├── mediahub-shared/
├── .gitignore
├── README.md
└── pom.xml
```

## How to Run
1. Clone the repository
2. Import as Maven project in IntelliJ IDEA or Eclipse
3. Configure MySQL in each module's application.properties
4. Run each module independently as a Spring Boot application
