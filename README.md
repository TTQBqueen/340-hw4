# CRUD API

The REST API performs CRUD operations on Student objects as described below.

## Installation
- Get the project
    - clone
  
        `git clone https://https://github.com/TTQBqueen/CSC340_4-CRUD-API.git`
    - download zip.
- Open the project in IntelliJ.
- HW4/src/main/resources/application.properties
- 
- [`/src/main/resources/application.properties`]([(https://github.com/TTQBqueen/CSC340_4-CRUD-API/blob/deeddc6ccd3c397988a2a915db16a3764624e484/HW4/src/main/resources/application.properties)) file  is the configuration for the MySQL database on your localhost.
  - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case, the database name is `HomeWork4`.
  - You MUST have the database up and running before running the project! 
    - Open your XAMPP Control Panel.
    - Start the Apache server.
    - Start MySQL.
    - Click on MySQL "Admin" to open up the DBMS.
    - Ensure the database that you need is available.
- Build and run the main class. You should see 2 new tables created in the aforementioned database.

## API Endpoints
Use POSTMAN to try the following endpoints:

## Get the list of Animals

### Request

    `GET /animals/all`

    `http://localhost:8080/animals/all`

   
### Response

     [
   
     {"animalId": 1, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     {"animalId": 2, "name":"cat", "scientificName":"catis", "classification":"felin", "habitat":"my house", "description":"fuffy and cute"}, 
   
     {"animalId": 3, "name":"dog","scientificName":"dogis", "classification":"idk", "habitat":"the wild", "description":"its always what the dog doing, never hows the dog doing"}
   
     ]

## Get a specific Student

### Request

`GET /animals/{animalId}`

`http://localhost:8080/animals/1`

### Response

    {
      "animalId": 1, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"
    }

     
## Create a new Student

### Request

    `POST /animals/new`
    
    `http://localhost:8080/animals/new` --data '{"animalId": 1, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}'

   ### Response

   [
   
     {"animalId": 1, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     {"animalId": 2, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     { "animalId": 3, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"},

     { "animalId": 4, "name": "sample1", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}
   
  ]

## Get Animals by name

### Request

    `GET /students?major=csc`

    `http://localhost:8080/animals?name=cat`

   
### Response

     [
   
      {"animalId": 1, "name": "cat", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     ]

## Get search by part of animal name

### Request

    `GET /search?name=blue`

    `http://localhost:8080/animals/search?name=blue`

   
### Response

   [
   
     {"animalId": 1, "name": "blue jay", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     {"animalId": 2, "name": "blue frog","scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"},    
     
   ]

## Update an existing Student

### Request

    `PUT /animals/update/{animalId}`
    
    `http://localhost:8080/animals/update/1` --data '{ "name": "sampleUpdated", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}'

   ### Response
   
    {
      "animalId": 1, "name": "sampleUpdated", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"
    }


## Delete an existing Student

### Request

    `DELETE /animals/delete/{animalId}`
    
    `http://localhost:8080/animals/delete/1`

   ### Response
   
   [
   
     {"animalId": 2, "name": "sample2", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}, 
   
     { "animalId": 3, "name": "sample3", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"},

     { "animalId": 4, "name": "sample4", "scientificName":"sample1", "classification":"mammal", "habitat":"amazon", "description": "This is an animal deception"}
   
  ]
