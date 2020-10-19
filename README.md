# Phone2Action-Barry
Phone2Action Technical Assessment by Barry Chin

The technologies I used are:
1. Angular
2. Spring-boot/Java/Maven
4. MongoDb
5. Twilio Api

To run this you will need:
1. Angular CLI: 9.1.7
2. Java version "1.8.0_251"
3. Apache Maven 3.6.3

To run my back-end application you will need to go into the repo and run "mvn spring-boot: run" and it will be hosted on "localhost:8080"

The api by default is set to use my free trial Twilio account, so only verfied numbers that I added will be valid. 
You may edit the applications.properties file to user your own Twilio account to test other numbers.

I also added an endpoint to clear the database collection: DELETE http://localhost:8080/subscribers
