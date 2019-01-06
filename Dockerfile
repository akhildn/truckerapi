FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY ./target/trucker-api-1.0-DEV.jar truckerapi.jar
COPY ./docker-entrypoint.sh /docker-entrypoint.sh

RUN chmod 755 /docker-entrypoint.sh

RUN touch /api.rar && mkdir -p /config

WORKDIR /

EXPOSE 8080

ENTRYPOINT [ "/docker-entrypoint.sh" ]

CMD ["java $JAVA_OPTS -Djava.security.egd=file:dev/dev/./urandom -jar /truckerapi.jar"]