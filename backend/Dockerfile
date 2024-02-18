# Stage 1: Build stage with Maven and OpenJDK
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /build

# Copy only the pom.xml to leverage Docker cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src src
RUN mvn package -DskipTests

# Stage 2: Runtime stage with only the necessary artifacts
FROM amazoncorretto:21-alpine3.16
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /build/target/api-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8081

# Command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]