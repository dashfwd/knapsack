FROM eclipse-temurin:17.0.6_10-jdk AS runtime

# Install Microsoft fonts, needed because Excel uses these fonts
RUN apt update && \
    apt-get install -y --no-install-recommends ttf-mscorefonts-installer fontconfig && \
    fc-cache -f -v
MAINTAINER dashforward.it
COPY build/libs/knapsack-1.0-SNAPSHOT-all.jar app.jar
CMD ["sh", "-c", "java -jar app.jar"]