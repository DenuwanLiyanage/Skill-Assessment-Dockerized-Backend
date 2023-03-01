FROM openjdk:17-jdk-slim
WORKDIR /opt
ENV PORT 8087
EXPOSE 8087
COPY target/*.jar /opt/order_service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar order_service.jar