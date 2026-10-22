FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Копируем собранный JAR. Убедитесь, что имя файла совпадает с тем, что в папке target!
COPY target/user-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]