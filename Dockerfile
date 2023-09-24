FROM openjdk:17-jdk-slim


WORKDIR /app

COPY target/*.jar app.jar
COPY pom.xml pom.xml

RUN apt-get update && apt-get install -y maven
RUN mvn clean package

EXPOSE 8080


CMD ["java", "-jar", "demo.jar"]