Feature: POST REQUEST

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token


 Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
 Given Admin creates POST Request for the LMS with request body
 When Admin sends HTTPS Request and  request Body with endpoint
 Then Admin receives 201 Created Status with response body
 
 
 Scenario: Check if Admin able to retrieve all programs with valid Endpoint
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 200 OK Status with response body.                                                        
  