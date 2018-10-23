FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /usr/src/app1
COPY target/ ./
EXPOSE 80
CMD ["java -jar", "registry-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java", "-Dserver.port=80","-jar","registry-0.0.1-SNAPSHOT.jar"]