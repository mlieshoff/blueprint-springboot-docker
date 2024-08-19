FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

ARG INSECURE
ENV MAVEN_OPT=${INSECURE:+"-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true -Dmaven.resolver.transport=wagon"}

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline $MAVEN_OPT

RUN mvn clean package -DskipTests $MAVEN_OPT

ENTRYPOINT ["java", "-jar", "/app/target/blueprint.jar"]