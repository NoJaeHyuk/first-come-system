# Base image
FROM eclipse-temurin:21-jre-alpine

# Copy application JAR file
COPY build/libs/*SNAPSHOT.jar /app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
