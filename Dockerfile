FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

COPY . .
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
