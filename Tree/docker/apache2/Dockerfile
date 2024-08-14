FROM ubuntu:20.04

LABEL Creator="Chunche"

RUN apt-get update && apt-get install apache2 -y && apt-get clean && rm -rf /var/lib/apt/lists/*

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2

EXPOSE 80
CMD [ "/usr/sbin/apache2", "-D", "FOREGROUND" ]

