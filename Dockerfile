FROM openjdk:8-jdk

COPY ./target/ecommerce-vinil-api-0.0.1-SNAPSHOT.jar /usr/src/ecommerce-vinil-api/ecommerce-vinil-api.jar

WORKDIR /usr/src/ecommerce-vinil-api

EXPOSE 8080 80

CMD java -jar ecommerce-vinil-api.jar


