FROM ubuntu:lastest AS build

RUN apt-get update
RUN apt-get install openjdk-18-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvm clean install

FROM openjdk:18-jdk-slim

EXPOSE 8080

COPY --from=build /target/artifacts/Back_end__UniSenai_jar/Back-end--UniSenai.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]