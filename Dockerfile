FROM openjdk:8-jdk-alpine
FROM openjdk:12
ADD target/teamcity-mysql.jar teamcity-mysql.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "teamcity-mysql.jar"]