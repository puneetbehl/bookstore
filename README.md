# Grails 5.1.2 - Web Application Example

A sample Grails 5.1.2 application with example Dockerfile to deploy over standalone tomcat.

## Steps to Deploy and Run Application

1. Build application using command `./gradlew build`. 
2. Build Docker image using command `docker build -t bookstore:0.1 .`.
3. Start a new Docker container using command `docker run -it --rm -p 8080:8080 bookstore:0.1`.

