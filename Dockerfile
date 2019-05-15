FROM maven:3.6.1-jdk-11 as build
WORKDIR /build
COPY ./ /build/
RUN mvn clean package -f /build/pom.xml && cp target/freshfoodstore-0.0.1.jar /build/app.jar && rm -rf /root/.m2
ENV JAVA_OPTS=""

FROM openjdk:11.0.3-jdk-stretch
WORKDIR /app
COPY --from=build /build/target/freshfoodstore-0.0.1.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.location=/config/application.properties","-jar","/app/app.jar"]
