FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY ../../../backend/jvm/webapi .

RUN ./gradlew clean build --no-cache --no-daemon


FROM openjdk:17-jdk-slim

COPY --from=build /build/libs/webapi.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
