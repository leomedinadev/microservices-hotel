FROM eclipse-temurin:17-jre

COPY target/msh-eurekaserver-1.0.0-SNAPSHOT.jar msh-eurekaserver-1.0.0-SNAPSHOT.jar

EXPOSE 8065

ENTRYPOINT [ "java", "-jar", "/msh-eurekaserver-1.0.0-SNAPSHOT.jar" ]