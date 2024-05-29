# Use the official OpenJDK 17 Alpine image as the base image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file of your application to the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
