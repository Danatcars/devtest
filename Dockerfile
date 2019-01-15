FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/cljtest.jar /cljtest/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/cljtest/app.jar"]
