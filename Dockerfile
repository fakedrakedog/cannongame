# Use Alpine Linux with Eclipse Temurin OpenJDK 17
FROM eclipse-temurin:17-jdk-alpine

# Install Maven, Git and necessary packages for AWT and Swing
RUN apk update && \
    apk add --no-cache maven git libxext-dev libxrender-dev libxtst-dev

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Install Maven dependencies
RUN mvn dependency:resolve

# Command to run the Maven build
CMD ["mvn", "clean", "install"]
