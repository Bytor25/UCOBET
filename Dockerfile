FROM openjdk:23
VOLUME /tmp
ARG JAR_FILE=target/UCOBET-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ucobet_app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ucobet_app.jar"]