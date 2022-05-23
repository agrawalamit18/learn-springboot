FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY /home/runner/work/learn-springboot/learn-springboot/target/learn-springboot-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "learn-springboot-0.0.1-SNAPSHOT.jar"]
