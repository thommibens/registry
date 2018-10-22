FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /usr/src/app1
COPY target/ ./
EXPOSE 8080
CMD ["java -jar", "registry-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","registry-0.0.1-SNAPSHOT.jar"]