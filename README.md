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

## 🌐 Live API (Deployed)


Swagger UI:
https://finance-backend-7upq.onrender.com/swagger-ui/index.html  (use this one)

## 🧪 How to Use (Swagger Flow)

1. Open Swagger UI
2. Register a new user using /auth/register
3. Login using /auth/login
4. Copy the JWT token
5. Click "Authorize" and paste:
   Bearer <your_token>
6. Access APIs based on role:
  - ADMIN → Full access
  - ANALYST → Read + insights
  - VIEWER → Dashboard only




## 🗄️ Database Setup

The application uses:

- Local: PostgreSQL (for development)
- Production: Render PostgreSQL (cloud hosted)

Environment variables are used for configuration:
- DB_URL
- DB_USERNAME
- DB_PASSWORD

This ensures secure and flexible deployment.

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



Note:-
Please configure your PostgreSQL credentials in `application.yml` before running the application.



## Author
AYUSH UPADHYAY