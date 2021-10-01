FROM java:8
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} helloWorld-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/helloWorld-0.0.1-SNAPSHOT.jar"]
