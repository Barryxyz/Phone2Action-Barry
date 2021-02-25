Web app that uses the Twilio API to register subscribers and message those subscribers.

This API allows the UI to add subscribers as well as send messages to those subscribers.

UI url: https://github.com/Barryxyz/Text-Subscription-App-UI

The technologies I used are:
1. Angular
2. Spring-boot/Java/Maven
4. MongoDB
5. Twilio API

To run both the UI and back-end, you will need:
1. Angular CLI: 9.1.7
2. Java Version: 1.8.0_251
3. Apache Maven: 3.6.3

To run my back-end application you will need to add MongoDB credentials for an empty collection and Twilio credentials onto the applications.properties file and run "mvn spring-boot: run" and it will be hosted on "localhost:8080". The UI can run by itself without the API although the subscribe and send messages to subscribers feature won't work without the API.

I also added an endpoint to clear the database collection: DELETE http://localhost:8080/subscribers
