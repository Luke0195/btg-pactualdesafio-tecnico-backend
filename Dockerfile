FROM openjdk:17-alpine
LABEL  author="Lucas Santos"
COPY build/libs/*.jar app.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]