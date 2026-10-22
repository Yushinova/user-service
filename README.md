# 🚀 User Management Microservices

Микросервисная система для управления пользователями с асинхронной отправкой уведомлений через Kafka.

## 🏗 Архитектура

Система развернута в изолированной Docker-сети и включает следующие компоненты:

| Компонент | Порт | Описание |
| :--- | :--- | :--- |
| 🐘 **PostgreSQL** | `5432` | База данных |
| 📨 **Apache Kafka** | `9092` | Брокер сообщений |
| ⚙️ **Config Server** | `8888` | Централизованная конфигурация |
| 🔍 **Eureka Server** | `8761` | Service Discovery (реестр сервисов) |
| 🚪 **API Gateway** | `8080` | Единая точка входа |
| 👤 **User Service** | `8081` | Управление пользователями |
| 📧 **Notification Service** | `8082` | Обработка событий и отправка Email |

## 🚀 Запуск

**1. Сборка JAR-файлов:**
```bash
mvn clean package -DskipTests
2. Запуск контейнеров:

bash
docker compose up --build -d
3. Остановка:

bash
docker compose down
🔬 Проверка работоспособности
Service Discovery: Откройте http://localhost:8761 и убедитесь, что все сервисы (Gateway, User, Notification) зарегистрированы.

Документация API (Swagger): Доступна через Gateway по адресу 👉 http://localhost:8080/swagger-ui/index.html.

Тестирование: Создайте пользователя через Swagger на 8080. Убедитесь, что данные сохранились в БД, а в логах notification-service появилось сообщение о получении события из Kafka (docker compose logs -f notification-service).

🛠 Стек технологий
Java 21, Spring Boot 3, Spring Cloud (Gateway, Eureka, Config), PostgreSQL, Apache Kafka, Docker Compose.
