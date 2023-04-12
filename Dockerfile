FROM library/openjdk:17-jdk
MAINTAINER auditsight.com
COPY build/libs/knapsack-1.0-SNAPSHOT-all.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
