FROM openjdk:17-jdk-slim
WORKDIR /app

RUN apt-get update 
RUN apt-get install openjdk-17-jdk -y


COPY . . 

RUN apt-get install maven -y
RUN mvn clean install 

EXPOSE 8080

COPY --from=build /target/projetoIntermediario-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]