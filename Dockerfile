FROM openjdk:15-jdk
COPY simple-app.jar simple-app.jar
CMD ["java","-jar","simple-app.jar"]