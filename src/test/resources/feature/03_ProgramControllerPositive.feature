Feature: ProgramController Module Test with Valid Data

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token


Scenario: Check if Admin able to retrieve all programs with valid Endpoint
 Given Admins creates GET Request for the LMS API
 When Admins sends HTTPS Request with endpoint
 Then Admins receives 200 OK Status with response body.
 
 Scenario: Check if Admin able to retrieve a program with valid program ID
 Given Admins create GET Request for  LMS API
 When Admins send HTTPS Request with the endpoint
 Then Admins receives 200 OK Status with response body 
 
 Scenario: Check if Admin able to retrieve all programs with valid Endpoint
 Given Admins create the GET Request for  LMS API
 When Admins sends the HTTPS Request with endpoint
 Then Admins receive 200 OK Status with the response body     
 
      
Scenario: Check if Admin able to update a program with  Valid program Name and request body
Given Admins creates PUT Request for the LMS API endpoint with the valid request Body with mandatory , additional  fields.
When Admins sends HTTPS Request with the valid endpoint
Then Admins receives 200 OK Status with updated value in response body.                                           

Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body 
Given Admins creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields
When Admins sends HTTPS Request with valid endpoint
Then Admins receives 200 OK Status with updated value in response body 
