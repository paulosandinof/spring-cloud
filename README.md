# Spring Cloud

A repository with some microservices using Spring Cloud projects like Config Server, Eureka Server and OpenFeign.

- Config Server: The server for serving the configuration for the differents services. You'll need to create a git repository for storing the configuration.
- Eureka Server: The server for registering the microservices.
- Guest Service: The microservice with guests.
- Reservation Service: The microservice with reservations.
- Room Service: The microservice with rooms.
- Room Reservation Service: The microservice that joins the other services using OpenFeign client.

# Running the application

You can run the applications changing to the folder of each microservice and running the command:
```bash
./mvnw spring-boot:run
```

You should run the config server first, then the eureka server, and after those two are up, you run each microservice.
