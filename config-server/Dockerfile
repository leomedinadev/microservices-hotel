FROM eclipse-temurin:17-jre

COPY target/msh-configserver-1.0.0-SNAPSHOT.jar msh-configserver-1.0.0-SNAPSHOT.jar

EXPOSE 8085

ENTRYPOINT [ "java", "-jar", "/msh-configserver-1.0.0-SNAPSHOT.jar" ]