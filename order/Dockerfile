FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="order"
LABEL build_version=""
LABEL maintainer=""

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:order
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV KNIGHT_URL=http://localhost:8081

EXPOSE 8080

COPY target/order-0.0.1-SNAPSHOT.jar /opt/order/order.jar

CMD ["java", "-jar", "/opt/order/order.jar"]
