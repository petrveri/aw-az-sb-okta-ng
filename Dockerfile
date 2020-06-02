FROM openjdk:8u151-jdk-alpine

RUN apk --no-cache add curl
RUN apk --no-cache add bash

COPY ./target/aw_jpa-0.0.1-SNAPSHOT.jar /aw-server.jar
ADD ./start.sh /start.sh
CMD chmod +x start.sh
RUN ["chmod", "+x", "/start.sh"]

ENTRYPOINT ["/start.sh"]
