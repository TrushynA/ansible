#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY ./home/app/
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim AS make
ENV TZ=Europe/Minsk
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=build /home/app/target/graph-0.0.1-SNAPSHOT.jar /usr/local/lib/graph.jar
RUN rm -rf /home/app
EXPOSE 8080
ENTRYPOINT ["java","-Xmx1024m","-Xss1024m","-jar","/usr/local/lib/graph.jar"]
