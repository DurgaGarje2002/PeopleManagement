# People Management Mini Project

A simple full-stack application to manage people records with complete CRUD operations.

---

## Tech Stack

### **Backend**
- Java 17  
- Spring Boot 3+  
- Spring Web  
- Spring Data JPA  
- MySQL  
- Maven  

### **Frontend**
- HTML  
- CSS  
- JavaScript (Fetch API)

---

## Project Structure

```
PeopleManagement/
│
├── backend/
│     └── people-management/      # Spring Boot Backend
│
├── frontend/
│     ├── index.html
│     ├── style.css
│     └── script.js
│
└── README.md
```

---

##Backend Setup

1. Open the Spring Boot project located in `backend/people-management` in STS/Eclipse/IntelliJ.

2. Update database config in:
`src/main/resources/application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/people_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3. Create database in MySQL Workbench (if not auto created):

```sql
CREATE DATABASE people_db;
```

4. Run the backend:

```
Run As → Spring Boot App
```

5. Server will start on:

```
http://localhost:9090/
```

---

## Frontend Setup

1. Open the `frontend/index.html` file in a browser  
   (or use VS Code Live Server).

2. The frontend communicates with backend via:

```
http://localhost:9090/api/people
```

3. Available Operations:

- Add a person  
- View all people  
- Edit person details  
- Delete a person  
- Auto-refresh table after actions  

---

## API Endpoints

| Method | Endpoint | Description |
|--------|-----------|--------------|
| GET | `/api/people` | Get all people |
| GET | `/api/people/{id}` | Get person by ID |
| POST | `/api/people` | Add person |
| PUT | `/api/people/{id}` | Update person |
| DELETE | `/api/people/{id}` | Delete person |

---

## Features Implemented

- Full CRUD operations  
- User input validation  
- Global exception handling  
- Database integration  
- Clean and responsive UI  
- Modern buttons and layout  
- JavaScript Fetch API for API calls  
- Edit + Delete actions  
- Auto-refresh table  
- Simple project structure  

---

## How to Run the Project

1. **Start the backend first**  
   (Spring Boot on port 9090)

2. Open:

```
frontend/index.html
```

3. Everything will load and start working automatically.

