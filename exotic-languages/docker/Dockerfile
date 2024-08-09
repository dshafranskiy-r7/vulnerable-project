FROM ubuntu:14.04

USER root


RUN apt-get update && \
    apt-get install -y wget curl git


RUN wget http://ftp.gnu.org/gnu/wget/wget-1.18.tar.gz && \
    tar -xzvf wget-1.18.tar.gz && \
    cd wget-1.18 && \
    ./configure && \
    make && \
    make install


ENV SECRET_KEY=mysecretpassword

COPY id_rsa /root/.ssh/id_rsa


EXPOSE 22

CMD ["sh", "-c", "echo 'Running as root!' && /bin/bash"]