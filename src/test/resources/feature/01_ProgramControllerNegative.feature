Feature: ProgramController Module Test with Invalid Data

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 201 Created Status with response body
 

Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 Given Admin creates POST Request for the LMS with request body
 When Admin send HTTPS Request and  request Body with endpoint
 Then Admin receives 401 Unauthorized
 
 Scenario: Check if Admin able to create a program with invalid endpoint
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and the request Body with endpoint
 Then Admin receives 404 not found  Status with message and boolean success details
 
 Scenario: Check if Admin able to create a program with already existing program name 
 Given Admin creates POST Request for LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 400 Bad Request Status with message and boolean success details
 
 Scenario: Check if Admin able to create a program with invalid method
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and request Body with endpoint.
 Then Admin receives 405 Method Not Allowed 
 
 Scenario: Check if Admin able to create a program with invalid request body
 Given Admin creates POST Request for the LMS with invalid request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 400 Bad Request Status
 
 Scenario: Check if Admin able to create a program with missing values in the request body
 Given Admin creates POST Request for the LMS with missing values in request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 400 Bad Request Status
                                         
 Scenario: Check if Admin able to create a program with missing additional field 
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 200 ok        
 
 Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with invalid endpoint
 Then Admin receives 404 not found  Status with error message    
 
  Scenario: Check if Admin able to retrieve all programs with invalid Method
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with invalid method
 Then Admin receives 405 Method will Not Allowed 
 
  Scenario: Check if Admin able to retrieve all programs without Authorization
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request without Authorization 
 Then Admin receives 401 Status with response body as Unauthorized      
  
 
  Scenario: Check if Admin able to retrieve a program with invalid program ID 
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with invalid programID
 Then Admin receives 404 Not Found Status with message and boolean success details
 
 
  Scenario:Check if Admin able to retrieve a program with invalid baseURI
 Given Admin creates GET Request for the LMS API with invalid BaseURI
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 404 Not Found Status with message and boolean success details
 
  Scenario: Check if Admin able to retrieve a program without Authorization
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request to retrieve without Authorization
 Then Admin receives 401 Unauthorized
 
 
  Scenario: Check if Admin able to retrieve a program with invalid Endpoint
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with invalid Endpoint for program
 Then Admin receives 404 Not Found Status with message and boolean success details
 
 
Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
Given Admin create the GET Request for  LMS API
When Admin sends the HTTPS Request with the invalid endpoint
Then Admin receives 404 not found  Status with error message
 
 Scenario: Check if Admin able to retrieve all programs with invalid Method
Given Admin create the GET Request for  LMS API
When Admin sends the HTTPS Request with the invalid Method
Then Admin receives 405 Method Not Allowed   
 
 Scenario: Check if Admin able to retrieve all programs without Authorization
Given Admin create the GET Request for  LMS API
When Admin sends the HTTPS Request without Authorization
Then Admin receives 401 Status with response body as Unauthorized                                  


Scenario: Check if Admin able to update a program with  invalid program Name and request body
Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory and additional  fields
When Admin send HTTPS Request with invalid endpoint
Then Admin receives 404 Not Found Status with message and boolean success details
                                          
Scenario: Check if Admin able to update a program using valid program name - missing mandatory fields in request body 
Given Admin creates PUT Request for the LMS API  with missing mandatory fields 
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 400 Bad Request Status with message and boolean success details

 Scenario: Check if Admin able to update a program with  invalid values in request body 
Given Admin creates PUT Request for the LMS API endpoint  and  invalid program Name
When Admin sends HTTPS Request  and  request Body with mandatory fields.  
Then Admin receives 400 Bad Request Status with message and boolean success details 
   
   Scenario: Check if Admin able to update a program with  invalid program Description
Given Admin creates PUT Request for the LMS API endpoint  and  invalid program Description
When Admin sends HTTPS Request  and  request Body with mandatory fields.  
Then Admin receives 400 Bad Request Status with message and boolean success details
   
   Scenario: Check if Admin able to update a program status
Given Admin creates PUT Request for the LMS API endpoint  and  Valid program Name and status
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 200 OK Status with updated value in response body.                                            
   
   Scenario:Check if Admin able to update a program without Authorization
Given Admin creates PUT Request for the LMS API endpoint with valid request Body with the mandatory , additional  fields.
When Admin sends HTTPS Request with valid endpoint and without authorization
Then Admin receives 401 Unauthorized 
   

Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body
Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
When Admin sends HTTPS Request with valid endpoint and invalid programid
Then Admin receives 404 Not Found Status with message and boolean success details      

Scenario: Check if Admin able to update a program with invalid request body
Given Admin creates PUT Request for the LMS API  with invalid request body
When Admin sends HTTPS Request with invalid requestbody
Then Admin receives 400 Bad Request Status with message and boolean success details

Scenario: Check if Admin able to update a program without request body
Given Admin creates PUT Request for the LMS API  without request body
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 400 Bad Request Status with message and boolean success details

Scenario: Check if Admin able to update a program with invalid baseURI
Given Admin creates PUT Request for the LMS API endpoint with invalid baseuri
When Admin sends HTTPS the Request with valid endpoint
Then Admin receives 404 Not Found the Status with message and boolean success details

Scenario: Check if Admin able to update a program with invalid method
Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields
When Admin sends HTTPS Request for PUt with invalid method
Then Admin receives 405 Method Not Allowed 

Scenario: Check if Admin able to update a program without Authorization
Given Admin creates PUT Request for the LMS API endpoint with request Body  
When Admin sends HTTPS Request without the authorization
Then Admin receives 401 Unauthorized      


































 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  