# Use a base image with Java pre-installed
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file into the image
COPY build/libs/MabayaOnlineSponsoredAds-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will listen on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
