FROM openjdk:11
ADD target/limon-0.0.1.jar limon-0.0.1.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","limon-0.0.1.jar"]