FROM openjdk:17-jdk-slim
WORKDIR /apps
COPY target/devops-0.0.1-SNAPSHOT.jar hema.jar
EXPOSE 9099
ENTRYPOINT ["java","-jar","hema.jar"]