FROM eclipse-temurin:17-jdk-jammy AS build-image
WORKDIR /app

COPY . .

RUN ./mvnw clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-jammy AS app
COPY --from=build-image /app/target/*.jar /app/app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/app.jar", "--server.port=9090"]