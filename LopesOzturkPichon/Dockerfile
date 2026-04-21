FROM ubuntu:24.04 AS build

WORKDIR /app

RUN apt-get update
RUN apt-get install -y maven openjdk-17-jdk
RUN rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM ubuntu:24.04

WORKDIR /app

RUN apt-get update
RUN apt-get install -y openjdk-17-jre
RUN rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/LopesOzturkPichon-1.0-SNAPSHOT.jar demo.jar

CMD ["java", "-jar", "demo.jar"]
