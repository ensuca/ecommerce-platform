
FROM openjdk:17-jdk-alpine

# App Permission
WORKDIR /app

# Copy JAR file created with Maven
COPY target/ecommerce-platform-0.0.1-SNAPSHOT.jar app.jar

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
