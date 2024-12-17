# Stage 1: Build
FROM eclipse-temurin:23-jdk as builder

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы Gradle Wrapper и build.gradle
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

# Копируем исходный код
COPY src src

# Делаем Gradle Wrapper исполняемым
RUN chmod +x gradlew

# Выполняем сборку
RUN ./gradlew clean build -x test

# Stage 2: Run
FROM eclipse-temurin:23-jre

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar файл из стадии сборки
COPY --from=builder /app/build/libs/*.jar app.jar

# Устанавливаем порт
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
