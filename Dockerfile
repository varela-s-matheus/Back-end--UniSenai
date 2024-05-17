FROM ubuntu:22.04 AS build

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
        apt-get install -y openjdk-17-jdk maven && \
        apt-get clean && \
        rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/artifacts/Back_end__UniSenai_jar/Back-end--UniSenai.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]