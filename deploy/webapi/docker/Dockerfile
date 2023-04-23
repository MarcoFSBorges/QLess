# Use an official OpenJDK 17 runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR ../../../backend/jvm/webapi

# Copy the Spring Boot JAR file to the container
COPY build/libs/webapi.jar .

# Expose the port that the Spring Boot app listens on
EXPOSE 8080

# Run the Spring Boot app when the container starts
CMD ["java", "-jar", "webapi.jar"]