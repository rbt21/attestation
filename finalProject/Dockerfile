# Базовый образ с JDK 21
FROM openjdk:21-jdk-oracle as build

# Установка рабочей директории внутри Docker образа
WORKDIR /app

# Копирование maven wrapper и pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Копирование исходного кода проекта
COPY src src

# Сборка приложения
RUN ./mvnw package -DskipTests

# Вторая стадия для минимизации размера образа
FROM openjdk:21-jdk-oracle
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
