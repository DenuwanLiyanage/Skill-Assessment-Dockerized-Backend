FROM openjdk:17-jdk-slim
WORKDIR /opt
ENV PORT 8086
EXPOSE 8086
COPY target/*.jar /opt/client_service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar client_service.jar