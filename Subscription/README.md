# Subscription & Plan Management Module — MediaHub

## Description
This module handles Subscription and Plan Management for the MediaHub platform.
It manages subscription products, upgrades, renewals, downgrades, cancellations,
and access entitlements for subscribers.

## Entities
| Entity           | Description                              |
|------------------|------------------------------------------|
| SubscriptionPlan | Defines tiered plans — Free, Basic, Standard, Premium |
| UserSubscription | Tracks each subscriber's active plan and status |

## Package Structure
```
com.mediahub.subscription
├── model/
│   ├── SubscriptionPlan.java
│   └── UserSubscription.java
├── repository/
│   ├── SubscriptionPlanRepository.java
│   └── UserSubscriptionRepository.java
├── service/
│   └── SubscriptionService.java
└── controller/
    └── SubscriptionController.java
```

## Branch
`feature/Subscription`

## How to Run
1. Configure `application.properties` with your MySQL credentials
2. Run `SubscriptionApplication.java` as a Spring Boot application
3. Server runs on port 8085
