Feature: ProgramController Module Test with Invalid Data

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

 Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admins creates POST Request for the LMS with request body
 When Admins sends HTTPS Request and  request Body with endpoint
 Then Admins receives 201 Created Status with response body
 
  #
#
#Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
 #Given Admins creates POST Request for the LMS with request body
 #When Admins send HTTPS Request and  request Body with endpoint
 #Then Admins receives 401 Unauthorized
 #
 #Scenario: Check if Admin able to create a program with invalid endpoint
 #Given Admins creates POST Request for the LMS with request body
 #When Admins sends HTTPS Request and the request Body with endpoint
 #Then Admins receives 404 not found  Status with message and boolean success details
 #
 #Scenario: Check if Admin able to create a program with already existing program name 
 #Given Admins creates POST Request for LMS with request body
 #When Admins sends HTTPS Request and  request Body with endpoint
 #Then Admins receives 400 Bad Request Status with message and boolean success details
 #
 #Scenario: Check if Admin able to create a program with invalid method
 #Given Admins creates POST Request for the LMS with request body
 #When Admins sends HTTPS Request and request Body with endpoint.
 #Then Admins receives 405 Method Not Allowed 
 #
 #Scenario: Check if Admin able to create a program with invalid request body
 #Given Admins creates POST Request for the LMS with invalid request body
 #When Admins sends HTTPS Request and  request Body with endpoint
 #Then Admins receives 400 Bad Request Status
 #
 #Scenario: Check if Admin able to create a program with missing values in the request body
 #Given Admins creates POST Request for the LMS with missing values in request body
 #When Admins sends HTTPS Request and  request Body with endpoint
 #Then Admins receives 400 Bad Request Status
                                         #
 #Scenario: Check if Admin able to create a program with missing additional field 
 #Given Admins creates POST Request for the LMS with request body
 #When Admins sends HTTPS Request and  request Body with endpoint
 #Then Admins receives 200 ok        
 #
 #Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request with invalid endpoint
 #Then Admins receives 404 not found  Status with error message    
 #
  #Scenario: Check if Admin able to retrieve all programs with invalid Method
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request with invalid method
 #Then Admins receives 405 Method will Not Allowed 
 #
  #Scenario: Check if Admin able to retrieve all programs without Authorization
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request without Authorization 
 #Then Admins receives 401 Status with response body as Unauthorized      
  #
 #
  #Scenario: Check if Admin able to retrieve a program with invalid program ID 
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request with invalid programID
 #Then Admins receives 404 Not Found Status with message and boolean success details
 #
 #
  #Scenario:Check if Admin able to retrieve a program with invalid baseURI
 #Given Admins creates GET Request for the LMS API with invalid BaseURI
 #When Admins sends HTTPS Request with endpoint
 #Then Admins receives 404 Not Found Status with message and boolean success details
 #
  #Scenario: Check if Admin able to retrieve a program without Authorization
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request to retrieve without Authorization
 #Then Admins receives 401 Unauthorized
 #
 #
  #Scenario: Check if Admin able to retrieve a program with invalid Endpoint
 #Given Admins creates GET Request for the LMS API
 #When Admins sends HTTPS Request with invalid Endpoint for program
 #Then Admins receives 404 Not Found Status with message and boolean success details
 #
 #
#Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
#Given Admins create the GET Request for  LMS API
#When Admins sends the HTTPS Request with the invalid endpoint
#Then Admins receives 404 not found  Status with error message
 #
 #Scenario: Check if Admin able to retrieve all programs with invalid Method
#Given Admins create the GET Request for  LMS API
#When Admins sends the HTTPS Request with the invalid Method
#Then Admins receives 405 Method Not Allowed   
 #
 #Scenario: Check if Admin able to retrieve all programs without Authorization
#Given Admins create the GET Request for  LMS API
#When Admins sends the HTTPS Request without Authorization
#Then Admins receives 401 Status with response body as Unauthorized                                  
#
#
#Scenario: Check if Admin able to update a program with  invalid program Name and request body
#Given Admins creates PUT Request for the LMS API endpoint with valid request Body with mandatory and additional  fields
#When Admins send HTTPS Request with invalid endpoint
#Then Admins receives 404 Not Found Status with message and boolean success details
                                          #
#Scenario: Check if Admin able to update a program using valid program name - missing mandatory fields in request body 
#Given Admins creates PUT Request for the LMS API  with missing mandatory fields 
#When Admins sends HTTPS Request with valid endpoint
#Then Admins receives 400 Bad Request Status with message and boolean success details
#
 #Scenario: Check if Admin able to update a program with  invalid values in request body 
#Given Admins creates PUT Request for the LMS API endpoint  and  invalid program Name
#When Admins sends HTTPS Request  and  request Body with mandatory fields.  
#Then Admins receives 400 Bad Request Status with message and boolean success details 
   #
   #Scenario: Check if Admin able to update a program with  invalid program Description
#Given Admins creates PUT Request for the LMS API endpoint  and  invalid program Description
#When Admins sends HTTPS Request  and  request Body with mandatory fields.  
#Then Admins receives 400 Bad Request Status with message and boolean success details
   #
   #Scenario: Check if Admin able to update a program status
#Given Admins creates PUT Request for the LMS API endpoint  and  Valid program Name and status
#When Admins sends HTTPS Request with the valid endpoint
#Then Admins receives 200 OK Status with updated value in response body.                                            
   #
   #Scenario:Check if Admin able to update a program without Authorization
#Given Admins creates PUT Request for the LMS API endpoint with valid request Body with the mandatory , additional  fields.
#When Admins sends HTTPS Request with valid endpoint and without authorization
#Then Admins receives 401 Unauthorized 
   #
#
#Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body
#Given Admins creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
#When Admins sends HTTPS Request with valid endpoint and invalid programid
#Then Admins receives 404 Not Found Status with message and boolean success details      
#
#Scenario: Check if Admin able to update a program with invalid request body
#Given Admins creates PUT Request for the LMS API  with invalid request body
#When Admins sends HTTPS Request with invalid requestbody
#Then Admins receives 400 Bad Request Status with message and boolean success details
#
#Scenario: Check if Admin able to update a program without request body
#Given Admins creates PUT Request for the LMS API  without request body
#When Admins sends HTTPS Request with valid endpoint
#Then Admins receives 400 Bad Request Status with message and boolean success details
#
#Scenario: Check if Admin able to update a program with invalid baseURI
#Given Admins creates PUT Request for the LMS API endpoint with invalid baseuri
#When Admins sends HTTPS the Request with valid endpoint
#Then Admins receives 404 Not Found the Status with message and boolean success details
#
#Scenario: Check if Admin able to update a program with invalid method
#Given Admins creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields
#When Admins sends HTTPS Request for PUt with invalid method
#Then Admins receives 405 Method Not Allowed 
#
#Scenario: Check if Admin able to update a program without Authorization
#Given Admins creates PUT Request for the LMS API endpoint with request Body  
#When Admins sends HTTPS Request without the authorization
#Then Admins receives 401 Unauthorized      
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
 #
  