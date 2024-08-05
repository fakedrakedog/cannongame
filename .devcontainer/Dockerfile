# Use Debian-based Eclipse Temurin OpenJDK 17
FROM eclipse-temurin:17-jdk

# Install Maven, Git and necessary packages for AWT and Swing
RUN apt-get update && \
    apt-get install -y \
    maven \
    git \
    libxext-dev \
    libxrender-dev \
    libxtst-dev \
    libxi-dev \
    libxt-dev \
    libx11-dev && \
    rm -rf /var/lib/apt/lists/* && \
    git config --global user.name "fakedrakedog" && \
    git config --global user.email "kkn8800@naver.com"

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Install Maven dependencies
RUN mvn dependency:resolve

# Command to run the Maven build
CMD ["mvn", "clean", "install"]
