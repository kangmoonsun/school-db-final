FROM openjdk:11-jdk

COPY ./build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
