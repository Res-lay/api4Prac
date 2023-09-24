FROM maven:3.8.4-openjdk-17-slim AS build

COPY . /app
WORKDIR /app

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "target/prac5-0.0.1-SNAPSHOT.jar"]
