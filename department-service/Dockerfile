FROM quay.io/quarkus/ubi-quarkus-mandrel:20.2-java11
# FROM registry.access.redhat.com/ubi8/openjdk-11

# RUN addgroup -S spring && adduser -S spring -G spring
USER 1000
COPY target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
