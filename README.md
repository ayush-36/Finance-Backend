#  Finance Backend System (Spring Boot)

A robust backend system for managing financial records with role-based access control, JWT authentication, and dashboard analytics.

---

##  Features

###  Authentication & Authorization
- JWT-based authentication
- Secure login & registration
- Role-Based Access Control (RBAC)

###  User Management
- Create users
- Assign roles (ADMIN, ANALYST, VIEWER)
- Update user role and status (active/inactive)
- Delete users (Admin only)

###  Financial Records
- Create, update, delete records
- Fields:
    - Amount
    - Type (Income / Expense)
    - Category
    - Date
    - Notes
- Filter records by:
    - Category (case-insensitive)
    - Type
    - Date

###  Dashboard APIs
- Total Income
- Total Expense
- Net Balance
- Category-wise totals
- Recent activity
- Monthly trends

###  Access Control
| Role    | Permissions |
|--------|------------|
| VIEWER | View dashboard only |
| ANALYST | View records + insights |
| ADMIN | Full access (users + records) |

---

##  Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- JWT (io.jsonwebtoken)
- PostgreSQL
- Hibernate / JPA
- Swagger (OpenAPI)
- Lombok

---

## 📌 API Documentation

## Swagger UI available at:
## http://localhost:8080/swagger-ui/index.html

## Steps to use:
1. Register user
2. Login to get JWT token
3. Click **Authorize** in Swagger
4. Enter: BEARER YOUR TOKEN


---

## 📦 API Response Format

All APIs return consistent JSON:

```json
{
  "status": "success",
  "message": "Operation completed",
  "data": {}
}

## Exception Handling
Centralized using @RestControllerAdvice
Custom exceptions:
ResourceNotFoundException
BadRequestException
UnauthorizedException

## Database
PostgreSQL used for persistence
Data is persistent across restarts
Managed using Spring Data JPA

## Enhancements Implemented

1 JWT Authentication
2 Role-Based Access Control (RBAC)
3 Swagger API Documentation
4 Standard API Response Structure
5 Global Exception Handling
6 Case-Insensitive Filtering
7 Dashboard analytics APIs




-----------------------------------------------------------------------------------------------------------
## Future enhancements
1 Pagination
2 Soft delete
3 Rate Limiting
4 Testing


## Author
AYUSH UPADHYAY