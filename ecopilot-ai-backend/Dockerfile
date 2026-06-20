# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests


# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy generated jar
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
