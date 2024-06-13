# Book Information Service
 The Book Information Service is a Spring Boot application that integrates with the Open Library Books API to fetch and display book details. It provides a RESTful endpoint that accepts JSON requests and returns JSON responses.
# Project Setup
 Built with Spring Boot
 Maven is used as the build tool
# External Book API
The service integrates with the Open Library Books API to fetch book details by ISBN. No API key is required for this API.

# Endpoints
`POST /book`
Accepts an ISBN in a JSON request
Returns book details in a JSON response

# Request

{
    "isbn": "1234567890"
}
Response
{
    "book_isbn": "1234567890",
    "title": "Fantastic Mr. Fox",
    "publishers": ["Penguin Books"],
    "authors": [
        {
            "name": "Roald Dahl"
        }
    ],
    "totalPages": 224,
    "publishedDate": "1970-11-12"
}
# Error Handling
Proper error handling for scenarios such as invalid ISBNs, missing book information, and connectivity problems
Meaningful HTTP status codes and error messages in JSON format
# Configuration
External configuration properties managed using application.properties or application.yml
# Testing
Unit tests for the service layer using JUnit and Mockito
Integration tests for the controller layer
# Build & Run
To build the project, run:

bash
mvn clean install
To run the application, execute:

bash
java -jar target/book-0.0.1-SNAPSHOT.jar

# Dependencies
Spring Boot Starter Web
Lombok
Spring Boot Starter Test
# Author
[Sachin Baghel]
