
# Relationship Management System

## Overview
This project is a **Spring Boot** application demonstrating relationships between various entities like **Student**, **Teacher**, **Course**, and **CourseMaterial** using **JPA**. It showcases **One-to-One**, **One-to-Many**, and **Many-to-Many** relationships along with basic CRUD operations and tests.

## Project Structure
```bash
src/
├── main/
│   ├── java/
│   │   └── sandeep/
│   │       └── relationship/
│   │           ├── Entity/
│   │           ├── Repository/
│   │           └── Service/
│   └── resources/
├── test/
│   ├── java/
│   │   └── sandeep/
│   │       └── relationship/
│   │           └── Repository/
└── pom.xml
```

### Entities:
- **Teacher**: Manages a list of courses.
- **Course**: Linked with CourseMaterial, many students, and a teacher.
- **CourseMaterial**: Provides materials for courses.
- **StudentEntity**: Represents a student with an optional guardian.
- **Guardian**: Embeddable class representing a student's guardian.

### Repository Tests:
- CRUD operations are tested for `StudentEntity`, `Course`, `Teacher`, and `CourseMaterial` using JUnit.
  
## Setup Guide

### Prerequisites:
- Java 11+
- MySQL
- Maven

### Step-by-Step Setup:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Sandy-7061/Relationship_and_Test.git
   cd relationship-management
   ```

2. **Set up MySQL Database**:
   Create a MySQL database called `school_db` (or your preferred name) using MySQL:
   ```sql
   CREATE DATABASE school_db;
   ```

3. **Configure Application Properties**:
   Update the `application.properties` file:
   ```properties
   spring.application.name=Relationship
   spring.datasource.url=jdbc:mysql://localhost:3306/school_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Build the Project**:
   Use Maven to build the project:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

6. **Testing**:
   Run the JUnit tests:
   ```bash
   mvn test
   ```

## Entity Relationships:
1. **One-to-One**: `Course` ↔ `CourseMaterial`
2. **One-to-Many**: `Teacher` ↔ `Course`
3. **Many-to-One**: `Course` ↔ `Teacher`
4. **Many-to-Many**: `Course` ↔ `Student`

## Author:
**Sandeep Kushwaha**  
- Phone: 7024520740  
- Email: sandeepkush880@gmail.com

```

This README provides an introduction, setup guide, and a high-level explanation of the project structure. Let me know if you'd like any changes!
