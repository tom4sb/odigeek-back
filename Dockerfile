FROM amazoncorretto:21-alpine-jdk

WORKDIR /app
COPY target/odigeek-0.0.1-SNAPSHOT.jar odigeek.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "odigeek.jar"]
