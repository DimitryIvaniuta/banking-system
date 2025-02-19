# Use an official OpenJDK 21 image as the base
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from Gradle's output directory
COPY build/libs/account-service.jar account-service.jar

# Expose the application's port
EXPOSE 8081

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "account-service.jar"]