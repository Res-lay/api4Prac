#FROM ubuntu:latest as build
#RUN apt-get update
#RUN apt-get install openjdk-17-jdk -y
#COPY . .
#RUN mvn package
#
#FROM open:jdk:17-jdk-slim
#EXPOSE 8080
#
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jre-slim


WORKDIR /app

COPY target/*.jar app.jar
COPY pom.xml pom.xml

RUN apt-get update && apt-get install -y maven
RUN mvn clean package

EXPOSE 8080

# Запускаем приложение
CMD ["java", "-jar", "demo.jar"]