# Use a vulnerable base image
FROM ubuntu:14.04

# Use root user for all operations
USER root

# Install software with potential vulnerabilities and without verifying signatures
RUN apt-get update && \
    apt-get install -y wget curl git

# Install an outdated and vulnerable version of a software
RUN wget http://ftp.gnu.org/gnu/wget/wget-1.18.tar.gz && \
    tar -xzvf wget-1.18.tar.gz && \
    cd wget-1.18 && \
    ./configure && \
    make && \
    make install

# Set environment variables insecurely
ENV SECRET_KEY=mysecretpassword

# Copy sensitive data into the image
COPY id_rsa /root/.ssh/id_rsa

# Expose a sensitive port
EXPOSE 22

# Run a command that should not be run as root
CMD ["sh", "-c", "echo 'Running as root!' && /bin/bash"]