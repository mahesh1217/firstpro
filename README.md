:Dynamic Event Ticketing System

A full-stack seat booking application that allows users to select and book seats dynamically with real-time seat status updates.

This project demonstrates:

- 10x10 seat grid rendering.
- Multi-seat selection.
- Dynamic pricing calculation.
- Backend seat booking with validation.
- Confirmation and success popups.
- Clean UI with responsive layout.

Tech Stack:
===========

## Frontend:
- React.js
- Axios
- CSS Grid

### Backend
- Spring Boot
- REST APIs
- In-memory data / H2 / MySQL (depending on your setup)

Build and run
============
If using Maven:

mvn clean install
mvn spring-boot:run

Backend will start at:
http://localhost:9090

Test API:
=========
Open browser:
http://localhost:9090/api/seats
