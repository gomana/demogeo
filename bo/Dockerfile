FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/bo-0.0.1-SNAPSHOT.jar /app/app.jar
ENV	PROFILE dev
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILE}","/app/app.jar"]