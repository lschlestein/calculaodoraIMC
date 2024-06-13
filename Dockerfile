FROM maven:3.8.6-jdk-11 as build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean install
FROM openjdk:8-jre-alpine
COPY --from=build /app/target/calculadoraIMC-1.0-SNAPSHOT.jar /app/calculadora.jar
WORKDIR /app
CMD ["java", "-jar", "calculadora.jar"]
