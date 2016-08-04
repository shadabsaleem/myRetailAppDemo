0. Table of Contents
==================================================================================

0. Table of Contents
1. Introduction
2. Business Requirement
3. System Requirement
4. Build Instructions
5. Assumptions
5. mvnForum License Agreement



1. Introduction - myRetail RESTful service
==================================================================================

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of 
client devices, from myRetail.com to native mobile apps. The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate 
product data from multiple sources and return it as JSON to the caller. 
Our goal is to create a RESTful service that can retrieve product and price details by ID.

2. Business Requirement
====================================================================================

Build an application that performs the following actions: 

- Responds GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 
	Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
	Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

- Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.

- Accepts a PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s 
   price in the data store.


3. System Requirement
==================================================================================

- Java/JDK 1.8
- Spring Boot
- Maven 4.0
- MongoDB 3.2


4. Build Instructions
==================================================================================
Application is supported through spring boot


5. Assumptions
==================================================================================

- The input data related to product information is pre populated while calling the service
- Security would be managed at the layer above this service call.
- There would be data security and authorization
- Logging and transactional management will be handled at the framework level 


Cheers!

Shadab