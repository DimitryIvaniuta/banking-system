# 📊 Banking System Microservices

A **Java 21**, **Spring Boot**, and **MongoDB**-powered microservices banking system running on **Docker** and hosted on **Google Cloud Platform (GCP)**. This project demonstrates scalable microservice architecture with integrated security, NoSQL data storage, and cloud readiness.

---

## 📁 Project Structure

```
banking-system/
├── api-gateway/                  # Spring Cloud Gateway for routing
├── service/
│   ├── account-service/          # Manages bank accounts
│   ├── fraud-detection-service/  # Handles fraud detection logic
│   ├── reporting-service/        # Generates transaction reports
│   └── transaction-service/      # Manages transactions
├── common/                       # Shared libraries/utilities
├── docker-compose.yml            # Docker Compose for service orchestration
├── settings.gradle.kts           # Gradle settings
└── README.md                     # Project documentation
```

---

## 🚀 Getting Started

### ⚙️ Prerequisites

- **Java 21**
- **Gradle 8+**
- **Docker & Docker Compose**
- **MongoDB** (Dockerized)
- **IntelliJ IDEA**

---

### 📦 Running the Project

1. **Clone the repository:**

```bash
git clone https://github.com/your-repo/banking-system.git
cd banking-system
```

2. **Start MongoDB using Docker Compose:**

```bash
docker-compose up -d mongodb
```

3. **Build and run the project:**

```bash
./gradlew build --refresh-dependencies
./gradlew bootRun
```

4. **Verify services:**

- API Gateway: [http://localhost:8080](http://localhost:8080)

---

## ⚡ API Endpoints

### 🔑 **Authentication**

- Basic Authentication is used.
- **Default credentials:**
    - Username: `user`
    - Password: `password`

---

### 🏦 **Account Service** (`/api/accounts`)

- **POST** `/api/accounts` — Create new account
- **GET** `/api/accounts` — List all accounts
- **GET** `/api/accounts/{id}` — Get account by ID

### 💳 **Transaction Service** (`/api/transactions`)

- **POST** `/api/transactions` — Create a transaction
- **GET** `/api/transactions/{id}` — Get transaction by ID

### 🚨 **Fraud Detection Service** (`/api/fraud-check`)

- **POST** `/api/fraud-check` — Check if a transaction is fraudulent

### 📊 **Reporting Service** (`/api/reports`)

- **GET** `/api/reports/accounts` — Get account report
- **GET** `/api/reports/transactions` — Get transaction report

---

## ⚙️ Configuration

### 📂 `application.yml`

Each service has its own `application.yml`.

Example for **Account Service**:

```yaml
server:
  port: 8081

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/banking
      database: banking

logging:
  level:
    org.springframework.security: DEBUG
```

---

## 🐳 Docker Setup

### 📂 `docker-compose.yml`

```yaml
version: '3.8'

services:
  mongodb:
    image: mongo:latest
    container_name: mongodb
    ports:
      - "27017:27017"
    volumes:
      - mongo-data:/data/db

volumes:
  mongo-data:
```

Run MongoDB:

```bash
docker-compose up -d mongodb
```

---

## 🔒 Security

- Uses **Spring Security** with **Basic Authentication**.
- Default user is set in `SecurityConfig.java`.

```java
@Bean
public UserDetailsService userDetailsService() {
    UserDetails user = User
        .withUsername("user")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
}
```

---

## 🛠️ Development Tips

### 🧩 Importing Project into IntelliJ IDEA

1. **Open IntelliJ IDEA** → **File** → **Open** → Select `banking-system` folder.
2. **Mark source directories:**
    - Right-click `src/main/java` → **Mark Directory as** → **Sources Root**
    - Right-click `src/test/java` → **Mark Directory as** → **Test Sources Root**
3. **Refresh Gradle:**
    - View → Tool Windows → Gradle → Click **Refresh**

### 🔄 Refresh Dependencies

```bash
./gradlew clean build --refresh-dependencies
```

---

## 📚 Useful Commands

| Command                         | Description                          |
|---------------------------------|--------------------------------------|
| `./gradlew build`               | Build the project                    |
| `./gradlew bootRun`             | Run Spring Boot app                  |
| `docker-compose up -d mongodb`  | Run MongoDB in Docker                |
| `docker ps`                     | List running Docker containers       |
| `docker logs mongodb`           | View MongoDB logs                    |

---

## 📖 License

This project is licensed under the **MIT License**. Feel free to use and modify it as needed.

---

## 💡 Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add YourFeature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a Pull Request 🚀

---

## 📬 Contact

**Your Name** — [your.email@example.com](mailto:your.email@example.com) — [GitHub](https://github.com/your-github)

_Star ⭐ this project if you found it helpful!_ 🚀

