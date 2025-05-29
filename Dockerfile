# Этап сборки
FROM gradle:8.7-jdk21 AS builder

WORKDIR /app
COPY . .

# Сборка fat jar
RUN gradle clean bootJar --no-daemon

# ----------------------------------------

# Финальный образ (только JRE)
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Копируем собранный jar из builder
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]