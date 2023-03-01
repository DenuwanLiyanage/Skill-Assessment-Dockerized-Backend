FROM alvistack/openjdk-17
WORKDIR /opt
ENV PORT 8089
EXPOSE 8089
COPY target/*.jar /opt/distribution_service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar distribution_service.jar