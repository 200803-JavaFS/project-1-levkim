FROM tomcat:8-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY project1-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/project1-0.0.1-SNAPSHOT.war
CMD ["catalina.sh", "run"]