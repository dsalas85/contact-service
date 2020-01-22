## fetch basic image
FROM openjdk:8-jdk-alpine

# local application port
EXPOSE 8035

# application placed into /opt/app
RUN mkdir -p /opt/service
WORKDIR /opt/service

# The application's jar file
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} contact-service.jar



# Run the jar file
CMD java -jar contact-service.jar


