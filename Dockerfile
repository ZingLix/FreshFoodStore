FROM openjdk:11.0.3-jdk-stretch
VOLUME /tmp
ADD target/freshfoodstore-0.0.1.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.location=/config/application.properties","-jar","/app.jar"]
