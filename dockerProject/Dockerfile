FROM maven:3.8.4-openjdk-17-slim

copy src /var/jenkins_home/workspace/docker/src

copy testng.xml /home/dockerProject

copy pom.xml /var/jenkins_home/workspace/docker

copy testng.xml /var/jenkins_home/workspace/docker

RUN mvn -f /var/jenkins_home/workspace/docker/pom.xml clean test -DskipTests=true 