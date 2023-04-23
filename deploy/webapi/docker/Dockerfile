FROM openjdk:17-jdk-alpine AS build
WORKDIR /backend/jvm/webapi
COPY ../../../backend/jvm/webapi /backend/jvm/webapi
RUN ./gradlew clean build --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /backend/jvm/webapi/build/libs/webapi.jar webapi.jar
EXPOSE 8080
CMD ["java", "-jar", "webapi.jar"]