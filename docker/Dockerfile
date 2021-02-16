FROM adoptopenjdk:11
WORKDIR /
COPY build/libs/*.jar app.jar
COPY docker/execute.sh execute.sh
RUN chmod +x execute.sh
CMD ["sh", "execute.sh"]


