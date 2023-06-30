FROM openjdk:11-jdk
MAINTAINER Rodney Azevedo
WORKDIR /app
COPY target/application-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app/app.jar"]
