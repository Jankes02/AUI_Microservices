FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="knight"
LABEL build_version=""
LABEL maintainer=""

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:knight
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/knight-0.0.1-SNAPSHOT.jar /opt/knight/knight.jar

CMD ["java", "-jar", "/opt/knight/knight.jar"]
