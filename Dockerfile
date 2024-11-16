FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY build/libs/*SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
