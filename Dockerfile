FROM maven:3.3-jdk-8

VOLUME "$(pwd)":/usr/src/mymaven

WORKDIR /usr/src/mymaven

RUN mvn clean install


