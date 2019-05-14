FROM maven:3.6.1-jdk-11
WORKDIR /build
COPY ./ /build/
RUN mvn package -f /build/pom.xml && cp target/freshfoodstore-0.0.1.jar /build/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.location=/config/application.properties","-jar","/build/app.jar"]
