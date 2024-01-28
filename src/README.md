# Main Team Challenge Application

## Description
Main Team Challenge is a Spring Boot application designed to manage and evaluate player training data. This application allows you to calculate the main team based on specific criteria and store training data in a MongoDB database.

## Requirements
- JDK 17
- Gradle 7 or higher
- MongoDB 4.4 or higher

## Database Setup
1. Install and configure MongoDB on your system. You can find installation instructions on the [official MongoDB page](https://docs.mongodb.com/manual/installation/).
2. Ensure MongoDB is running on your system.

## Project Setup
1. Clone the project repository:
```
git clone https://github.com/kalexcamacho/mainTeamChallenge.git
```
2. Navigate to the cloned project directory.
3. Use Gradle to build the project:
```
./gradlew build

```

## Execution
To run the application, follow these steps:

1. Navigate to the project directory.
2. Run the following command:
```
./gradlew bootRun

```
3. The application should now be running and accessible at `http://localhost:8080`.

## Using the Application
- **Add Training Data:** You can add training data for players using a specific endpoint. Make a POST request with the required data.
- **Calculate Main Team:** To calculate the main team based on the established criteria, send a request to the corresponding endpoint.

## Endpoints
- `/addTrainingData` (POST): Add training data.
- `/calculateMainTeam` (POST): Calculate the main team.

## Author
- Kevin Alexander Camacho Bernal