FROM maven:3.9.9-eclipse-temurin-21

WORKDIR /app

ARG INSECURE
ENV MAVEN_OPT=${INSECURE:+"-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true -Dmaven.resolver.transport=wagon"}

COPY pom.xml .
COPY src ./src

RUN \
    --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline $MAVEN_OPT

RUN \
    --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests $MAVEN_OPT

ENTRYPOINT ["java", "-jar", "/app/target/blueprint.jar"]