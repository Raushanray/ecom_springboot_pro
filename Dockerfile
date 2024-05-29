FROM openjdk:17-alpine
WORKDIR /app
COPY ecom_springboot_pro-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "/app/ecom_springboot_pro-0.0.1-SNAPSHOT.jar"]
