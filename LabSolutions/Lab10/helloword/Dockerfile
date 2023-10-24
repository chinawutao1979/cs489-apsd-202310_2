# Using OpenJDK version 18 as the base image
FROM openjdk:18
# Create a new app directory in the container for the application files
RUN mkdir /app
# Copy the compiled executable files/folders from host machine filesystem to the container/image's filesystem
COPY target/helloword-1.0-SNAPSHOT.jar /app
# Set the working directory for where next commands will execute at
WORKDIR /app
# Define the command to run the app when the contain is started
CMD ["java", "-jar", "./helloword-1.0-SNAPSHOT.jar"]
