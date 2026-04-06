FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# rename jar to fixed name
RUN mv target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
