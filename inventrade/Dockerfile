# Use official OpenJDK image as base
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy jar file into container
COPY target/inventrade-0.0.1-SNAPSHOT.jar app.jar

# Expose port (must match Spring Boot server port)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
