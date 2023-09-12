# restApi

Project Overview:

    Project:
        Simple implementation which provide a restApi with endpoints for searching,creating and deleting “server” objects
    Technology Stack:
       I used  Spring Boot as the technologies and dependencies are, such as Spring Web, Spring Data JPA, and the PostgreSQL database , Postman tool for client Request.
       
Database Configuration:

    Database Setup:
        I chose PostgreSQL as my database management system. PostgreSQL is an open-source relational database known for its reliability and robust features.

    Application Properties:
         configured the application properties to connect to the PostgreSQL database.
         these are the configuration ive done in application  properties, like set username ,password and load driver for postgres

        spring.datasource.driver-class-name=org.postgresql.Driver
        spring.datasource.url=jdbc:postgresql://localhost:5432/TestApi
        spring.datasource.username = postgres
        spring.datasource.password=1234

        spring.jpa.hibernate.ddl-auto=update(for create table if doesnt exist or update table if exist)
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
        
API Endpoints:

    1. Create (POST) Endpoint:
              Endpoint URL: /api/addservers
              HTTP Method: POST
              Description: This endpoint allows clients to create a new server record in the database.
              Example Request: pic 1

              ![pic 2](https://github.com/prashanth0143/restApi/assets/139949296/6dbdfb60-2d98-4446-a180-b97f0df1f724)

     2. Read (GET) Endpoints:

                Get All Servers Endpoint:
                Endpoint URL: /api/servers
                HTTP Method: GET
                Description: This endpoint retrieves a list of all server records from the database.
                Example Request: pic 2

     3. Get Server by ID Endpoint:

                  Endpoint URL: /api/getserver/{id}
                  HTTP Method: GET
                  Description: This endpoint retrieves a single server record by its unique ID.
                  Example Request: pic 3 


      4. get (GET) Listof server by name Endpoint:
              
                  Endpoint URL: /api/serves/{name}
                  HTTP Method: PUT or PATCH (depending on whether you're updating the entire record or specific fields)
                  Description: This endpoint allows clients to update an existing server record by its ID.
                  Example Request (PUT): pic 4 


      4. Delete (DELETE) By server ID Endpoint:

                  Endpoint URL: /api/server/{id}
                  HTTP Method: DELETE
                  Description: This endpoint allows clients to delete a server record by its ID and its return.
                  Example Request: pic 5


      
                  

