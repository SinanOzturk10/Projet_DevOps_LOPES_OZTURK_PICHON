FROM alpine:latest AS build

WORKDIR /app

RUN apk add maven openjdk17

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM alpine:latest

WORKDIR /app

RUN apk add openjdk17-jre

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

COPY --from=build /app/target/LopesOzturkPichon-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
