FROM openjdk:14-alpine
COPY target/yacas-server-*.jar yacas-server.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "yacas-server.jar"]