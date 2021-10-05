FROM java:8
EXPOSE 8080
ARG JAR_FILE=target/helloWorld-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} HelloWorld.jar
ENTRYPOINT ["java","-jar","/HelloWorld.jar"]
