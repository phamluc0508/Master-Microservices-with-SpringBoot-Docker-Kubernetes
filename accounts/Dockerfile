#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Infomation about who maintains the image
MAINTAINER luc.pham

#Add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]